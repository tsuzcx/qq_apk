package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.p;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.l.a;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.e.a;
import com.tencent.mm.ui.statusbar.DrawStatusBarPreference;
import java.io.IOException;
import java.util.List;

@com.tencent.mm.kernel.j
public class ContactInfoUI
  extends DrawStatusBarPreference
  implements l.a, j.a, m.b
{
  private String dmT = "";
  private com.tencent.mm.ui.base.preference.f dnn;
  private ad dnp;
  private int fhj;
  private String kzG;
  private com.tencent.mm.pluginsdk.b.a mVH;
  private boolean mVI;
  private boolean mVJ;
  private byte[] mVK;
  private boolean mVL = false;
  String mVM = null;
  private String mVN = "";
  private boolean mVO = false;
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      y.i("MicroMsg.ContactInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
      return;
    }
    a((String)paramObject, null);
  }
  
  public final void a(final bv parambv)
  {
    ai.d(new Runnable()
    {
      public final void run()
      {
        if ((ContactInfoUI.a(ContactInfoUI.this) != null) && (parambv != null) && (!bk.bl(ContactInfoUI.a(ContactInfoUI.this).field_username)) && (ContactInfoUI.a(ContactInfoUI.this).field_username.equals(parambv.field_encryptUsername)) && (!com.tencent.mm.model.s.hV(ContactInfoUI.a(ContactInfoUI.this).field_username)))
        {
          ContactInfoUI.a(ContactInfoUI.this).df(parambv.field_conRemark);
          ContactInfoUI.this.getIntent().putExtra("Contact_User", ContactInfoUI.a(ContactInfoUI.this).field_username);
          if (ContactInfoUI.c(ContactInfoUI.this) != null)
          {
            ContactInfoUI.c(ContactInfoUI.this).awZ();
            ContactInfoUI.d(ContactInfoUI.this).removeAll();
          }
          ContactInfoUI.this.initView();
        }
      }
    });
  }
  
  public final void a(final String paramString, com.tencent.mm.sdk.e.l paraml)
  {
    new ah().post(new Runnable()
    {
      public final void run()
      {
        y.i("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", new Object[] { Boolean.valueOf(ContactInfoUI.b(ContactInfoUI.this)), ContactInfoUI.a(ContactInfoUI.this).field_username, paramString });
        if ((ContactInfoUI.a(ContactInfoUI.this) != null) && (!bk.bl(ContactInfoUI.a(ContactInfoUI.this).field_username)) && ((ContactInfoUI.a(ContactInfoUI.this).field_username.equals(paramString)) || (ContactInfoUI.a(ContactInfoUI.this).field_username.equals(ad.aaZ(paramString)))))
        {
          if (ContactInfoUI.c(ContactInfoUI.this) != null)
          {
            ContactInfoUI.c(ContactInfoUI.this).awZ();
            ContactInfoUI.d(ContactInfoUI.this).removeAll();
          }
          ContactInfoUI.this.initView();
        }
      }
    });
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    y.i("MicroMsg.ContactInfoUI", paramf + " item has been clicked!");
    if (this.mVH != null) {
      this.mVH.xQ(paramf);
    }
    if (paramPreference != null)
    {
      if (!paramPreference.mKey.equals("contact_info_sns")) {
        break label98;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(16055, new Object[] { Integer.valueOf(3), Integer.valueOf(com.tencent.mm.plugin.profile.b.S(getIntent())) });
    }
    label98:
    while (!paramPreference.mKey.equals("contact_info_more")) {
      return false;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(16055, new Object[] { Integer.valueOf(6), Integer.valueOf(com.tencent.mm.plugin.profile.b.S(getIntent())) });
    return false;
  }
  
  protected final String bdI()
  {
    if ((this.dnp == null) || ((int)this.dnp.dBe == 0) || (bk.bl(this.dnp.field_username))) {
      return "";
    }
    y.i("MicroMsg.ContactInfoUI", "getIdentityString %s", new Object[] { this.dnp.field_username });
    if (com.tencent.mm.ai.f.eW(this.dnp.field_username)) {
      return "_EnterpriseChat";
    }
    if (com.tencent.mm.ai.f.lc(this.dnp.field_username)) {
      return "_EnterpriseFatherBiz";
    }
    if (com.tencent.mm.ai.f.lb(this.dnp.field_username)) {
      return "_EnterpriseChildBiz";
    }
    if (this.dnp.cua()) {
      return "_bizContact";
    }
    if (com.tencent.mm.model.s.fn(this.dnp.field_username)) {
      return "_chatroom";
    }
    if (com.tencent.mm.model.s.hd(this.dnp.field_username)) {
      return "_bottle";
    }
    if (com.tencent.mm.model.s.he(this.dnp.field_username)) {
      return "_QQ";
    }
    if (com.tencent.mm.model.s.hU(this.dnp.field_username)) {
      return "_" + this.dnp.field_username;
    }
    return "";
  }
  
  protected final void initView()
  {
    this.dnn = this.vdd;
    this.dnn.removeAll();
    this.fhj = getIntent().getIntExtra("Contact_Scene", 9);
    this.kzG = getIntent().getStringExtra("Verify_ticket");
    this.mVI = getIntent().getBooleanExtra("Chat_Readonly", false);
    this.mVJ = getIntent().getBooleanExtra("User_Verify", false);
    this.dmT = getIntent().getStringExtra("Contact_ChatRoomId");
    String str1 = bk.pm(getIntent().getStringExtra("Contact_User"));
    Object localObject5 = bk.pm(getIntent().getStringExtra("Contact_Alias"));
    Object localObject1 = bk.pm(getIntent().getStringExtra("Contact_Encryptusername"));
    if (str1.endsWith("@stranger")) {
      localObject1 = str1;
    }
    au.Hx();
    this.dnp = com.tencent.mm.model.c.Fw().abl(str1);
    if (this.dnp != null) {
      this.dnp.uzT = str1;
    }
    com.tencent.mm.plugin.profile.a.eUS.a(this.dnp);
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
    this.mVN = getIntent().getStringExtra("Contact_BrandIconURL");
    String str9 = getIntent().getStringExtra("Contact_RegionCode");
    this.mVK = getIntent().getByteArrayExtra("Contact_customInfo");
    int i2 = getIntent().getIntExtra("Contact_Ext_Flag", 0);
    boolean bool2 = getIntent().getBooleanExtra("force_get_contact", false);
    y.i("MicroMsg.ContactInfoUI", "dkverify forceAddContact:%s  user:%s  roomid:%s ", new Object[] { Boolean.valueOf(bool2), str1, this.dmT });
    Object localObject4;
    Object localObject3;
    Object localObject8;
    label760:
    int m;
    label780:
    int n;
    label1236:
    int i;
    label1301:
    label1357:
    boolean bool1;
    if (bool2)
    {
      y.d("MicroMsg.ContactInfoUI", "initView, forceAddContact, user = " + str1);
      if ((this.dnp != null) && (com.tencent.mm.n.a.gR(this.dnp.field_type))) {
        am.a.dVy.V(str1, this.dmT);
      }
    }
    else
    {
      if (((this.dnp == null) || ((int)this.dnp.dBe == 0)) && (ad.aaU(str1)) && (this.fhj != 15))
      {
        localObject4 = bk.pm(getIntent().getStringExtra(e.a.uHO));
        localObject3 = localObject4;
        if (bk.bl((String)localObject4)) {
          localObject3 = this.kzG;
        }
        com.tencent.mm.kernel.g.DO().dJT.a(new com.tencent.mm.openim.b.h(str1, bk.pm(this.dmT), (String)localObject3), 0);
      }
      if ((this.dnp != null) && ((int)this.dnp.dBe > 0) && ((!com.tencent.mm.model.s.hV(this.dnp.field_username)) || ((ad.aaT(this.dnp.field_username)) && (!com.tencent.mm.model.s.hj(this.dnp.field_username)))))
      {
        if ((!this.dnp.cud()) || (!ad.aaU(this.dnp.field_username))) {
          break label2016;
        }
        localObject4 = bk.pm(getIntent().getStringExtra(e.a.uHO));
        localObject3 = localObject4;
        if (bk.bl((String)localObject4)) {
          localObject3 = this.kzG;
        }
        localObject8 = com.tencent.mm.kernel.g.DO().dJT;
        String str10 = this.dnp.field_username;
        if (!com.tencent.mm.n.a.gR(this.dnp.field_type)) {
          break label2004;
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
      if ((this.dnp != null) && ((int)this.dnp.dBe != 0) && (bk.pm(this.dnp.field_username).length() > 0)) {
        break label2254;
      }
      this.dnp = new ad();
      this.dnp.setUsername(str1);
      this.dnp.cZ((String)localObject5);
      this.dnp.dk((String)localObject6);
      this.dnp.dl(getIntent().getStringExtra("Contact_PyInitial"));
      this.dnp.dm(getIntent().getStringExtra("Contact_QuanPin"));
      this.dnp.fm(j);
      this.dnp.dA(str4);
      this.dnp.dB((String)localObject7);
      this.dnp.dz(str5);
      this.dnp.fi(k);
      this.dnp.dE(str6);
      this.dnp.dC(str2);
      this.dnp.fs(m);
      this.dnp.dD(str7);
      this.dnp.fh(i1);
      this.dnp.dn(str8);
      this.dnp.aZ(l);
      this.dnp.du(str3);
      this.dnp.dF(str9);
      this.dnp.fv(i2);
      if ((!bk.bl(this.mVM)) && (this.fhj == 15))
      {
        au.Hx();
        localObject5 = com.tencent.mm.model.c.Fx().Id(str1);
        localObject6 = new bv(str1);
        ((bv)localObject6).field_conRemark = ((bv)localObject5).field_conRemark;
        ((bv)localObject6).field_conDescription = ((bv)localObject5).field_conDescription;
        ((bv)localObject6).field_contactLabels = ((bv)localObject5).field_contactLabels;
        ((bv)localObject6).field_conPhone = this.mVM;
        au.Hx();
        com.tencent.mm.model.c.Fx().a((com.tencent.mm.sdk.e.c)localObject6);
        this.mVM = null;
      }
      this.dnp.dO((String)localObject4);
      this.dnp.fw(n);
      this.dnp.dt((String)localObject3);
      if ((ad.aaU(this.dnp.field_username)) && ((this.fhj == 30) || (this.fhj == 45) || (this.fhj == 17)))
      {
        localObject3 = com.tencent.mm.plugin.report.service.h.nFQ;
        localObject4 = this.dnp.field_openImAppid;
        if (this.fhj != 17) {
          break label2880;
        }
        i = 2;
        ((com.tencent.mm.plugin.report.service.h)localObject3).f(15320, new Object[] { localObject4, Integer.valueOf(i) });
      }
      if (!bk.bl((String)localObject1)) {
        this.dnp.dq((String)localObject1);
      }
      if (this.dnp != null) {
        break label2885;
      }
      y.e("MicroMsg.ContactInfoUI", "contact = null");
      getIntent().putExtra("Contact_User", this.dnp.field_username);
      if ((!bool2) && ((int)this.dnp.dBe <= 0) && (this.dnp.cua()) && ((this.fhj == 17) || (this.fhj == 41)))
      {
        y.d("MicroMsg.ContactInfoUI", "come from card, getContact %s", new Object[] { this.dnp.field_username });
        am.a.dVy.V(this.dnp.field_username, "");
        com.tencent.mm.ag.b.ka(this.dnp.field_username);
      }
      if (this.dnp.cCJ != null) {
        break label2995;
      }
      bool1 = true;
      label1481:
      if (this.dnp.cCJ != null) {
        break label3001;
      }
      i = 0;
      label1493:
      if (this.dnp.cCJ != null) {
        break label3015;
      }
    }
    label2880:
    label2885:
    label3015:
    for (localObject1 = "";; localObject1 = bk.aac(this.dnp.cCJ))
    {
      y.i("MicroMsg.ContactInfoUI", "contact.getRemarkDesc() (%s, %s, %s)", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), localObject1 });
      if ((!bool2) && ((int)this.dnp.dBe <= 0) && (this.fhj == 96))
      {
        y.i("MicroMsg.ContactInfoUI", "come from chatroom accessverify, getContact %s", new Object[] { this.dnp.field_username });
        am.a.dVy.X(this.dnp.field_username, getIntent().getStringExtra("key_add_contact_verify_ticket"));
        com.tencent.mm.ag.b.M(this.dnp.field_username, 3);
      }
      if (this.dnp.field_username.equals(q.Gj()))
      {
        au.Hx();
        l = bk.getLong((String)com.tencent.mm.model.c.Dz().get(65825, null), 0L);
        if (l > 0L)
        {
          this.dnp.aZ(l);
          localObject1 = this.dnp;
          au.Hx();
          ((ad)localObject1).du((String)com.tencent.mm.model.c.Dz().get(65826, null));
        }
        localObject1 = this.dnp;
        au.Hx();
        ((ad)localObject1).dI((String)com.tencent.mm.model.c.Dz().get(286721, null));
        localObject1 = this.dnp;
        au.Hx();
        ((ad)localObject1).dJ((String)com.tencent.mm.model.c.Dz().get(286722, null));
        localObject1 = this.dnp;
        au.Hx();
        ((ad)localObject1).dK((String)com.tencent.mm.model.c.Dz().get(286723, null));
      }
      if ((this.dnp.field_username != null) && (this.dnp.field_username.equals(ad.aaZ(q.Gj()))))
      {
        localObject1 = bn.Id();
        localObject3 = bk.pm(((bn)localObject1).getProvince());
        localObject4 = bk.pm(((bn)localObject1).getCity());
        if (!bk.bl((String)localObject3)) {
          this.dnp.dA((String)localObject3);
        }
        if (!bk.bl((String)localObject4)) {
          this.dnp.dB((String)localObject4);
        }
        if (!bk.bl(((bn)localObject1).countryCode)) {
          this.dnp.dF(RegionCodeDecoder.ao(((bn)localObject1).countryCode, ((bn)localObject1).dXv, ((bn)localObject1).dXu));
        }
        i = bk.a(Integer.valueOf(((bn)localObject1).sex), 0);
        localObject1 = bk.pm(((bn)localObject1).signature);
        this.dnp.fm(i);
        this.dnp.dz((String)localObject1);
      }
      if (!bk.bl(this.dnp.field_username)) {
        break label3030;
      }
      y.e("MicroMsg.ContactInfoUI", "username is null %s", new Object[] { str1 });
      finish();
      return;
      am.a.dVy.V(str1, "");
      break;
      label2004:
      localObject4 = bk.pm(this.dmT);
      break label760;
      label2016:
      localObject3 = com.tencent.mm.ai.f.kX(this.dnp.field_username);
      if ((this.dnp.cua()) && (com.tencent.mm.ai.a.Lp()))
      {
        i = 1;
        label2046:
        if ((localObject3 != null) && ((!((com.tencent.mm.ai.d)localObject3).Ls()) || (i != 0))) {
          break label2151;
        }
        y.d("MicroMsg.ContactInfoUI", "update contact, verifyFlag %d.", new Object[] { Integer.valueOf(k) });
        localObject4 = am.a.dVy;
        localObject8 = this.dnp.field_username;
        if (!com.tencent.mm.n.a.gR(this.dnp.field_type)) {
          break label2142;
        }
      }
      label2142:
      for (localObject3 = "";; localObject3 = this.dmT)
      {
        ((am.b)localObject4).V((String)localObject8, (String)localObject3);
        com.tencent.mm.ag.b.ka(this.dnp.field_username);
        break;
        i = 0;
        break label2046;
      }
      label2151:
      if ((!this.dnp.cud()) || (i != 0)) {
        break label780;
      }
      y.d("MicroMsg.ContactInfoUI", "update contact, last check time=%d", new Object[] { Integer.valueOf(this.dnp.cCH) });
      localObject4 = am.a.dVy;
      localObject8 = this.dnp.field_username;
      if (com.tencent.mm.n.a.gR(this.dnp.field_type)) {}
      for (localObject3 = "";; localObject3 = this.dmT)
      {
        ((am.b)localObject4).V((String)localObject8, (String)localObject3);
        com.tencent.mm.ag.b.ka(this.dnp.field_username);
        break;
      }
      label2254:
      if (this.dnp.sex == 0) {
        this.dnp.fm(j);
      }
      if ((str4 != null) && (!str4.equals(""))) {
        this.dnp.dA(str4);
      }
      if ((localObject7 != null) && (!((String)localObject7).equals(""))) {
        this.dnp.dB((String)localObject7);
      }
      if ((str9 != null) && (!str9.equals(""))) {
        this.dnp.dF(str9);
      }
      if ((bk.bl(this.dnp.signature)) && (str5 != null) && (!str5.equals(""))) {
        this.dnp.dz(str5);
      }
      if (k != 0) {
        this.dnp.fi(k);
      }
      if ((bk.bl(this.dnp.cCF)) && (str6 != null) && (!str6.equals(""))) {
        this.dnp.dE(str6);
      }
      if ((bk.bl(this.dnp.field_nickname)) && (localObject6 != null) && (!((String)localObject6).equals(""))) {
        this.dnp.dk((String)localObject6);
      }
      y.i("MicroMsg.ContactInfoUI", "searchMobilePhone:%s", new Object[] { bk.pm(this.mVM) });
      if ((!bk.bl(this.mVM)) && (this.fhj == 15))
      {
        i = 1;
        k = 1;
        str4 = this.dnp.cCP;
        if (str4 != null)
        {
          localObject7 = this.dnp.cCP.split(",");
          i1 = localObject7.length;
          j = 0;
          i = k;
          if (j < i1)
          {
            if (localObject7[j].equals(this.mVM)) {}
            for (i = 0;; i = 1)
            {
              j += 1;
              break;
            }
          }
        }
        if (i != 0)
        {
          this.dnp.dM(str4 + this.mVM + ",");
          this.mVM = null;
        }
        y.i("MicroMsg.ContactInfoUI", "contact PhoneList:%s", new Object[] { bk.pm(this.dnp.cCP) });
        this.dnp.setSource(15);
      }
      this.dnp.dC(str2);
      this.dnp.fs(m);
      this.dnp.aZ(l);
      this.dnp.du(str3);
      if (!com.tencent.mm.n.a.gR(this.dnp.field_type))
      {
        if (!bk.bl((String)localObject5)) {
          this.dnp.cZ((String)localObject5);
        }
        if (!bk.bl((String)localObject6)) {
          this.dnp.dk((String)localObject6);
        }
        localObject5 = getIntent().getStringExtra("Contact_PyInitial");
        if (!bk.bl((String)localObject5)) {
          this.dnp.dl((String)localObject5);
        }
        localObject5 = getIntent().getStringExtra("Contact_QuanPin");
        if (!bk.bl((String)localObject5)) {
          this.dnp.dm((String)localObject5);
        }
      }
      if ((!com.tencent.mm.n.a.gR(this.dnp.field_type)) && (!bk.bl((String)localObject4))) {
        this.dnp.dO((String)localObject4);
      }
      if ((!com.tencent.mm.n.a.gR(this.dnp.field_type)) && (n != 0)) {
        this.dnp.fw(n);
      }
      if (bk.bl((String)localObject3)) {
        break label1236;
      }
      this.dnp.dt((String)localObject3);
      break label1236;
      i = 1;
      break label1301;
      if (!bk.bl((String)localObject1))
      {
        au.Hx();
        localObject1 = com.tencent.mm.model.c.Fx().Id((String)localObject1);
        if ((localObject1 != null) && (!bk.bl(((bv)localObject1).field_encryptUsername)))
        {
          this.dnp.df(((bv)localObject1).field_conRemark);
          break label1357;
        }
      }
      if (bk.bl(str1)) {
        break label1357;
      }
      au.Hx();
      localObject1 = com.tencent.mm.model.c.Fx().Id(str1);
      if ((localObject1 == null) || (bk.bl(((bv)localObject1).field_encryptUsername))) {
        break label1357;
      }
      this.dnp.df(((bv)localObject1).field_conRemark);
      break label1357;
      bool1 = false;
      break label1481;
      i = this.dnp.cCJ.length();
      break label1493;
    }
    label2995:
    label3001:
    label3030:
    if (com.tencent.mm.model.s.hU(this.dnp.field_username))
    {
      i = R.l.settings_plugins_title;
      setMMTitle(i);
      if (com.tencent.mm.model.s.fn(this.dnp.field_username)) {
        setMMTitle(R.l.contact_info_room_title);
      }
      localObject3 = this.mVN;
      if (!com.tencent.mm.model.s.hg(this.dnp.field_username)) {
        break label3584;
      }
      this.mVH = com.tencent.mm.br.d.Y(this, "sport");
      if (this.mVH != null)
      {
        this.mVH.a(this.dnn, this.dnp, this.mVI, this.fhj);
        localObject3 = com.tencent.mm.plugin.account.b.getAddrUploadStg().pH(this.dnp.field_username);
        localObject1 = "";
        if (localObject3 != null) {
          localObject1 = bk.pm(((com.tencent.mm.plugin.account.friend.a.a)localObject3).WD()).replace(" ", "");
        }
        if ((!this.mVO) && (com.tencent.mm.n.a.gR(this.dnp.field_type)) && ((this.mVH instanceof k)))
        {
          if (!bk.bl(this.dnp.cCP)) {
            break label4593;
          }
          i = 0;
          if (!bk.bl((String)localObject1)) {
            break label4611;
          }
          j = 0;
          j = i + j;
          localObject3 = com.tencent.mm.plugin.report.service.h.nFQ;
          localObject4 = this.dnp.field_username;
          if (!bk.bl((String)localObject1)) {
            break label4616;
          }
          i = 0;
          if (j < 5) {
            break label4621;
          }
          j = 5;
        }
      }
    }
    label3584:
    label4611:
    label4616:
    label4621:
    for (;;)
    {
      label3102:
      label3232:
      label3260:
      ((com.tencent.mm.plugin.report.service.h)localObject3).f(12040, new Object[] { localObject4, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(j) });
      label3222:
      this.mVO = true;
      if ((!(this.mVH instanceof k)) && (!(this.mVH instanceof c)) && (!(this.mVH instanceof com.tencent.mm.plugin.profile.ui.newbizinfo.b)))
      {
        au.Hx();
        localObject1 = (String)com.tencent.mm.model.c.Dz().get(ac.a.uwq, "");
        if (((String)localObject1).contains(this.dnp.field_username))
        {
          localObject1 = ((String)localObject1).replaceAll(this.dnp.field_username + ",*", "");
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uwq, localObject1);
          y.i("MicroMsg.ContactInfoUI", "mark plugin read, userName:%s, newVal:%s", new Object[] { this.dnp.field_username, localObject1 });
          if (bk.bl((String)localObject1)) {
            com.tencent.mm.y.c.BS().w(262158, false);
          }
        }
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          if (((com.tencent.mm.model.s.hA(ContactInfoUI.a(ContactInfoUI.this).field_username)) && (!q.GD())) || ((com.tencent.mm.model.s.hs(ContactInfoUI.a(ContactInfoUI.this).field_username)) && (!q.Gz())) || ((com.tencent.mm.model.s.hu(ContactInfoUI.a(ContactInfoUI.this).field_username)) && (!q.GJ())) || ((com.tencent.mm.model.s.ho(ContactInfoUI.a(ContactInfoUI.this).field_username)) && (!q.GM())))
          {
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.addFlags(67108864);
            com.tencent.mm.plugin.profile.a.eUR.q(paramAnonymousMenuItem, ContactInfoUI.this);
          }
          ContactInfoUI.this.finish();
          return true;
        }
      });
      o.Kj().kc(this.dnp.field_username);
      if (((!com.tencent.mm.model.s.hA(this.dnp.field_username)) || (!q.GD())) && ((!com.tencent.mm.model.s.hs(this.dnp.field_username)) || (!q.Gz())) && ((!com.tencent.mm.model.s.hu(this.dnp.field_username)) || (!q.GJ())) && ((!com.tencent.mm.model.s.ho(this.dnp.field_username)) || (!q.GM()))) {
        break label4624;
      }
      this.mVL = true;
      return;
      i = R.l.contact_info_title;
      break;
      if (com.tencent.mm.model.s.ho(this.dnp.field_username))
      {
        this.mVH = com.tencent.mm.br.d.Y(this, "qqmail");
        break label3102;
      }
      if (com.tencent.mm.model.s.hp(this.dnp.field_username))
      {
        this.mVH = new e(this);
        setMMTitle(R.l.settings_plugins_title);
        break label3102;
      }
      if (com.tencent.mm.model.s.hr(this.dnp.field_username))
      {
        this.mVH = com.tencent.mm.br.d.Y(this, "bottle");
        setMMTitle(R.l.settings_plugins_title);
        break label3102;
      }
      if (com.tencent.mm.model.s.hq(this.dnp.field_username))
      {
        this.mVH = com.tencent.mm.br.d.Y(this, "tmessage");
        setMMTitle(R.l.settings_plugins_title);
        break label3102;
      }
      if (com.tencent.mm.model.s.hC(this.dnp.field_username))
      {
        this.mVH = new com.tencent.mm.plugin.topstory.ui.a.a(this);
        setMMTitle(R.l.settings_plugins_title);
        break label3102;
      }
      if (com.tencent.mm.model.s.hi(this.dnp.field_username))
      {
        this.mVH = new h(this);
        break label3102;
      }
      if (com.tencent.mm.model.s.hw(this.dnp.field_username))
      {
        this.mVH = new m(this);
        break label3102;
      }
      if (ad.hd(this.dnp.field_username))
      {
        this.mVH = new d(this);
        break label3102;
      }
      if (com.tencent.mm.model.s.hy(this.dnp.field_username))
      {
        this.mVH = com.tencent.mm.br.d.Y(this, "nearby");
        break label3102;
      }
      if (com.tencent.mm.model.s.hz(this.dnp.field_username))
      {
        this.mVH = com.tencent.mm.br.d.Y(this, "shake");
        break label3102;
      }
      if (com.tencent.mm.model.s.hA(this.dnp.field_username))
      {
        this.mVH = new j(this);
        break label3102;
      }
      if (com.tencent.mm.model.s.hB(this.dnp.field_username))
      {
        this.mVH = com.tencent.mm.br.d.y(this, "readerapp", "widget_type_news");
        break label3102;
      }
      if (com.tencent.mm.model.s.hJ(this.dnp.field_username))
      {
        this.mVH = com.tencent.mm.br.d.y(this, "readerapp", "widget_type_weibo");
        break label3102;
      }
      if (com.tencent.mm.model.s.ht(this.dnp.field_username))
      {
        this.mVH = new f(this);
        break label3102;
      }
      if (com.tencent.mm.model.s.hu(this.dnp.field_username))
      {
        this.mVH = com.tencent.mm.br.d.Y(this, "masssend");
        break label3102;
      }
      if (com.tencent.mm.model.s.hv(this.dnp.field_username))
      {
        this.mVH = new g(this);
        break label3102;
      }
      if ((this.dnp.cua()) || (getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)))
      {
        for (;;)
        {
          try
          {
            localObject1 = this.mVK;
            if (localObject1 != null) {
              continue;
            }
            localObject1 = null;
          }
          catch (IOException localIOException)
          {
            y.printErrStackTrace("MicroMsg.ContactInfoUI", localIOException, "", new Object[0]);
            Object localObject2 = null;
            continue;
            if (!com.tencent.mm.ai.f.kZ((String)localObject4)) {
              continue;
            }
            bool1 = true;
            continue;
            if (localObject2 == null) {
              continue;
            }
            localObject4 = new com.tencent.mm.ai.d();
            ((com.tencent.mm.ai.d)localObject4).field_extInfo = ((sg)localObject2).ffw;
            ((com.tencent.mm.ai.d)localObject4).field_type = ((com.tencent.mm.ai.d)localObject4).bS(false).LW();
            if (!((com.tencent.mm.ai.d)localObject4).Lw()) {
              continue;
            }
            bool1 = true;
            continue;
            if (!((com.tencent.mm.ai.d)localObject4).Lv()) {
              continue;
            }
            bool1 = true;
            continue;
            if (!getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
              continue;
            }
            bool1 = true;
            continue;
            if ((com.tencent.mm.ai.f.lc(this.dnp.field_username)) || (com.tencent.mm.ai.f.lb(this.dnp.field_username)) || ((int)this.dnp.dBe > 0) || (!this.dnp.cua()) || ((this.fhj != 17) && (this.fhj != 41))) {
              continue;
            }
            bool1 = true;
            continue;
            bool1 = false;
            continue;
            localObject2 = new c(this, (String)localObject3, (sg)localObject2);
            if (bk.bl(this.kzG)) {
              continue;
            }
            ((c)localObject2).kzG = this.kzG;
            this.mVH = ((com.tencent.mm.pluginsdk.b.a)localObject2);
          }
          localObject4 = this.dnp.field_username;
          if ((!ae.cqS().getBoolean("use_new_profile", true)) || (com.tencent.mm.model.s.ic((String)localObject4)) || (com.tencent.mm.model.s.hx((String)localObject4)) || (com.tencent.mm.model.s.hI((String)localObject4))) {
            continue;
          }
          if (!com.tencent.mm.ai.f.kY((String)localObject4)) {
            continue;
          }
          bool1 = true;
          y.i("MicroMsg.ContactInfoUI", "username:%s, isUseNewProfileUI:%b", new Object[] { this.dnp.field_username, Boolean.valueOf(bool1) });
          if (!bool1) {
            continue;
          }
          localObject1 = new com.tencent.mm.plugin.profile.ui.newbizinfo.b(this, (String)localObject3, (sg)localObject1);
          if (!bk.bl(this.kzG)) {
            ((com.tencent.mm.plugin.profile.ui.newbizinfo.b)localObject1).kzG = this.kzG;
          }
          this.mVH = ((com.tencent.mm.pluginsdk.b.a)localObject1);
          break;
          localObject1 = (sg)new sg().aH(this.mVK);
        }
        break label3102;
      }
      if (com.tencent.mm.model.s.hF(this.dnp.field_username))
      {
        this.mVH = new n(this);
        break label3102;
      }
      if (com.tencent.mm.model.s.hG(this.dnp.field_username))
      {
        this.mVH = new i(this);
        break label3102;
      }
      if (com.tencent.mm.model.s.hh(this.dnp.field_username))
      {
        this.mVH = new com.tencent.mm.plugin.downloader_app.d.a(this);
        break label3102;
      }
      this.mVH = new k(this);
      break label3102;
      label4593:
      i = this.dnp.cCP.split(",").length;
      break label3222;
      j = 1;
      break label3232;
      i = 1;
      break label3260;
    }
    label4624:
    this.mVL = false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      getIntent().putExtra("CONTACT_INFO_UI_SOURCE", paramIntent.getIntExtra("CONTACT_INFO_UI_SOURCE", -1));
    }
    if (this.mVH != null) {
      this.mVH.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.ContactInfoUI", "onCreate MMCore.accHasReady[%b]", new Object[] { Boolean.valueOf(au.DK()) });
    this.mVM = getIntent().getStringExtra("Contact_Search_Mobile");
    if (!com.tencent.mm.kernel.g.DN().Dc())
    {
      finish();
      return;
    }
    au.Hx();
    com.tencent.mm.model.c.Fw().a(this);
    au.Hx();
    com.tencent.mm.model.c.Fx().a(this);
    initView();
    if ((this.mVH instanceof com.tencent.mm.plugin.profile.ui.newbizinfo.b))
    {
      paramBundle = (com.tencent.mm.plugin.profile.ui.newbizinfo.b)this.mVH;
      if ((paramBundle.dnp == null) || (paramBundle.mVy == null)) {
        y.w("MicroMsg.ContactWidgetNewBizInfo", "reportStart fail, err");
      }
    }
    else
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(16055, new Object[] { Integer.valueOf(1), Integer.valueOf(com.tencent.mm.plugin.profile.b.S(getIntent())) });
      return;
    }
    paramBundle.diQ = System.currentTimeMillis();
    String str = paramBundle.dnp.field_username;
    int j = paramBundle.fhj;
    int k = paramBundle.mVy.field_type;
    long l = paramBundle.diQ;
    if (com.tencent.mm.n.a.gR(paramBundle.dnp.field_type)) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(str, j, k, l, i);
      break;
    }
  }
  
  public void onDestroy()
  {
    int j = 0;
    if (com.tencent.mm.kernel.g.DN().Dc())
    {
      au.Hx();
      com.tencent.mm.model.c.Fw().b(this);
      au.Hx();
      com.tencent.mm.model.c.Fx().b(this);
    }
    if (this.mVH != null) {
      this.mVH.awZ();
    }
    com.tencent.mm.plugin.profile.ui.newbizinfo.b localb;
    if ((this.mVH instanceof com.tencent.mm.plugin.profile.ui.newbizinfo.b))
    {
      localb = (com.tencent.mm.plugin.profile.ui.newbizinfo.b)this.mVH;
      if ((localb.dnp == null) || (localb.mVy == null) || (localb.mZz == null)) {
        y.w("MicroMsg.ContactWidgetNewBizInfo", "reportEnd fail, err");
      }
    }
    else
    {
      if (com.tencent.mm.plugin.sns.b.n.omC != null) {
        com.tencent.mm.plugin.sns.b.n.omC.M(this);
      }
      super.onDestroy();
      return;
    }
    localb.endTime = System.currentTimeMillis();
    String str = localb.dnp.field_username;
    int k = localb.fhj;
    int m = localb.mVy.field_type;
    long l1 = localb.diQ;
    long l2 = localb.endTime;
    if (com.tencent.mm.n.a.gR(localb.dnp.field_type)) {}
    for (int i = 1;; i = 0)
    {
      int n = localb.mZz.field_originalArticleCount;
      int i1 = localb.mZz.field_friendSubscribeCount;
      if (localb.mWM != null) {
        j = localb.mWM.size();
      }
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(str, k, m, l1, l2, i, n, i1, j, com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.bY(localb.mZz.bsV()), com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.bZ(localb.mZz.bsW()), localb.mZz.field_decryptUserName);
      break;
    }
  }
  
  public void onPause()
  {
    com.tencent.mm.modelstat.d.b(4, "ContactInfoUI" + bdI(), hashCode());
    com.tencent.mm.ai.z.My().d(this);
    super.onPause();
    au.DS().R(new Runnable()
    {
      public final void run()
      {
        au.Hx();
        com.tencent.mm.model.c.Dz().mC(true);
      }
    });
    if (getIntent().getBooleanExtra("key_from_wesport_right_newtips", false))
    {
      com.tencent.mm.plugin.y.a.bot();
      com.tencent.mm.aw.d.l(com.tencent.mm.aw.b.evh, czu());
    }
    while (!getIntent().getBooleanExtra("key_from_wesport_plugin_newtips", false)) {
      return;
    }
    com.tencent.mm.plugin.y.a.bot();
    com.tencent.mm.aw.d.l(com.tencent.mm.aw.b.evf, czu());
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.ContactInfoUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    do
    {
      for (;;)
      {
        return;
        if (paramArrayOfInt[0] == 0)
        {
          paramArrayOfString = (NormalUserFooterPreference)this.dnn.add("contact_info_footer_normal");
          if (paramArrayOfString != null) {
            paramArrayOfString.bsH();
          }
        }
        else
        {
          if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
          for (paramInt = R.l.permission_camera_request_again_msg; paramArrayOfInt[0] != 0; paramInt = R.l.permission_microphone_request_again_msg)
          {
            com.tencent.mm.ui.base.h.a(this, getString(paramInt), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new ContactInfoUI.5(this), new ContactInfoUI.6(this));
            return;
          }
        }
      }
      if (paramArrayOfInt[0] != 0) {
        break;
      }
      paramArrayOfString = (NormalUserFooterPreference)this.dnn.add("contact_info_footer_normal");
    } while (paramArrayOfString == null);
    paramArrayOfString.bsG();
    return;
    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new ContactInfoUI.7(this), null);
  }
  
  protected void onRestart()
  {
    super.onRestart();
    this.mVO = false;
  }
  
  public void onResume()
  {
    com.tencent.mm.modelstat.d.b(3, "ContactInfoUI" + bdI(), hashCode());
    com.tencent.mm.ai.z.My().c(this);
    super.onResume();
    View localView = ((ViewGroup)this.mController.contentView).getFocusedChild();
    if (localView != null)
    {
      localView.clearFocus();
      y.i("MicroMsg.ContactInfoUI", "try to clear focus. id:%s", new Object[] { Integer.valueOf(localView.getId()) });
    }
  }
  
  public final int xj()
  {
    return R.o.contact_info_stub;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI
 * JD-Core Version:    0.7.0.1
 */