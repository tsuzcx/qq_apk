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
import com.tencent.mm.al.af;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.b.a.id;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.m.a;
import com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.plugin.story.api.n.a;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bz;
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
  implements com.tencent.mm.ak.g, m.a, com.tencent.mm.plugin.story.api.g, k.a, n.b
{
  private com.tencent.mm.storage.ai contact;
  private boolean hbQ;
  private int iMg;
  private com.tencent.mm.pluginsdk.ui.span.h nAR;
  private String roomId;
  private c.a rrB;
  private String sBi;
  private com.tencent.mm.ui.base.preference.f screen;
  private com.tencent.mm.pluginsdk.b.a vIR;
  private boolean vIS;
  private boolean vIT;
  private byte[] vIU;
  private boolean vIV;
  String vIW;
  private String vIX;
  private PullDownListView vIY;
  private boolean vIZ;
  private AbsStoryGallery vJa;
  private AbsStoryMuteView vJb;
  private boolean vJc;
  private boolean vJd;
  private int vJe;
  private View.OnClickListener vJf;
  private PullDownListView.IPullDownCallback vJg;
  private View vJh;
  private View vJi;
  private boolean vJj;
  
  public ContactInfoUI()
  {
    AppMethodBeat.i(26982);
    this.vIV = false;
    this.vIW = null;
    this.vIX = "";
    this.roomId = "";
    this.vIY = null;
    this.vIZ = false;
    this.vJa = null;
    this.vJb = null;
    this.vJc = false;
    this.vJd = false;
    this.hbQ = false;
    this.vJe = 0;
    this.vJf = null;
    this.vJg = new ContactInfoUI.1(this);
    this.nAR = new ContactInfoUI.3(this);
    this.vJj = false;
    AppMethodBeat.o(26982);
  }
  
  private void dpT()
  {
    AppMethodBeat.i(26987);
    if ((this.vJh == null) || (!com.tencent.mm.ui.statusbar.c.ILV))
    {
      AppMethodBeat.o(26987);
      return;
    }
    com.tencent.mm.ui.statusbar.c localc = com.tencent.mm.ui.statusbar.c.bm(this);
    c.a local4 = new c.a()
    {
      public final void tx(int paramAnonymousInt)
      {
        AppMethodBeat.i(26971);
        if (ContactInfoUI.f(ContactInfoUI.this)) {
          ContactInfoUI.g(ContactInfoUI.this).setPadding(0, paramAnonymousInt, 0, 0);
        }
        AppMethodBeat.o(26971);
      }
    };
    this.rrB = local4;
    localc.a(local4);
    getWindow().getDecorView().requestApplyInsets();
    com.tencent.mm.ui.statusbar.d.b(getWindow());
    AppMethodBeat.o(26987);
  }
  
  private void dpU()
  {
    AppMethodBeat.i(27003);
    if (com.tencent.mm.compatible.util.d.kZ(19))
    {
      getWindow().clearFlags(201327616);
      AppMethodBeat.o(27003);
      return;
    }
    getWindow().clearFlags(1024);
    AppMethodBeat.o(27003);
  }
  
  private void dpV()
  {
    AppMethodBeat.i(27006);
    if (this.hbQ)
    {
      t.makeText(com.tencent.mm.sdk.platformtools.ai.getContext(), getResources().getString(2131764289), 0).show();
      AppMethodBeat.o(27006);
      return;
    }
    if ((this.vJc) && (this.vIY != null)) {
      this.vIY.fvR();
    }
    AppMethodBeat.o(27006);
  }
  
  private void dpW()
  {
    boolean bool = true;
    AppMethodBeat.i(27007);
    ac.i("MicroMsg.ContactInfoUI", "updateUIByStory: %s %s", new Object[] { Boolean.valueOf(this.vIZ), Boolean.valueOf(this.vJc) });
    NormalProfileHeaderPreference localNormalProfileHeaderPreference;
    if ((this.vJc) && (!this.hbQ))
    {
      dpT();
      setActionbarColor(getContext().getResources().getColor(2131101053));
      setMMTitle("");
      if (this.vIY != null)
      {
        this.vIY.setBackground(com.tencent.mm.ui.ao.aI(getContext(), 2130969307));
        this.vIY.setSupportOverscroll(true);
      }
      if (this.vJi != null) {
        this.vJi.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26968);
            ac.i("MicroMsg.ContactInfoUI", "onClick: actionBarClick action_bar_root");
            ContactInfoUI.k(ContactInfoUI.this);
            AppMethodBeat.o(26968);
          }
        });
      }
      if (this.screen != null)
      {
        localNormalProfileHeaderPreference = (NormalProfileHeaderPreference)this.screen.aPN("contact_profile_header_normal");
        if (localNormalProfileHeaderPreference != null) {
          if ((!this.vJc) || (this.hbQ)) {
            break label280;
          }
        }
      }
    }
    for (;;)
    {
      localNormalProfileHeaderPreference.M(bool, this.vJi.getHeight());
      AppMethodBeat.o(27007);
      return;
      getWindow().clearFlags(-2147483648);
      setActionbarColor(getContext().getResources().getColor(2131099650));
      setMMTitle("");
      if (this.vIY != null)
      {
        this.vIY.setBackground(com.tencent.mm.ui.ao.aI(getContext(), 2130969308));
        this.vIY.setSupportOverscroll(false);
      }
      if (this.vJh == null) {
        break;
      }
      this.vJh.setPadding(0, 0, 0, 0);
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
      ac.i("MicroMsg.ContactInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(26999);
      return;
    }
    a((String)paramObject, null);
    AppMethodBeat.o(26999);
  }
  
  public final void a(bz parambz)
  {
    AppMethodBeat.i(27001);
    com.tencent.mm.sdk.platformtools.ap.f(new ContactInfoUI.b(this, parambz));
    AppMethodBeat.o(27001);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(27000);
    new com.tencent.mm.sdk.platformtools.ao().post(new ContactInfoUI.a(this, paramString));
    AppMethodBeat.o(27000);
  }
  
  public final void dpQ()
  {
    AppMethodBeat.i(26983);
    ac.i("MicroMsg.ContactInfoUI", "story_cat storyUINoStory");
    this.vJc = false;
    if ((this.vIY != null) && (!this.vIY.isVisible))
    {
      showTitleView();
      dpU();
      this.vIY.fvQ();
    }
    dpW();
    AppMethodBeat.o(26983);
  }
  
  public final void dpR()
  {
    AppMethodBeat.i(26984);
    ac.i("MicroMsg.ContactInfoUI", "story_cat storyUIHasStory");
    this.vJc = true;
    if ((this.vIY != null) && (this.vIY.isVisible)) {
      dpW();
    }
    AppMethodBeat.o(26984);
  }
  
  public final void dpS()
  {
    AppMethodBeat.i(26985);
    ac.i("MicroMsg.ContactInfoUI", "story_cat storyUIBackPressed");
    this.vIY.fvQ();
    AppMethodBeat.o(26985);
  }
  
  public void finish()
  {
    AppMethodBeat.i(27008);
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.zAU;
    com.tencent.mm.plugin.story.h.h.dXK().dUP = 0L;
    super.finish();
    AppMethodBeat.o(27008);
  }
  
  public String getIdentString()
  {
    AppMethodBeat.i(26995);
    if ((this.contact == null) || ((int)this.contact.fLJ == 0) || (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(this.contact.field_username)))
    {
      AppMethodBeat.o(26995);
      return "";
    }
    ac.i("MicroMsg.ContactInfoUI", "getIdentityString %s", new Object[] { this.contact.field_username });
    if (com.tencent.mm.al.f.so(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_EnterpriseChat";
    }
    if (com.tencent.mm.al.f.AR(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_EnterpriseFatherBiz";
    }
    if (com.tencent.mm.al.f.AQ(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_EnterpriseChildBiz";
    }
    if (this.contact.fad())
    {
      AppMethodBeat.o(26995);
      return "_bizContact";
    }
    if (w.sQ(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_chatroom";
    }
    if (w.ww(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_bottle";
    }
    if (w.wx(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_QQ";
    }
    if (w.xr(this.contact.field_username))
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
    this.sBi = getIntent().getStringExtra("Verify_ticket");
    this.vIS = getIntent().getBooleanExtra("Chat_Readonly", false);
    this.vIT = getIntent().getBooleanExtra("User_Verify", false);
    this.roomId = getIntent().getStringExtra("Contact_ChatRoomId");
    String str1 = com.tencent.mm.sdk.platformtools.bs.nullAsNil(getIntent().getStringExtra("Contact_User"));
    Object localObject5 = com.tencent.mm.sdk.platformtools.bs.nullAsNil(getIntent().getStringExtra("Contact_Alias"));
    Object localObject1 = com.tencent.mm.sdk.platformtools.bs.nullAsNil(getIntent().getStringExtra("Contact_Encryptusername"));
    if (str1.endsWith("@stranger")) {
      localObject1 = str1;
    }
    az.ayM();
    this.contact = com.tencent.mm.model.c.awB().aNt(str1);
    this.iMg = getIntent().getIntExtra("Contact_Scene", 9);
    if (this.contact != null) {
      this.contact.GWJ = str1;
    }
    com.tencent.mm.plugin.profile.b.iyy.a(this.contact);
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
    this.vIX = getIntent().getStringExtra("Contact_BrandIconURL");
    String str9 = getIntent().getStringExtra("Contact_RegionCode");
    this.vIU = getIntent().getByteArrayExtra("Contact_customInfo");
    int i2 = getIntent().getIntExtra("Contact_Ext_Flag", 0);
    boolean bool2 = getIntent().getBooleanExtra("force_get_contact", false);
    ac.i("MicroMsg.ContactInfoUI", "dkverify forceGetContact:%s  user:%s  roomid:%s ", new Object[] { Boolean.valueOf(bool2), str1, this.roomId });
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
      ac.d("MicroMsg.ContactInfoUI", "initView, forceGetContact, user = ".concat(String.valueOf(str1)));
      if ((this.contact != null) && (com.tencent.mm.n.b.ln(this.contact.field_type))) {
        ar.a.hnw.aJ(str1, this.roomId);
      }
    }
    else
    {
      if (((this.contact == null) || ((int)this.contact.fLJ == 0)) && (com.tencent.mm.storage.ai.aNc(str1)) && (this.iMg != 15))
      {
        localObject4 = com.tencent.mm.sdk.platformtools.bs.nullAsNil(getIntent().getStringExtra(e.c.HgZ));
        localObject3 = localObject4;
        if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject4)) {
          localObject3 = this.sBi;
        }
        com.tencent.mm.kernel.g.agQ().ghe.a(new com.tencent.mm.openim.b.h(str1, com.tencent.mm.sdk.platformtools.bs.nullAsNil(this.roomId), (String)localObject3), 0);
      }
      if ((this.contact != null) && ((int)this.contact.fLJ > 0) && ((!w.xs(this.contact.field_username)) || ((com.tencent.mm.storage.ai.aNb(this.contact.field_username)) && (!w.wF(this.contact.field_username)))))
      {
        if ((!this.contact.fah()) || (!com.tencent.mm.storage.ai.aNc(this.contact.field_username))) {
          break label2021;
        }
        localObject4 = com.tencent.mm.sdk.platformtools.bs.nullAsNil(getIntent().getStringExtra(e.c.HgZ));
        localObject3 = localObject4;
        if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject4)) {
          localObject3 = this.sBi;
        }
        localObject8 = com.tencent.mm.kernel.g.agQ().ghe;
        String str10 = this.contact.field_username;
        if (!com.tencent.mm.n.b.ln(this.contact.field_type)) {
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
      if ((this.contact != null) && ((int)this.contact.fLJ != 0) && (com.tencent.mm.sdk.platformtools.bs.nullAsNil(this.contact.field_username).length() > 0)) {
        break label2260;
      }
      this.contact = new com.tencent.mm.storage.ai();
      this.contact.setUsername(str1);
      this.contact.qg((String)localObject5);
      this.contact.qj((String)localObject6);
      this.contact.qk(getIntent().getStringExtra("Contact_PyInitial"));
      this.contact.ql(getIntent().getStringExtra("Contact_QuanPin"));
      this.contact.jH(j);
      this.contact.qB(str4);
      this.contact.qC((String)localObject7);
      this.contact.qA(str5);
      this.contact.jD(n);
      this.contact.qF(str6);
      this.contact.qD(str2);
      this.contact.setFromType(k);
      this.contact.qE(str7);
      this.contact.jC(i1);
      this.contact.qm(str8);
      this.contact.or(l);
      this.contact.qv(str3);
      this.contact.qG(str9);
      this.contact.jO(i2);
      if ((!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(this.vIW)) && (this.iMg == 15))
      {
        az.ayM();
        localObject5 = com.tencent.mm.model.c.awC().alK(str1);
        localObject6 = new bz(str1);
        ((bz)localObject6).field_conRemark = ((bz)localObject5).field_conRemark;
        ((bz)localObject6).field_conDescription = ((bz)localObject5).field_conDescription;
        ((bz)localObject6).field_contactLabels = ((bz)localObject5).field_contactLabels;
        ((bz)localObject6).field_conPhone = this.vIW;
        az.ayM();
        com.tencent.mm.model.c.awC().replace((com.tencent.mm.sdk.e.c)localObject6);
        this.vIW = null;
      }
      this.contact.qP((String)localObject4);
      this.contact.jP(m);
      this.contact.qs((String)localObject3);
      if ((com.tencent.mm.storage.ai.aNc(this.contact.field_username)) && ((this.iMg == 30) || (this.iMg == 45) || (this.iMg == 17)))
      {
        localObject3 = com.tencent.mm.plugin.report.service.h.wUl;
        localObject4 = this.contact.field_openImAppid;
        if (this.iMg != 17) {
          break label2887;
        }
        i = 2;
        ((com.tencent.mm.plugin.report.service.h)localObject3).f(15320, new Object[] { localObject4, Integer.valueOf(i) });
      }
      if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject1)) {
        this.contact.qp((String)localObject1);
      }
      if (this.contact != null) {
        break label2892;
      }
      ac.e("MicroMsg.ContactInfoUI", "contact = null");
      getIntent().putExtra("Contact_User", this.contact.field_username);
      if ((!bool2) && ((int)this.contact.fLJ <= 0) && (this.contact.fad()) && ((this.iMg == 17) || (this.iMg == 41)))
      {
        ac.d("MicroMsg.ContactInfoUI", "come from card, getContact %s", new Object[] { this.contact.field_username });
        ar.a.hnw.aJ(this.contact.field_username, "");
        com.tencent.mm.aj.c.zU(this.contact.field_username);
      }
      if (this.contact.eyf != null) {
        break label3002;
      }
      bool1 = true;
      label1480:
      if (this.contact.eyf != null) {
        break label3008;
      }
      i = 0;
      label1492:
      if (this.contact.eyf != null) {
        break label3022;
      }
    }
    label2051:
    label2887:
    label2892:
    label3022:
    for (localObject1 = "";; localObject1 = com.tencent.mm.sdk.platformtools.bs.aLJ(this.contact.eyf))
    {
      ac.i("MicroMsg.ContactInfoUI", "contact.getRemarkDesc() (%s, %s, %s)", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), localObject1 });
      if ((!bool2) && ((int)this.contact.fLJ <= 0) && (this.iMg == 96))
      {
        ac.i("MicroMsg.ContactInfoUI", "come from chatroom accessverify, getContact %s", new Object[] { this.contact.field_username });
        ar.a.hnw.aK(this.contact.field_username, getIntent().getStringExtra("key_add_contact_verify_ticket"));
        com.tencent.mm.aj.c.ag(this.contact.field_username, 3);
      }
      if (this.contact.field_username.equals(u.axw()))
      {
        az.ayM();
        l = com.tencent.mm.sdk.platformtools.bs.getLong((String)com.tencent.mm.model.c.agA().get(65825, null), 0L);
        if (l > 0L)
        {
          this.contact.or(l);
          localObject1 = this.contact;
          az.ayM();
          ((com.tencent.mm.storage.ai)localObject1).qv((String)com.tencent.mm.model.c.agA().get(65826, null));
        }
        localObject1 = this.contact;
        az.ayM();
        ((com.tencent.mm.storage.ai)localObject1).qJ((String)com.tencent.mm.model.c.agA().get(286721, null));
        localObject1 = this.contact;
        az.ayM();
        ((com.tencent.mm.storage.ai)localObject1).qK((String)com.tencent.mm.model.c.agA().get(286722, null));
        localObject1 = this.contact;
        az.ayM();
        ((com.tencent.mm.storage.ai)localObject1).qL((String)com.tencent.mm.model.c.agA().get(286723, null));
      }
      if ((this.contact.field_username != null) && (this.contact.field_username.equals(com.tencent.mm.storage.ai.aNh(u.axw()))))
      {
        localObject1 = com.tencent.mm.model.bs.azs();
        localObject3 = com.tencent.mm.sdk.platformtools.bs.nullAsNil(((com.tencent.mm.model.bs)localObject1).getProvince());
        localObject4 = com.tencent.mm.sdk.platformtools.bs.nullAsNil(((com.tencent.mm.model.bs)localObject1).getCity());
        if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject3)) {
          this.contact.qB((String)localObject3);
        }
        if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject4)) {
          this.contact.qC((String)localObject4);
        }
        if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(((com.tencent.mm.model.bs)localObject1).countryCode)) {
          this.contact.qG(RegionCodeDecoder.aW(((com.tencent.mm.model.bs)localObject1).countryCode, ((com.tencent.mm.model.bs)localObject1).provinceCode, ((com.tencent.mm.model.bs)localObject1).cityCode));
        }
        i = com.tencent.mm.sdk.platformtools.bs.a(Integer.valueOf(((com.tencent.mm.model.bs)localObject1).exL), 0);
        localObject1 = com.tencent.mm.sdk.platformtools.bs.nullAsNil(((com.tencent.mm.model.bs)localObject1).signature);
        this.contact.jH(i);
        this.contact.qA((String)localObject1);
      }
      if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(this.contact.field_username)) {
        break label3037;
      }
      ac.e("MicroMsg.ContactInfoUI", "username is null %s", new Object[] { str1 });
      finish();
      AppMethodBeat.o(26996);
      return;
      ar.a.hnw.aJ(str1, "");
      break;
      label2009:
      localObject4 = com.tencent.mm.sdk.platformtools.bs.nullAsNil(this.roomId);
      break label760;
      label2021:
      localObject3 = com.tencent.mm.al.f.dX(this.contact.field_username);
      if ((this.contact.fad()) && (com.tencent.mm.al.a.aCo()))
      {
        i = 1;
        if ((localObject3 != null) && ((!((com.tencent.mm.api.c)localObject3).IH()) || (i != 0))) {
          break label2157;
        }
        ac.d("MicroMsg.ContactInfoUI", "update contact, verifyFlag %d.", new Object[] { Integer.valueOf(n) });
        localObject4 = ar.a.hnw;
        localObject8 = this.contact.field_username;
        if (!com.tencent.mm.n.b.ln(this.contact.field_type)) {
          break label2148;
        }
      }
      label2148:
      for (localObject3 = "";; localObject3 = this.roomId)
      {
        ((ar.b)localObject4).aJ((String)localObject8, (String)localObject3);
        com.tencent.mm.aj.c.zU(this.contact.field_username);
        break;
        i = 0;
        break label2051;
      }
      label2157:
      if ((!this.contact.fah()) || (i != 0)) {
        break label780;
      }
      ac.d("MicroMsg.ContactInfoUI", "update contact, last check time=%d", new Object[] { Integer.valueOf(this.contact.eyc) });
      localObject4 = ar.a.hnw;
      localObject8 = this.contact.field_username;
      if (com.tencent.mm.n.b.ln(this.contact.field_type)) {}
      for (localObject3 = "";; localObject3 = this.roomId)
      {
        ((ar.b)localObject4).aJ((String)localObject8, (String)localObject3);
        com.tencent.mm.aj.c.zU(this.contact.field_username);
        break;
      }
      label2260:
      if (this.contact.exL == 0) {
        this.contact.jH(j);
      }
      if ((str4 != null) && (!str4.equals(""))) {
        this.contact.qB(str4);
      }
      if ((localObject7 != null) && (!((String)localObject7).equals(""))) {
        this.contact.qC((String)localObject7);
      }
      if ((str9 != null) && (!str9.equals(""))) {
        this.contact.qG(str9);
      }
      if ((com.tencent.mm.sdk.platformtools.bs.isNullOrNil(this.contact.signature)) && (str5 != null) && (!str5.equals(""))) {
        this.contact.qA(str5);
      }
      if (n != 0) {
        this.contact.jD(n);
      }
      if ((com.tencent.mm.sdk.platformtools.bs.isNullOrNil(this.contact.eya)) && (str6 != null) && (!str6.equals(""))) {
        this.contact.qF(str6);
      }
      if ((com.tencent.mm.sdk.platformtools.bs.isNullOrNil(this.contact.field_nickname)) && (localObject6 != null) && (!((String)localObject6).equals(""))) {
        this.contact.qj((String)localObject6);
      }
      ac.i("MicroMsg.ContactInfoUI", "searchMobilePhone:%s", new Object[] { com.tencent.mm.sdk.platformtools.bs.nullAsNil(this.vIW) });
      if ((!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(this.vIW)) && (this.iMg == 15))
      {
        j = 1;
        str4 = this.contact.eyl;
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
          if (localObject7[j].equals(this.vIW)) {
            i = 0;
          }
        }
        else
        {
          if (i != 0)
          {
            this.contact.qN(str4 + this.vIW + com.tencent.mm.n.a.d(this.contact));
            this.vIW = null;
          }
          ac.i("MicroMsg.ContactInfoUI", "contact PhoneList:%s", new Object[] { com.tencent.mm.sdk.platformtools.bs.nullAsNil(this.contact.eyl) });
          this.contact.setSource(15);
          this.contact.qD(str2);
          this.contact.setFromType(k);
          this.contact.or(l);
          this.contact.qv(str3);
          if (!com.tencent.mm.n.b.ln(this.contact.field_type))
          {
            if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject5)) {
              this.contact.qg((String)localObject5);
            }
            if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject6)) {
              this.contact.qj((String)localObject6);
            }
            localObject5 = getIntent().getStringExtra("Contact_PyInitial");
            if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject5)) {
              this.contact.qk((String)localObject5);
            }
            localObject5 = getIntent().getStringExtra("Contact_QuanPin");
            if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject5)) {
              this.contact.ql((String)localObject5);
            }
          }
          if ((!com.tencent.mm.n.b.ln(this.contact.field_type)) && (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject4))) {
            this.contact.qP((String)localObject4);
          }
          if ((!com.tencent.mm.n.b.ln(this.contact.field_type)) && (m != 0)) {
            this.contact.jP(m);
          }
          if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject3)) {
            break;
          }
          this.contact.qs((String)localObject3);
          break;
        }
        j += 1;
      }
      i = 1;
      break label1300;
      if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject1))
      {
        az.ayM();
        localObject1 = com.tencent.mm.model.c.awC().alK((String)localObject1);
        if ((localObject1 != null) && (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(((bz)localObject1).field_encryptUsername)))
        {
          this.contact.qh(((bz)localObject1).field_conRemark);
          break label1356;
        }
      }
      if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(str1)) {
        break label1356;
      }
      az.ayM();
      localObject1 = com.tencent.mm.model.c.awC().alK(str1);
      if ((localObject1 == null) || (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(((bz)localObject1).field_encryptUsername))) {
        break label1356;
      }
      this.contact.qh(((bz)localObject1).field_conRemark);
      break label1356;
      bool1 = false;
      break label1480;
      i = this.contact.eyf.length();
      break label1492;
    }
    label3002:
    label3008:
    label3037:
    setMMTitle("");
    Object localObject3 = this.vIX;
    if (w.wA(this.contact.field_username))
    {
      this.vIR = ((com.tencent.mm.plugin.wxpaysdk.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.wxpaysdk.api.c.class)).gF(this);
      localObject1 = new id();
      ((id)localObject1).ebn = 2L;
      ((id)localObject1).aHZ();
      if (this.vIR != null)
      {
        this.vIR.a(this.screen, this.contact, this.vIS, this.iMg);
        localObject3 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gf(this.contact.field_username);
        localObject1 = "";
        if (localObject3 != null) {
          localObject1 = com.tencent.mm.sdk.platformtools.bs.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject3).aPr()).replace(" ", "");
        }
        if ((!this.vJj) && (com.tencent.mm.n.b.ln(this.contact.field_type)) && ((this.vIR instanceof k)))
        {
          j = com.tencent.mm.n.a.f(this.contact);
          if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject1)) {
            break label5087;
          }
          i = 0;
          label3227:
          j = i + j;
          localObject3 = com.tencent.mm.plugin.report.service.h.wUl;
          localObject4 = this.contact.field_username;
          if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject1)) {
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
      this.vJj = true;
      if ((!(this.vIR instanceof k)) && (!(this.vIR instanceof c)) && (!(this.vIR instanceof ContactWidgetNewBizInfo)))
      {
        az.ayM();
        localObject1 = (String)com.tencent.mm.model.c.agA().get(ah.a.GMX, "");
        if (((String)localObject1).contains(this.contact.field_username))
        {
          localObject1 = ((String)localObject1).replaceAll(this.contact.field_username + ",*", "");
          az.ayM();
          com.tencent.mm.model.c.agA().set(ah.a.GMX, localObject1);
          ac.i("MicroMsg.ContactInfoUI", "mark plugin read, userName:%s, newVal:%s", new Object[] { this.contact.field_username, localObject1 });
          if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject1)) {
            com.tencent.mm.y.c.aeH().x(262158, false);
          }
        }
      }
      if (this.screen != null)
      {
        localObject1 = (NormalProfileHeaderPreference)this.screen.aPN("contact_profile_header_normal");
        if (localObject1 != null) {
          ((NormalProfileHeaderPreference)localObject1).M(this.vJc, this.vJi.getHeight());
        }
      }
      setBackBtn(new ContactInfoUI.6(this));
      p.aBy().zW(this.contact.field_username);
      if (((!w.wW(this.contact.field_username)) || (!u.axS())) && ((!w.wO(this.contact.field_username)) || (!u.axO())) && ((!w.wQ(this.contact.field_username)) || (!u.axX())) && ((!w.wK(this.contact.field_username)) || (!u.aya()))) {
        break label5100;
      }
      this.vIV = true;
      AppMethodBeat.o(26996);
      return;
      if (w.wB(this.contact.field_username))
      {
        this.vIR = ((com.tencent.mm.plugin.wxpaysdk.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.wxpaysdk.api.c.class)).gG(this);
        break;
      }
      if (w.wz(this.contact.field_username))
      {
        this.vIR = com.tencent.mm.br.d.ab(this, "sport");
        break;
      }
      if (w.wK(this.contact.field_username))
      {
        this.vIR = com.tencent.mm.br.d.ab(this, "qqmail");
        break;
      }
      if (w.wL(this.contact.field_username))
      {
        this.vIR = new e(this);
        break;
      }
      if (w.wM(this.contact.field_username))
      {
        this.vIR = com.tencent.mm.br.d.ab(this, "tmessage");
        break;
      }
      if (w.wY(this.contact.field_username))
      {
        this.vIR = new com.tencent.mm.plugin.topstory.ui.widget.a(this);
        break;
      }
      if (w.wE(this.contact.field_username))
      {
        this.vIR = new h(this);
        break;
      }
      if (w.wS(this.contact.field_username))
      {
        this.vIR = new m(this);
        break;
      }
      if (com.tencent.mm.storage.ai.ww(this.contact.field_username))
      {
        this.vIR = new d(this);
        break;
      }
      if (w.wU(this.contact.field_username))
      {
        this.vIR = com.tencent.mm.br.d.ab(this, "nearby");
        break;
      }
      if (w.wV(this.contact.field_username))
      {
        this.vIR = com.tencent.mm.br.d.ab(this, "shake");
        break;
      }
      if (w.wW(this.contact.field_username))
      {
        this.vIR = new j(this);
        break;
      }
      if (w.wX(this.contact.field_username))
      {
        this.vIR = com.tencent.mm.br.d.O(this, "readerapp", "widget_type_news");
        break;
      }
      if (w.xf(this.contact.field_username))
      {
        this.vIR = com.tencent.mm.br.d.O(this, "readerapp", "widget_type_weibo");
        break;
      }
      if (w.wP(this.contact.field_username))
      {
        this.vIR = new f(this);
        break;
      }
      if (w.wQ(this.contact.field_username))
      {
        this.vIR = com.tencent.mm.br.d.ab(this, "masssend");
        break;
      }
      if (w.wR(this.contact.field_username))
      {
        this.vIR = new g(this);
        break;
      }
      if ((this.contact.fad()) || (getIntent().getBooleanExtra("key_use_new_contact_profile", false)))
      {
        for (;;)
        {
          try
          {
            localObject1 = this.vIU;
            if (localObject1 != null) {
              continue;
            }
            localObject1 = null;
          }
          catch (IOException localIOException)
          {
            ac.printErrStackTrace("MicroMsg.ContactInfoUI", localIOException, "", new Object[0]);
            localObject2 = null;
            continue;
            if (!com.tencent.mm.al.f.AO((String)localObject4)) {
              continue;
            }
            bool1 = true;
            continue;
            if (localObject2 == null) {
              continue;
            }
            localObject4 = new com.tencent.mm.api.c();
            ((com.tencent.mm.api.c)localObject4).field_extInfo = ((aaf)localObject2).iKi;
            ((com.tencent.mm.api.c)localObject4).field_type = ((com.tencent.mm.api.c)localObject4).bV(false).getServiceType();
            if (!((com.tencent.mm.api.c)localObject4).IL()) {
              continue;
            }
            bool1 = true;
            continue;
            if (!((com.tencent.mm.api.c)localObject4).IK()) {
              continue;
            }
            bool1 = true;
            continue;
            if (!getIntent().getBooleanExtra("key_use_new_contact_profile", false)) {
              continue;
            }
            bool1 = true;
            continue;
            if ((com.tencent.mm.al.f.AR(this.contact.field_username)) || (com.tencent.mm.al.f.AQ(this.contact.field_username)) || ((int)this.contact.fLJ > 0) || (!this.contact.fad()) || ((this.iMg != 17) && (this.iMg != 41))) {
              continue;
            }
            bool1 = true;
            continue;
            bool1 = false;
            continue;
            localObject2 = new c(this, (String)localObject3, (aaf)localObject2);
            if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(this.sBi)) {
              continue;
            }
            ((c)localObject2).sBi = this.sBi;
            this.vIR = ((com.tencent.mm.pluginsdk.b.a)localObject2);
          }
          localObject4 = this.contact.field_username;
          if ((!com.tencent.mm.sdk.platformtools.ai.eUY().getBoolean("use_new_profile", true)) || (w.xz((String)localObject4)) || (w.wT((String)localObject4)) || (w.xe((String)localObject4))) {
            continue;
          }
          if (!com.tencent.mm.al.f.AM((String)localObject4)) {
            continue;
          }
          bool1 = true;
          ac.i("MicroMsg.ContactInfoUI", "username:%s, isUseNewProfileUI:%b", new Object[] { this.contact.field_username, Boolean.valueOf(bool1) });
          if (!bool1) {
            continue;
          }
          localObject1 = new ContactWidgetNewBizInfo(this, (String)localObject3, (aaf)localObject1);
          if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(this.sBi)) {
            ((ContactWidgetNewBizInfo)localObject1).sBi = this.sBi;
          }
          this.vIR = ((com.tencent.mm.pluginsdk.b.a)localObject1);
          break;
          localObject1 = (aaf)new aaf().parseFrom(this.vIU);
        }
        break;
      }
      if (w.xb(this.contact.field_username))
      {
        this.vIR = new n(this);
        break;
      }
      if (w.xc(this.contact.field_username))
      {
        this.vIR = new i(this);
        break;
      }
      if (w.wD(this.contact.field_username))
      {
        this.vIR = new com.tencent.mm.plugin.downloader_app.d.a(this);
        break;
      }
      this.vIR = new com.tencent.mm.plugin.profile.a(this);
      if ((!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).isShowStoryCheck()) || (this.vIZ)) {
        break;
      }
      ac.i("MicroMsg.ContactInfoUI", "setupStory %s stack %s", new Object[] { this, com.tencent.mm.sdk.platformtools.bs.eWi().toString() });
      this.vIZ = true;
      this.vIY = ((PullDownListView)getListView());
      this.vIY.setBackground(com.tencent.mm.ui.ao.aI(getContext(), 2130969307));
      this.vIY.Jim = this.vJg;
      i = -com.tencent.mm.ui.ap.cl(getContext()).y / 10;
      Object localObject2 = (RelativeLayout)findViewById(2131302325);
      localObject3 = new RelativeLayout.LayoutParams(-1, com.tencent.mm.ui.ap.cl(getContext()).y);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = (-com.tencent.mm.ui.ap.ej(getContext()));
      if (this.contact.field_username.equals(u.axw())) {}
      for (this.vJa = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(this, n.a.zqd, this.roomId);; this.vJa = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(this, n.a.zqe, this.roomId))
      {
        this.vJa.dUv();
        this.vIY.A(this.vJa, com.tencent.mm.cc.a.av(getContext(), 2131166721), i);
        this.vJa.setStoryBrowseUIListener(this);
        this.vJa.setDataSeed(this.contact.field_username);
        this.vJa.a(this.vIY);
        ((RelativeLayout)localObject2).addView(this.vJa, 0, (ViewGroup.LayoutParams)localObject3);
        com.tencent.mm.kernel.g.agS();
        this.vJb = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().go(this);
        localObject3 = new RelativeLayout.LayoutParams(com.tencent.mm.cc.a.av(getContext(), 2131166720), com.tencent.mm.cc.a.av(getContext(), 2131166720));
        ((RelativeLayout.LayoutParams)localObject3).addRule(9);
        ((RelativeLayout.LayoutParams)localObject3).addRule(12);
        ((RelativeLayout)localObject2).addView(this.vJb, 0, (ViewGroup.LayoutParams)localObject3);
        this.vIY.setMuteView(this.vJb);
        this.vIY.setNavigationBarHeight(com.tencent.mm.ui.ap.ej(getContext()));
        this.vJf = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26977);
            ac.i("MicroMsg.ContactInfoUI", "onClick: NormalProfileHeaderPreference");
            ContactInfoUI.k(ContactInfoUI.this);
            AppMethodBeat.o(26977);
          }
        };
        localObject2 = com.tencent.mm.plugin.story.h.h.zAU;
        com.tencent.mm.plugin.story.h.h.dXK().dUP = 3L;
        break;
      }
      i = 1;
      break label3227;
      i = 1;
      break label3255;
    }
    label5100:
    this.vIV = false;
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
    if (this.vIR != null) {
      this.vIR.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(26997);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(27005);
    if (((this.vJa == null) || (!this.vJa.onBackPressed())) && (!getSupportFragmentManager().isDestroyed())) {
      super.onBackPressed();
    }
    AppMethodBeat.o(27005);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(26988);
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1) {
      this.hbQ = false;
    }
    for (;;)
    {
      if ((this.vIY != null) && (!this.vIY.isVisible)) {
        this.vIY.fvQ();
      }
      dpW();
      AppMethodBeat.o(26988);
      return;
      if (paramConfiguration.orientation == 2) {
        this.hbQ = true;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26986);
    az.ayM();
    com.tencent.mm.storage.ai localai = com.tencent.mm.model.c.awB().aNt(com.tencent.mm.sdk.platformtools.bs.nullAsNil(getIntent().getStringExtra("Contact_User")));
    if (localai != null)
    {
      com.tencent.mm.kernel.g.agS();
      if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(localai.field_username))
      {
        this.vJc = true;
        if (this.vJc) {
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
      this.hbQ = bool;
      this.vJh = findViewById(2131296345);
      this.vJi = this.vJh.findViewById(2131296347);
      dpW();
      paramBundle = getWindow().getDecorView();
      paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x400 | 0x100);
      ac.i("MicroMsg.ContactInfoUI", "onCreate MMCore.accHasReady[%b]", new Object[] { Boolean.valueOf(az.agM()) });
      this.vIW = getIntent().getStringExtra("Contact_Search_Mobile");
      if (com.tencent.mm.kernel.g.agP().afY()) {
        break label225;
      }
      finish();
      AppMethodBeat.o(26986);
      return;
      this.vJc = false;
      break;
    }
    label225:
    az.ayM();
    com.tencent.mm.model.c.awB().a(this);
    az.ayM();
    com.tencent.mm.model.c.awC().a(this);
    initView();
    hideActionbarLine();
    if ((this.vIR instanceof com.tencent.mm.pluginsdk.b.b)) {
      ((com.tencent.mm.pluginsdk.b.b)this.vIR).onCreate();
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aB(getIntent())), Integer.valueOf(1), Integer.valueOf(1), this.contact.field_username });
    paramBundle = com.tencent.mm.plugin.story.h.h.zAU;
    com.tencent.mm.plugin.story.h.h.dXK().dWh = com.tencent.mm.plugin.profile.c.aB(getIntent());
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(273, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(291, this);
    AppMethodBeat.o(26986);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26989);
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.zAU;
    com.tencent.mm.plugin.story.h.h.dXK().dWh = 0L;
    if (com.tencent.mm.kernel.g.agP().afY())
    {
      az.ayM();
      com.tencent.mm.model.c.awB().b(this);
      az.ayM();
      com.tencent.mm.model.c.awC().b(this);
    }
    if (this.vIR == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.ContactInfoUI", "onDestroy bodyWidget is null?%s", new Object[] { Boolean.valueOf(bool) });
      if (this.vIR != null) {
        this.vIR.bYJ();
      }
      if ((this.vIR instanceof com.tencent.mm.pluginsdk.b.b)) {
        ((com.tencent.mm.pluginsdk.b.b)this.vIR).adU();
      }
      if (o.xMa != null) {
        o.xMa.aD(this);
      }
      super.onDestroy();
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(273, this);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(291, this);
      if (this.vJa != null) {
        this.vJa.onDestroy();
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aB(getIntent())), Integer.valueOf(18), Integer.valueOf(1), this.contact.field_username });
      com.tencent.mm.plugin.report.service.h.wUl.f(17283, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aB(getIntent())), this.contact.field_username, Boolean.valueOf(this.vJc), Boolean.valueOf(this.vJd), Integer.valueOf(this.contact.uin), Integer.valueOf(this.vJe) });
      AppMethodBeat.o(26989);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26993);
    com.tencent.mm.modelstat.d.d(4, "ContactInfoUI" + getIdentString(), hashCode());
    af.aCW().remove(this);
    super.onPause();
    az.agU().aA(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26972);
        az.ayM();
        com.tencent.mm.model.c.agA().faa();
        AppMethodBeat.o(26972);
      }
    });
    if (getIntent().getBooleanExtra("key_from_wesport_right_newtips", false))
    {
      com.tencent.mm.plugin.newtips.a.dkb();
      com.tencent.mm.plugin.newtips.a.i.al(com.tencent.mm.plugin.newtips.a.d.vmS, getActivityBrowseTimeMs());
    }
    for (;;)
    {
      dpU();
      if (this.vJa != null) {
        this.vJa.onPause();
      }
      if (((this.vIR instanceof c)) || ((this.vIR instanceof ContactWidgetNewBizInfo))) {
        this.vIR.bYJ();
      }
      com.tencent.mm.pluginsdk.ui.span.k.b(this.nAR);
      AppMethodBeat.o(26993);
      return;
      if (getIntent().getBooleanExtra("key_from_wesport_plugin_newtips", false))
      {
        com.tencent.mm.plugin.newtips.a.dkb();
        com.tencent.mm.plugin.newtips.a.i.al(com.tencent.mm.plugin.newtips.a.d.vmQ, getActivityBrowseTimeMs());
      }
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(26998);
    paramf = paramPreference.mKey;
    ac.i("MicroMsg.ContactInfoUI", paramf + " item has been clicked!");
    if (this.vIR != null) {
      this.vIR.WZ(paramf);
    }
    if (paramPreference != null)
    {
      if (!paramPreference.mKey.equals("contact_info_sns")) {
        break label140;
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aB(getIntent())), Integer.valueOf(3), Integer.valueOf(1), this.contact.field_username });
    }
    for (;;)
    {
      if ((paramPreference instanceof NormalProfileHeaderPreference)) {
        dpV();
      }
      AppMethodBeat.o(26998);
      return false;
      label140:
      if (paramPreference.mKey.equals("contact_info_more")) {
        com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aB(getIntent())), Integer.valueOf(6), Integer.valueOf(1), this.contact.field_username });
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(27002);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.ContactInfoUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(27002);
      return;
    }
    ac.i("MicroMsg.ContactInfoUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(27002);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        paramArrayOfString = (NormalUserFooterPreference)this.screen.aPN("contact_info_footer_normal");
        if (paramArrayOfString != null) {
          paramArrayOfString.dqv();
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
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/profile/ui/ContactInfoUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
        paramArrayOfString = (NormalUserFooterPreference)this.screen.aPN("contact_info_footer_normal");
        if (paramArrayOfString != null) {
          paramArrayOfString.dqu();
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
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/profile/ui/ContactInfoUI$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
    this.vJj = false;
    AppMethodBeat.o(26992);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26990);
    com.tencent.mm.modelstat.d.d(3, "ContactInfoUI" + getIdentString(), hashCode());
    af.aCW().add(this);
    super.onResume();
    Object localObject = ((ViewGroup)getContentView()).getFocusedChild();
    if (localObject != null)
    {
      ((View)localObject).clearFocus();
      ac.i("MicroMsg.ContactInfoUI", "try to clear focus. id:%s", new Object[] { Integer.valueOf(((View)localObject).getId()) });
    }
    this.vIY = ((PullDownListView)getListView());
    if (this.vJa != null) {
      this.vJa.onResume();
    }
    if (this.screen != null)
    {
      localObject = (NormalProfileHeaderPreference)this.screen.aPN("contact_profile_header_normal");
      if (localObject != null) {
        ((NormalProfileHeaderPreference)localObject).M(this.vJc, this.vJi.getHeight());
      }
    }
    if (((this.vIR instanceof c)) || ((this.vIR instanceof ContactWidgetNewBizInfo))) {
      this.vIR.a(this.screen, this.contact, this.vIS, this.iMg);
    }
    com.tencent.mm.pluginsdk.ui.span.k.a(this.nAR);
    AppMethodBeat.o(26990);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(27004);
    ac.d("MicroMsg.ContactInfoUI", "onSceneEnd errType[%s] errCode[%s] errMsg[%s] sceneType[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    if ((273 == paramn.getType()) && (this.contact != null) && ((this.vIR instanceof com.tencent.mm.plugin.profile.a)) && (com.tencent.mm.sdk.platformtools.bs.lr(this.contact.field_username, ((com.tencent.mm.plugin.story.f.a.i)paramn).userName)))
    {
      int i = ((com.tencent.mm.plugin.story.f.a.i)paramn).dbL;
      paramString = com.tencent.mm.plugin.story.i.a.zBQ;
      if (i == com.tencent.mm.plugin.story.i.a.dYL())
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
        this.vJd = bool;
        this.vJe = ((com.tencent.mm.plugin.story.f.a.i)paramn).ztC;
        AppMethodBeat.o(27004);
        return;
        i = 0;
        break;
      }
    }
    if ((291 == paramn.getType()) && (this.contact != null)) {
      new com.tencent.mm.sdk.platformtools.ao().post(new ContactInfoUI.a(this, this.contact.field_username));
    }
    AppMethodBeat.o(27004);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(26991);
    super.onStart();
    if (this.vJa != null) {
      this.vJa.onStart();
    }
    AppMethodBeat.o(26991);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(26994);
    super.onStop();
    if (this.vJa != null) {
      this.vJa.onStop();
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