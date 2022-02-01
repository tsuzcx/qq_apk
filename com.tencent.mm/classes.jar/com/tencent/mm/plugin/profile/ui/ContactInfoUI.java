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
import com.tencent.mm.am.ag;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.b.a.jh;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.a;
import com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.ar;
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
  implements com.tencent.mm.al.f, f.a, com.tencent.mm.plugin.messenger.foundation.a.a.n.a, com.tencent.mm.plugin.story.api.g, k.a, n.b
{
  private am contact;
  private boolean htY;
  private int jfq;
  private com.tencent.mm.pluginsdk.ui.span.h oca;
  private String roomId;
  private com.tencent.mm.ui.base.preference.f screen;
  private c.a sgH;
  private String txJ;
  private com.tencent.mm.pluginsdk.b.a wPY;
  private boolean wPZ;
  private boolean wQa;
  private byte[] wQb;
  private boolean wQc;
  String wQd;
  private String wQe;
  private PullDownListView wQf;
  private boolean wQg;
  private AbsStoryGallery wQh;
  private AbsStoryMuteView wQi;
  private boolean wQj;
  private boolean wQk;
  private int wQl;
  private long wQm;
  private View.OnClickListener wQn;
  private PullDownListView.IPullDownCallback wQo;
  private View wQp;
  private View wQq;
  private boolean wQr;
  
  public ContactInfoUI()
  {
    AppMethodBeat.i(26982);
    this.wQc = false;
    this.wQd = null;
    this.wQe = "";
    this.roomId = "";
    this.wQf = null;
    this.wQg = false;
    this.wQh = null;
    this.wQi = null;
    this.wQj = false;
    this.wQk = false;
    this.htY = false;
    this.wQl = 0;
    this.wQm = 0L;
    this.wQn = null;
    this.wQo = new ContactInfoUI.1(this);
    this.oca = new ContactInfoUI.3(this);
    this.wQr = false;
    AppMethodBeat.o(26982);
  }
  
  private void dAw()
  {
    AppMethodBeat.i(26987);
    if ((this.wQp == null) || (!com.tencent.mm.ui.statusbar.c.KDc))
    {
      AppMethodBeat.o(26987);
      return;
    }
    com.tencent.mm.ui.statusbar.c localc = com.tencent.mm.ui.statusbar.c.bm(this);
    c.a local4 = new c.a()
    {
      public final void ua(int paramAnonymousInt)
      {
        AppMethodBeat.i(26971);
        if (ContactInfoUI.f(ContactInfoUI.this)) {
          ContactInfoUI.g(ContactInfoUI.this).setPadding(0, paramAnonymousInt, 0, 0);
        }
        AppMethodBeat.o(26971);
      }
    };
    this.sgH = local4;
    localc.a(local4);
    getWindow().getDecorView().requestApplyInsets();
    com.tencent.mm.ui.statusbar.d.b(getWindow());
    AppMethodBeat.o(26987);
  }
  
  private void dAx()
  {
    AppMethodBeat.i(27003);
    if (com.tencent.mm.compatible.util.d.ly(19))
    {
      getWindow().clearFlags(201327616);
      AppMethodBeat.o(27003);
      return;
    }
    getWindow().clearFlags(1024);
    AppMethodBeat.o(27003);
  }
  
  private void dAy()
  {
    AppMethodBeat.i(27006);
    if (this.htY)
    {
      t.makeText(aj.getContext(), getResources().getString(2131764289), 0).show();
      AppMethodBeat.o(27006);
      return;
    }
    if ((this.wQj) && (this.wQf != null)) {
      this.wQf.fMF();
    }
    AppMethodBeat.o(27006);
  }
  
  private void dAz()
  {
    boolean bool = true;
    AppMethodBeat.i(27007);
    ad.i("MicroMsg.ContactInfoUI", "updateUIByStory: %s %s", new Object[] { Boolean.valueOf(this.wQg), Boolean.valueOf(this.wQj) });
    NormalProfileHeaderPreference localNormalProfileHeaderPreference;
    if ((this.wQj) && (!this.htY))
    {
      dAw();
      setActionbarColor(getContext().getResources().getColor(2131101053));
      setMMTitle("");
      if (this.wQf != null)
      {
        this.wQf.setBackground(com.tencent.mm.ui.aq.aM(getContext(), 2130969307));
        this.wQf.setSupportOverscroll(true);
      }
      if (this.wQq != null) {
        this.wQq.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26968);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactInfoUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ad.i("MicroMsg.ContactInfoUI", "onClick: actionBarClick action_bar_root");
            ContactInfoUI.m(ContactInfoUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactInfoUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26968);
          }
        });
      }
      if (this.screen != null)
      {
        localNormalProfileHeaderPreference = (NormalProfileHeaderPreference)this.screen.aVD("contact_profile_header_normal");
        if (localNormalProfileHeaderPreference != null) {
          if ((!this.wQj) || (this.htY)) {
            break label280;
          }
        }
      }
    }
    for (;;)
    {
      localNormalProfileHeaderPreference.N(bool, this.wQq.getHeight());
      AppMethodBeat.o(27007);
      return;
      getWindow().clearFlags(-2147483648);
      setActionbarColor(getContext().getResources().getColor(2131099650));
      setMMTitle("");
      if (this.wQf != null)
      {
        this.wQf.setBackground(com.tencent.mm.ui.aq.aM(getContext(), 2130969308));
        this.wQf.setSupportOverscroll(false);
      }
      if (this.wQp == null) {
        break;
      }
      this.wQp.setPadding(0, 0, 0, 0);
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
  
  public final void a(bk parambk)
  {
    AppMethodBeat.i(193252);
    com.tencent.mm.sdk.platformtools.aq.f(new ContactInfoUI.b(this, parambk));
    AppMethodBeat.o(193252);
  }
  
  public final void a(cf paramcf)
  {
    AppMethodBeat.i(27001);
    com.tencent.mm.sdk.platformtools.aq.f(new ContactInfoUI.c(this, paramcf));
    AppMethodBeat.o(27001);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(27000);
    new ap().post(new ContactInfoUI.a(this, paramString));
    AppMethodBeat.o(27000);
  }
  
  public final void dAt()
  {
    AppMethodBeat.i(26983);
    ad.i("MicroMsg.ContactInfoUI", "story_cat storyUINoStory");
    this.wQj = false;
    if ((this.wQf != null) && (!this.wQf.isVisible))
    {
      showTitleView();
      dAx();
      this.wQf.fME();
    }
    dAz();
    AppMethodBeat.o(26983);
  }
  
  public final void dAu()
  {
    AppMethodBeat.i(26984);
    ad.i("MicroMsg.ContactInfoUI", "story_cat storyUIHasStory");
    this.wQj = true;
    if ((this.wQf != null) && (this.wQf.isVisible)) {
      dAz();
    }
    AppMethodBeat.o(26984);
  }
  
  public final void dAv()
  {
    AppMethodBeat.i(26985);
    ad.i("MicroMsg.ContactInfoUI", "story_cat storyUIBackPressed");
    this.wQf.fME();
    AppMethodBeat.o(26985);
  }
  
  public void finish()
  {
    AppMethodBeat.i(27008);
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.ASt;
    com.tencent.mm.plugin.story.h.h.ejZ().elh = 0L;
    super.finish();
    AppMethodBeat.o(27008);
  }
  
  public String getIdentString()
  {
    AppMethodBeat.i(26995);
    if ((this.contact == null) || ((int)this.contact.gfj == 0) || (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.contact.field_username)))
    {
      AppMethodBeat.o(26995);
      return "";
    }
    ad.i("MicroMsg.ContactInfoUI", "getIdentityString %s", new Object[] { this.contact.field_username });
    if (com.tencent.mm.am.g.vd(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_EnterpriseChat";
    }
    if (com.tencent.mm.am.g.DQ(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_EnterpriseFatherBiz";
    }
    if (com.tencent.mm.am.g.DP(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_EnterpriseChildBiz";
    }
    if (this.contact.fqg())
    {
      AppMethodBeat.o(26995);
      return "_bizContact";
    }
    if (w.vF(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_chatroom";
    }
    if (w.zs(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_bottle";
    }
    if (w.zt(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_QQ";
    }
    if (w.Ap(this.contact.field_username))
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
    this.txJ = getIntent().getStringExtra("Verify_ticket");
    this.wPZ = getIntent().getBooleanExtra("Chat_Readonly", false);
    this.wQa = getIntent().getBooleanExtra("User_Verify", false);
    this.roomId = getIntent().getStringExtra("Contact_ChatRoomId");
    String str1 = com.tencent.mm.sdk.platformtools.bt.nullAsNil(getIntent().getStringExtra("Contact_User"));
    Object localObject5 = com.tencent.mm.sdk.platformtools.bt.nullAsNil(getIntent().getStringExtra("Contact_Alias"));
    Object localObject1 = com.tencent.mm.sdk.platformtools.bt.nullAsNil(getIntent().getStringExtra("Contact_Encryptusername"));
    if (str1.endsWith("@stranger")) {
      localObject1 = str1;
    }
    ba.aBQ();
    this.contact = com.tencent.mm.model.c.azp().Bf(str1);
    this.jfq = getIntent().getIntExtra("Contact_Scene", 9);
    if (this.contact != null) {
      this.contact.IJW = str1;
    }
    com.tencent.mm.plugin.profile.b.iRH.a(this.contact);
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
    this.wQe = getIntent().getStringExtra("Contact_BrandIconURL");
    String str9 = getIntent().getStringExtra("Contact_RegionCode");
    this.wQb = getIntent().getByteArrayExtra("Contact_customInfo");
    int i1 = getIntent().getIntExtra("Contact_Ext_Flag", 0);
    boolean bool2 = getIntent().getBooleanExtra("force_get_contact", false);
    ad.i("MicroMsg.ContactInfoUI", "dkverify forceGetContact:%s  user:%s  roomid:%s ", new Object[] { Boolean.valueOf(bool2), str1, this.roomId });
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
      ad.d("MicroMsg.ContactInfoUI", "initView, forceGetContact, user = ".concat(String.valueOf(str1)));
      if ((this.contact != null) && (com.tencent.mm.o.b.lM(this.contact.field_type))) {
        as.a.hFO.aI(str1, this.roomId);
      }
    }
    else
    {
      if (((this.contact == null) || ((int)this.contact.gfj == 0)) && (am.aSQ(str1)) && (this.jfq != 15))
      {
        localObject4 = com.tencent.mm.sdk.platformtools.bt.nullAsNil(getIntent().getStringExtra(e.c.IUp));
        localObject2 = localObject4;
        if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject4)) {
          localObject2 = this.txJ;
        }
        com.tencent.mm.kernel.g.ajB().gAO.a(new com.tencent.mm.openim.b.h(str1, com.tencent.mm.sdk.platformtools.bt.nullAsNil(this.roomId), (String)localObject2), 0);
      }
      if ((this.contact != null) && ((int)this.contact.gfj > 0) && ((!w.Aq(this.contact.field_username)) || ((am.aSP(this.contact.field_username)) && (!w.zC(this.contact.field_username)))))
      {
        if ((!this.contact.fqk()) || (!am.aSQ(this.contact.field_username))) {
          break label2012;
        }
        localObject4 = com.tencent.mm.sdk.platformtools.bt.nullAsNil(getIntent().getStringExtra(e.c.IUp));
        localObject2 = localObject4;
        if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject4)) {
          localObject2 = this.txJ;
        }
        localObject8 = com.tencent.mm.kernel.g.ajB().gAO;
        String str10 = this.contact.field_username;
        if (!com.tencent.mm.o.b.lM(this.contact.field_type)) {
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
      if ((this.contact != null) && ((int)this.contact.gfj != 0) && (com.tencent.mm.sdk.platformtools.bt.nullAsNil(this.contact.field_username).length() > 0)) {
        break label2251;
      }
      this.contact = new am();
      this.contact.setUsername(str1);
      this.contact.sQ((String)localObject5);
      this.contact.sT((String)localObject6);
      this.contact.sU(getIntent().getStringExtra("Contact_PyInitial"));
      this.contact.sV(getIntent().getStringExtra("Contact_QuanPin"));
      this.contact.kf(j);
      this.contact.tl(str4);
      this.contact.tm((String)localObject7);
      this.contact.tk(str5);
      this.contact.kb(m);
      this.contact.tp(str6);
      this.contact.tn(str2);
      this.contact.to(str7);
      this.contact.ka(n);
      this.contact.sW(str8);
      this.contact.qr(l);
      this.contact.tf(str3);
      this.contact.tq(str9);
      this.contact.km(i1);
      if ((!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.wQd)) && (this.jfq == 15))
      {
        ba.aBQ();
        localObject5 = com.tencent.mm.model.c.azq().aqz(str1);
        localObject6 = new cf(str1);
        ((cf)localObject6).field_conRemark = ((cf)localObject5).field_conRemark;
        ((cf)localObject6).field_conDescription = ((cf)localObject5).field_conDescription;
        ((cf)localObject6).field_contactLabels = ((cf)localObject5).field_contactLabels;
        ((cf)localObject6).field_conPhone = this.wQd;
        ba.aBQ();
        com.tencent.mm.model.c.azq().replace((com.tencent.mm.sdk.e.c)localObject6);
        this.wQd = null;
      }
      this.contact.tz((String)localObject4);
      this.contact.kn(k);
      this.contact.tc((String)localObject2);
      if ((am.aSQ(this.contact.field_username)) && ((this.jfq == 30) || (this.jfq == 45) || (this.jfq == 17)))
      {
        localObject2 = com.tencent.mm.plugin.report.service.g.yhR;
        localObject4 = this.contact.field_openImAppid;
        if (this.jfq != 17) {
          break label2868;
        }
        i = 2;
        ((com.tencent.mm.plugin.report.service.g)localObject2).f(15320, new Object[] { localObject4, Integer.valueOf(i) });
      }
      if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject1)) {
        this.contact.sZ((String)localObject1);
      }
      if (this.contact != null) {
        break label2873;
      }
      ad.e("MicroMsg.ContactInfoUI", "contact = null");
      getIntent().putExtra("Contact_User", this.contact.field_username);
      if ((!bool2) && ((int)this.contact.gfj <= 0) && (this.contact.fqg()) && ((this.jfq == 17) || (this.jfq == 41)))
      {
        ad.d("MicroMsg.ContactInfoUI", "come from card, getContact %s", new Object[] { this.contact.field_username });
        as.a.hFO.aI(this.contact.field_username, "");
        com.tencent.mm.ak.c.CT(this.contact.field_username);
      }
      if (this.contact.ePD != null) {
        break label2983;
      }
      bool1 = true;
      label1470:
      if (this.contact.ePD != null) {
        break label2989;
      }
      i = 0;
      label1482:
      if (this.contact.ePD != null) {
        break label3003;
      }
    }
    label2868:
    label2873:
    label3003:
    for (localObject1 = "";; localObject1 = com.tencent.mm.sdk.platformtools.bt.aRp(this.contact.ePD))
    {
      ad.i("MicroMsg.ContactInfoUI", "contact.getRemarkDesc() (%s, %s, %s)", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), localObject1 });
      if ((!bool2) && ((int)this.contact.gfj <= 0) && (this.jfq == 96))
      {
        ad.i("MicroMsg.ContactInfoUI", "come from chatroom accessverify, getContact %s", new Object[] { this.contact.field_username });
        as.a.hFO.g(this.contact.field_username, 1, getIntent().getStringExtra("key_add_contact_verify_ticket"));
        com.tencent.mm.ak.c.ak(this.contact.field_username, 3);
      }
      if (this.contact.field_username.equals(u.aAm()))
      {
        ba.aBQ();
        l = com.tencent.mm.sdk.platformtools.bt.getLong((String)com.tencent.mm.model.c.ajl().get(65825, null), 0L);
        if (l > 0L)
        {
          this.contact.qr(l);
          localObject1 = this.contact;
          ba.aBQ();
          ((am)localObject1).tf((String)com.tencent.mm.model.c.ajl().get(65826, null));
        }
        localObject1 = this.contact;
        ba.aBQ();
        ((am)localObject1).tt((String)com.tencent.mm.model.c.ajl().get(286721, null));
        localObject1 = this.contact;
        ba.aBQ();
        ((am)localObject1).tu((String)com.tencent.mm.model.c.ajl().get(286722, null));
        localObject1 = this.contact;
        ba.aBQ();
        ((am)localObject1).tv((String)com.tencent.mm.model.c.ajl().get(286723, null));
      }
      if ((this.contact.field_username != null) && (this.contact.field_username.equals(am.aSZ(u.aAm()))))
      {
        localObject1 = com.tencent.mm.model.bt.aCv();
        localObject2 = com.tencent.mm.sdk.platformtools.bt.nullAsNil(((com.tencent.mm.model.bt)localObject1).getProvince());
        localObject4 = com.tencent.mm.sdk.platformtools.bt.nullAsNil(((com.tencent.mm.model.bt)localObject1).getCity());
        if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject2)) {
          this.contact.tl((String)localObject2);
        }
        if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject4)) {
          this.contact.tm((String)localObject4);
        }
        if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(((com.tencent.mm.model.bt)localObject1).countryCode)) {
          this.contact.tq(RegionCodeDecoder.bf(((com.tencent.mm.model.bt)localObject1).countryCode, ((com.tencent.mm.model.bt)localObject1).provinceCode, ((com.tencent.mm.model.bt)localObject1).cityCode));
        }
        i = com.tencent.mm.sdk.platformtools.bt.a(Integer.valueOf(((com.tencent.mm.model.bt)localObject1).ePk), 0);
        localObject1 = com.tencent.mm.sdk.platformtools.bt.nullAsNil(((com.tencent.mm.model.bt)localObject1).signature);
        this.contact.kf(i);
        this.contact.tk((String)localObject1);
      }
      if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.contact.field_username)) {
        break label3018;
      }
      ad.e("MicroMsg.ContactInfoUI", "username is null %s", new Object[] { str1 });
      finish();
      AppMethodBeat.o(26996);
      return;
      as.a.hFO.aI(str1, "");
      break;
      label2000:
      localObject4 = com.tencent.mm.sdk.platformtools.bt.nullAsNil(this.roomId);
      break label760;
      label2012:
      localObject2 = com.tencent.mm.am.g.eS(this.contact.field_username);
      if ((this.contact.fqg()) && (com.tencent.mm.am.a.aFr()))
      {
        i = 1;
        label2042:
        if ((localObject2 != null) && ((!((com.tencent.mm.api.c)localObject2).Kh()) || (i != 0))) {
          break label2148;
        }
        ad.d("MicroMsg.ContactInfoUI", "update contact, verifyFlag %d.", new Object[] { Integer.valueOf(m) });
        localObject4 = as.a.hFO;
        localObject8 = this.contact.field_username;
        if (!com.tencent.mm.o.b.lM(this.contact.field_type)) {
          break label2139;
        }
      }
      label2139:
      for (localObject2 = "";; localObject2 = this.roomId)
      {
        ((as.b)localObject4).aI((String)localObject8, (String)localObject2);
        com.tencent.mm.ak.c.CT(this.contact.field_username);
        break;
        i = 0;
        break label2042;
      }
      label2148:
      if ((!this.contact.fqk()) || (i != 0)) {
        break label780;
      }
      ad.d("MicroMsg.ContactInfoUI", "update contact, last check time=%d", new Object[] { Integer.valueOf(this.contact.ePB) });
      localObject4 = as.a.hFO;
      localObject8 = this.contact.field_username;
      if (com.tencent.mm.o.b.lM(this.contact.field_type)) {}
      for (localObject2 = "";; localObject2 = this.roomId)
      {
        ((as.b)localObject4).aI((String)localObject8, (String)localObject2);
        com.tencent.mm.ak.c.CT(this.contact.field_username);
        break;
      }
      label2251:
      if (this.contact.ePk == 0) {
        this.contact.kf(j);
      }
      if ((str4 != null) && (!str4.equals(""))) {
        this.contact.tl(str4);
      }
      if ((localObject7 != null) && (!((String)localObject7).equals(""))) {
        this.contact.tm((String)localObject7);
      }
      if ((str9 != null) && (!str9.equals(""))) {
        this.contact.tq(str9);
      }
      if ((com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.contact.signature)) && (str5 != null) && (!str5.equals(""))) {
        this.contact.tk(str5);
      }
      if (m != 0) {
        this.contact.kb(m);
      }
      if ((com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.contact.ePz)) && (str6 != null) && (!str6.equals(""))) {
        this.contact.tp(str6);
      }
      if ((com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.contact.field_nickname)) && (localObject6 != null) && (!((String)localObject6).equals(""))) {
        this.contact.sT((String)localObject6);
      }
      ad.i("MicroMsg.ContactInfoUI", "searchMobilePhone:%s", new Object[] { com.tencent.mm.sdk.platformtools.bt.nullAsNil(this.wQd) });
      if ((!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.wQd)) && (this.jfq == 15))
      {
        j = 1;
        str4 = this.contact.ePJ;
        i = j;
        if (str4 != null)
        {
          localObject7 = com.tencent.mm.o.a.e(this.contact);
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
          if (localObject7[j].equals(this.wQd)) {
            i = 0;
          }
        }
        else
        {
          if (i != 0)
          {
            this.contact.tx(str4 + this.wQd + com.tencent.mm.o.a.d(this.contact));
            this.wQd = null;
          }
          ad.i("MicroMsg.ContactInfoUI", "contact PhoneList:%s", new Object[] { com.tencent.mm.sdk.platformtools.bt.nullAsNil(this.contact.ePJ) });
          this.contact.setSource(15);
          this.contact.tn(str2);
          this.contact.qr(l);
          this.contact.tf(str3);
          if (!com.tencent.mm.o.b.lM(this.contact.field_type))
          {
            if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject5)) {
              this.contact.sQ((String)localObject5);
            }
            if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject6)) {
              this.contact.sT((String)localObject6);
            }
            localObject5 = getIntent().getStringExtra("Contact_PyInitial");
            if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject5)) {
              this.contact.sU((String)localObject5);
            }
            localObject5 = getIntent().getStringExtra("Contact_QuanPin");
            if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject5)) {
              this.contact.sV((String)localObject5);
            }
          }
          if ((!com.tencent.mm.o.b.lM(this.contact.field_type)) && (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject4))) {
            this.contact.tz((String)localObject4);
          }
          if ((!com.tencent.mm.o.b.lM(this.contact.field_type)) && (k != 0)) {
            this.contact.kn(k);
          }
          if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject2)) {
            break;
          }
          this.contact.tc((String)localObject2);
          break;
        }
        j += 1;
      }
      i = 1;
      break label1290;
      if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject1))
      {
        ba.aBQ();
        localObject1 = com.tencent.mm.model.c.azq().aqz((String)localObject1);
        if ((localObject1 != null) && (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(((cf)localObject1).field_encryptUsername)))
        {
          this.contact.sR(((cf)localObject1).field_conRemark);
          break label1346;
        }
      }
      if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str1)) {
        break label1346;
      }
      ba.aBQ();
      localObject1 = com.tencent.mm.model.c.azq().aqz(str1);
      if ((localObject1 == null) || (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(((cf)localObject1).field_encryptUsername))) {
        break label1346;
      }
      this.contact.sR(((cf)localObject1).field_conRemark);
      break label1346;
      bool1 = false;
      break label1470;
      i = this.contact.ePD.length();
      break label1482;
    }
    label2983:
    label2989:
    label3018:
    setMMTitle("");
    Object localObject4 = this.wQe;
    if (w.zw(this.contact.field_username))
    {
      this.wPY = ((com.tencent.mm.plugin.wxpaysdk.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.wxpaysdk.api.c.class)).gJ(this);
      localObject1 = new jh();
      ((jh)localObject1).erT = 2L;
      ((jh)localObject1).aLk();
      if (this.wPY != null)
      {
        this.wPY.a(this.screen, this.contact, this.wPZ, this.jfq);
        localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Ju(this.contact.field_username);
        localObject1 = "";
        if (localObject2 != null) {
          localObject1 = com.tencent.mm.sdk.platformtools.bt.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).aSD()).replace(" ", "");
        }
        if ((!this.wQr) && (com.tencent.mm.o.b.lM(this.contact.field_type)) && ((this.wPY instanceof k)))
        {
          j = com.tencent.mm.o.a.f(this.contact);
          if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject1)) {
            break label5076;
          }
          i = 0;
          label3208:
          j = i + j;
          localObject2 = com.tencent.mm.plugin.report.service.g.yhR;
          localObject4 = this.contact.field_username;
          if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject1)) {
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
      this.wQr = true;
      if ((!(this.wPY instanceof k)) && (!(this.wPY instanceof c)) && (!(this.wPY instanceof ContactWidgetNewBizInfo)))
      {
        ba.aBQ();
        localObject1 = (String)com.tencent.mm.model.c.ajl().get(al.a.Izo, "");
        if (((String)localObject1).contains(this.contact.field_username))
        {
          localObject1 = ((String)localObject1).replaceAll(this.contact.field_username + ",*", "");
          ba.aBQ();
          com.tencent.mm.model.c.ajl().set(al.a.Izo, localObject1);
          ad.i("MicroMsg.ContactInfoUI", "mark plugin read, userName:%s, newVal:%s", new Object[] { this.contact.field_username, localObject1 });
          if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject1)) {
            com.tencent.mm.z.c.aht().x(262158, false);
          }
        }
      }
      if (this.screen != null)
      {
        localObject1 = (NormalProfileHeaderPreference)this.screen.aVD("contact_profile_header_normal");
        if (localObject1 != null) {
          ((NormalProfileHeaderPreference)localObject1).N(this.wQj, this.wQq.getHeight());
        }
      }
      setBackBtn(new ContactInfoUI.6(this));
      p.aEz().CV(this.contact.field_username);
      if (((!w.zT(this.contact.field_username)) || (!u.aAK())) && ((!w.zL(this.contact.field_username)) || (!u.aAG())) && ((!w.zN(this.contact.field_username)) || (!u.aAQ())) && ((!w.zH(this.contact.field_username)) || (!u.aAU()))) {
        break label5089;
      }
      this.wQc = true;
      AppMethodBeat.o(26996);
      return;
      if (w.zx(this.contact.field_username))
      {
        this.wPY = ((com.tencent.mm.plugin.wxpaysdk.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.wxpaysdk.api.c.class)).gK(this);
        break;
      }
      if (w.zv(this.contact.field_username))
      {
        this.wPY = com.tencent.mm.bs.d.aa(this, "sport");
        break;
      }
      if (w.zH(this.contact.field_username))
      {
        this.wPY = com.tencent.mm.bs.d.aa(this, "qqmail");
        break;
      }
      if (w.zI(this.contact.field_username))
      {
        this.wPY = new e(this);
        break;
      }
      if (w.zJ(this.contact.field_username))
      {
        this.wPY = com.tencent.mm.bs.d.aa(this, "tmessage");
        break;
      }
      if (w.zV(this.contact.field_username))
      {
        this.wPY = new com.tencent.mm.plugin.topstory.ui.widget.a(this);
        break;
      }
      if (w.zB(this.contact.field_username))
      {
        this.wPY = new h(this);
        break;
      }
      if (w.zP(this.contact.field_username))
      {
        this.wPY = new m(this);
        break;
      }
      if (am.zs(this.contact.field_username))
      {
        this.wPY = new d(this);
        break;
      }
      if (w.zR(this.contact.field_username))
      {
        this.wPY = com.tencent.mm.bs.d.aa(this, "nearby");
        break;
      }
      if (w.zS(this.contact.field_username))
      {
        this.wPY = com.tencent.mm.bs.d.aa(this, "shake");
        break;
      }
      if (w.zT(this.contact.field_username))
      {
        this.wPY = new j(this);
        break;
      }
      if (w.zU(this.contact.field_username))
      {
        this.wPY = com.tencent.mm.bs.d.R(this, "readerapp", "widget_type_news");
        break;
      }
      if (w.Ac(this.contact.field_username))
      {
        this.wPY = com.tencent.mm.bs.d.R(this, "readerapp", "widget_type_weibo");
        break;
      }
      if (w.zM(this.contact.field_username))
      {
        this.wPY = new f(this);
        break;
      }
      if (w.zN(this.contact.field_username))
      {
        this.wPY = com.tencent.mm.bs.d.aa(this, "masssend");
        break;
      }
      if (w.zO(this.contact.field_username))
      {
        this.wPY = new g(this);
        break;
      }
      if ((this.contact.fqg()) || (getIntent().getBooleanExtra("key_use_new_contact_profile", false)))
      {
        for (localObject1 = null;; localObject1 = localObject2)
        {
          try
          {
            localObject2 = this.wQb;
            if (localObject2 != null) {
              break label4266;
            }
            localObject1 = null;
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.ContactInfoUI", localIOException, "", new Object[0]);
              continue;
              if (com.tencent.mm.am.g.DN(localIOException))
              {
                bool1 = true;
              }
              else
              {
                if (localObject1 != null)
                {
                  localObject3 = new com.tencent.mm.api.c();
                  ((com.tencent.mm.api.c)localObject3).field_extInfo = ((acf)localObject1).jdr;
                  ((com.tencent.mm.api.c)localObject3).field_type = ((com.tencent.mm.api.c)localObject3).bX(false).getServiceType();
                  if (((com.tencent.mm.api.c)localObject3).Kl())
                  {
                    bool1 = true;
                    continue;
                  }
                  if (((com.tencent.mm.api.c)localObject3).Kk())
                  {
                    bool1 = true;
                    continue;
                  }
                }
                if (getIntent().getBooleanExtra("key_use_new_contact_profile", false)) {
                  bool1 = true;
                } else if ((!com.tencent.mm.am.g.DQ(this.contact.field_username)) && (!com.tencent.mm.am.g.DP(this.contact.field_username)) && ((int)this.contact.gfj <= 0) && (this.contact.fqg()) && ((this.jfq == 17) || (this.jfq == 41))) {
                  bool1 = true;
                } else {
                  bool1 = false;
                }
              }
            }
            localObject1 = new c(this, (String)localObject4, (acf)localObject1);
            if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.txJ)) {
              break label4520;
            }
            ((c)localObject1).txJ = this.txJ;
            this.wPY = ((com.tencent.mm.pluginsdk.b.a)localObject1);
          }
          localObject2 = this.contact.field_username;
          if ((!aj.fkD().getBoolean("use_new_profile", true)) || (w.Ax((String)localObject2)) || (w.zQ((String)localObject2)) || (w.Ab((String)localObject2))) {
            break label4481;
          }
          if (!com.tencent.mm.am.g.DL((String)localObject2)) {
            break label4310;
          }
          bool1 = true;
          ad.i("MicroMsg.ContactInfoUI", "username:%s, isUseNewProfileUI:%b", new Object[] { this.contact.field_username, Boolean.valueOf(bool1) });
          if (!bool1) {
            break label4487;
          }
          localObject1 = new ContactWidgetNewBizInfo(this, (String)localObject4, (acf)localObject1, this.wQm);
          if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.txJ)) {
            ((ContactWidgetNewBizInfo)localObject1).txJ = this.txJ;
          }
          this.wPY = ((com.tencent.mm.pluginsdk.b.a)localObject1);
          break;
          localObject2 = (acf)new acf().parseFrom(this.wQb);
        }
        break;
      }
      if (w.zY(this.contact.field_username))
      {
        this.wPY = new n(this);
        break;
      }
      if (w.zZ(this.contact.field_username))
      {
        this.wPY = new i(this);
        break;
      }
      if (w.zA(this.contact.field_username))
      {
        this.wPY = new com.tencent.mm.plugin.downloader_app.d.a(this);
        break;
      }
      this.wPY = new com.tencent.mm.plugin.profile.a(this);
      if ((!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).isShowStoryCheck()) || (this.wQg)) {
        break;
      }
      ad.i("MicroMsg.ContactInfoUI", "setupStory %s stack %s", new Object[] { this, com.tencent.mm.sdk.platformtools.bt.flS().toString() });
      this.wQg = true;
      this.wQf = ((PullDownListView)getListView());
      this.wQf.setBackground(com.tencent.mm.ui.aq.aM(getContext(), 2130969307));
      this.wQf.KZC = this.wQo;
      i = -ar.ci(getContext()).y / 10;
      localObject1 = (RelativeLayout)findViewById(2131302325);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, ar.ci(getContext()).y);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = (-ar.ej(getContext()));
      if (this.contact.field_username.equals(u.aAm())) {}
      for (this.wQh = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(this, com.tencent.mm.plugin.story.api.n.a.AHX, this.roomId);; this.wQh = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(this, com.tencent.mm.plugin.story.api.n.a.AHY, this.roomId))
      {
        this.wQh.egJ();
        this.wQf.B(this.wQh, com.tencent.mm.cc.a.ay(getContext(), 2131166721), i);
        this.wQh.setStoryBrowseUIListener(this);
        this.wQh.setDataSeed(this.contact.field_username);
        this.wQh.a(this.wQf);
        ((RelativeLayout)localObject1).addView(this.wQh, 0, (ViewGroup.LayoutParams)localObject3);
        com.tencent.mm.kernel.g.ajD();
        this.wQi = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().gr(this);
        localObject3 = new RelativeLayout.LayoutParams(com.tencent.mm.cc.a.ay(getContext(), 2131166720), com.tencent.mm.cc.a.ay(getContext(), 2131166720));
        ((RelativeLayout.LayoutParams)localObject3).addRule(9);
        ((RelativeLayout.LayoutParams)localObject3).addRule(12);
        ((RelativeLayout)localObject1).addView(this.wQi, 0, (ViewGroup.LayoutParams)localObject3);
        this.wQf.setMuteView(this.wQi);
        this.wQf.setNavigationBarHeight(ar.ej(getContext()));
        this.wQn = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26977);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactInfoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ad.i("MicroMsg.ContactInfoUI", "onClick: NormalProfileHeaderPreference");
            ContactInfoUI.m(ContactInfoUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactInfoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26977);
          }
        };
        localObject1 = com.tencent.mm.plugin.story.h.h.ASt;
        com.tencent.mm.plugin.story.h.h.ejZ().elh = 3L;
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
    this.wQc = false;
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
    if (this.wPY != null) {
      this.wPY.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(26997);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(27005);
    if (((this.wQh == null) || (!this.wQh.onBackPressed())) && (!getSupportFragmentManager().isDestroyed())) {
      super.onBackPressed();
    }
    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.b(this.contact.field_username, 1501, this.jfq, this.wQm);
    AppMethodBeat.o(27005);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(26988);
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1) {
      this.htY = false;
    }
    for (;;)
    {
      if ((this.wQf != null) && (!this.wQf.isVisible)) {
        this.wQf.fME();
      }
      dAz();
      AppMethodBeat.o(26988);
      return;
      if (paramConfiguration.orientation == 2) {
        this.htY = true;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26986);
    ba.aBQ();
    am localam = com.tencent.mm.model.c.azp().Bf(com.tencent.mm.sdk.platformtools.bt.nullAsNil(getIntent().getStringExtra("Contact_User")));
    if (localam != null)
    {
      com.tencent.mm.kernel.g.ajD();
      if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(localam.field_username))
      {
        this.wQj = true;
        if (this.wQj) {
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
      this.htY = bool;
      this.wQm = System.currentTimeMillis();
      this.wQp = findViewById(2131296345);
      this.wQq = this.wQp.findViewById(2131296347);
      dAz();
      paramBundle = getWindow().getDecorView();
      paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x400 | 0x100);
      ad.i("MicroMsg.ContactInfoUI", "onCreate MMCore.accHasReady[%b]", new Object[] { Boolean.valueOf(ba.ajx()) });
      this.wQd = getIntent().getStringExtra("Contact_Search_Mobile");
      if (com.tencent.mm.kernel.g.ajA().aiK()) {
        break label232;
      }
      finish();
      AppMethodBeat.o(26986);
      return;
      this.wQj = false;
      break;
    }
    label232:
    ba.aBQ();
    com.tencent.mm.model.c.azp().a(this);
    ba.aBQ();
    com.tencent.mm.model.c.azq().a(this);
    ba.aBQ();
    com.tencent.mm.model.c.azr().a(this);
    initView();
    hideActionbarLine();
    if ((this.wPY instanceof com.tencent.mm.pluginsdk.b.b)) {
      ((com.tencent.mm.pluginsdk.b.b)this.wPY).onCreate();
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aG(getIntent())), Integer.valueOf(1), Integer.valueOf(1), this.contact.field_username });
    paramBundle = com.tencent.mm.plugin.story.h.h.ASt;
    com.tencent.mm.plugin.story.h.h.ejZ().emx = com.tencent.mm.plugin.profile.c.aG(getIntent());
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(273, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(291, this);
    AppMethodBeat.o(26986);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26989);
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.ASt;
    com.tencent.mm.plugin.story.h.h.ejZ().emx = 0L;
    if (com.tencent.mm.kernel.g.ajA().aiK())
    {
      ba.aBQ();
      com.tencent.mm.model.c.azp().b(this);
      ba.aBQ();
      com.tencent.mm.model.c.azq().b(this);
      ba.aBQ();
      com.tencent.mm.model.c.azr().b(this);
    }
    if (this.wPY == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.ContactInfoUI", "onDestroy bodyWidget is null?%s", new Object[] { Boolean.valueOf(bool) });
      if (this.wPY != null) {
        this.wPY.cdn();
      }
      if ((this.wPY instanceof com.tencent.mm.pluginsdk.b.b)) {
        ((com.tencent.mm.pluginsdk.b.b)this.wPY).agA();
      }
      if (o.zbS != null) {
        o.zbS.aD(this);
      }
      super.onDestroy();
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.b(273, this);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.b(291, this);
      if (this.wQh != null) {
        this.wQh.onDestroy();
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aG(getIntent())), Integer.valueOf(18), Integer.valueOf(1), this.contact.field_username });
      com.tencent.mm.plugin.report.service.g.yhR.f(17283, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aG(getIntent())), this.contact.field_username, Boolean.valueOf(this.wQj), Boolean.valueOf(this.wQk), Integer.valueOf(this.contact.uin), Integer.valueOf(this.wQl) });
      AppMethodBeat.o(26989);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26993);
    com.tencent.mm.modelstat.d.d(4, "ContactInfoUI" + getIdentString(), hashCode());
    ag.aFZ().remove(this);
    super.onPause();
    ba.ajF().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26972);
        ba.aBQ();
        com.tencent.mm.model.c.ajl().fqc();
        AppMethodBeat.o(26972);
      }
    });
    if (getIntent().getBooleanExtra("key_from_wesport_right_newtips", false))
    {
      com.tencent.mm.plugin.newtips.a.dun();
      com.tencent.mm.plugin.newtips.a.i.aq(com.tencent.mm.plugin.newtips.a.d.wsk, getActivityBrowseTimeMs());
    }
    for (;;)
    {
      dAx();
      if (this.wQh != null) {
        this.wQh.onPause();
      }
      if (((this.wPY instanceof c)) || ((this.wPY instanceof ContactWidgetNewBizInfo))) {
        this.wPY.cdn();
      }
      com.tencent.mm.pluginsdk.ui.span.k.b(this.oca);
      AppMethodBeat.o(26993);
      return;
      if (getIntent().getBooleanExtra("key_from_wesport_plugin_newtips", false))
      {
        com.tencent.mm.plugin.newtips.a.dun();
        com.tencent.mm.plugin.newtips.a.i.aq(com.tencent.mm.plugin.newtips.a.d.wsi, getActivityBrowseTimeMs());
      }
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(26998);
    paramf = paramPreference.mKey;
    ad.i("MicroMsg.ContactInfoUI", paramf + " item has been clicked!");
    if (this.wPY != null) {
      this.wPY.aaG(paramf);
    }
    if (paramPreference != null)
    {
      if (!paramPreference.mKey.equals("contact_info_sns")) {
        break label140;
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aG(getIntent())), Integer.valueOf(3), Integer.valueOf(1), this.contact.field_username });
    }
    for (;;)
    {
      if ((paramPreference instanceof NormalProfileHeaderPreference)) {
        dAy();
      }
      AppMethodBeat.o(26998);
      return false;
      label140:
      if (paramPreference.mKey.equals("contact_info_more")) {
        com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aG(getIntent())), Integer.valueOf(6), Integer.valueOf(1), this.contact.field_username });
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
        paramArrayOfString = (NormalUserFooterPreference)this.screen.aVD("contact_info_footer_normal");
        if (paramArrayOfString != null) {
          paramArrayOfString.dAY();
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
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/profile/ui/ContactInfoUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
        paramArrayOfString = (NormalUserFooterPreference)this.screen.aVD("contact_info_footer_normal");
        if (paramArrayOfString != null) {
          paramArrayOfString.dAX();
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
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/profile/ui/ContactInfoUI$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
    this.wQr = false;
    AppMethodBeat.o(26992);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26990);
    com.tencent.mm.modelstat.d.d(3, "ContactInfoUI" + getIdentString(), hashCode());
    ag.aFZ().add(this);
    super.onResume();
    Object localObject = ((ViewGroup)getContentView()).getFocusedChild();
    if (localObject != null)
    {
      ((View)localObject).clearFocus();
      ad.i("MicroMsg.ContactInfoUI", "try to clear focus. id:%s", new Object[] { Integer.valueOf(((View)localObject).getId()) });
    }
    this.wQf = ((PullDownListView)getListView());
    if (this.wQh != null) {
      this.wQh.onResume();
    }
    if (this.screen != null)
    {
      localObject = (NormalProfileHeaderPreference)this.screen.aVD("contact_profile_header_normal");
      if (localObject != null) {
        ((NormalProfileHeaderPreference)localObject).N(this.wQj, this.wQq.getHeight());
      }
    }
    if (((this.wPY instanceof c)) || ((this.wPY instanceof ContactWidgetNewBizInfo))) {
      this.wPY.a(this.screen, this.contact, this.wPZ, this.jfq);
    }
    com.tencent.mm.pluginsdk.ui.span.k.a(this.oca);
    AppMethodBeat.o(26990);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(27004);
    ad.d("MicroMsg.ContactInfoUI", "onSceneEnd errType[%s] errCode[%s] errMsg[%s] sceneType[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    if ((273 == paramn.getType()) && (this.contact != null) && ((this.wPY instanceof com.tencent.mm.plugin.profile.a)) && (com.tencent.mm.sdk.platformtools.bt.lQ(this.contact.field_username, ((com.tencent.mm.plugin.story.f.a.i)paramn).userName)))
    {
      int i = ((com.tencent.mm.plugin.story.f.a.i)paramn).dnh;
      paramString = com.tencent.mm.plugin.story.i.a.ATp;
      if (i == com.tencent.mm.plugin.story.i.a.ela())
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
        this.wQk = bool;
        this.wQl = ((com.tencent.mm.plugin.story.f.a.i)paramn).ALw;
        AppMethodBeat.o(27004);
        return;
        i = 0;
        break;
      }
    }
    if ((291 == paramn.getType()) && (this.contact != null)) {
      new ap().post(new ContactInfoUI.a(this, this.contact.field_username));
    }
    AppMethodBeat.o(27004);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(26991);
    super.onStart();
    if (this.wQh != null) {
      this.wQh.onStart();
    }
    AppMethodBeat.o(26991);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(26994);
    super.onStop();
    if (this.wQh != null) {
      this.wQh.onStop();
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