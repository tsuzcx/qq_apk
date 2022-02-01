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
import android.text.TextUtils;
import android.util.Base64;
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
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.ag;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.b.a.nf;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.a;
import com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizInfo;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.ah.a;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.e.d;
import com.tencent.mm.ui.statusbar.c.a;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback;
import com.tencent.mm.ui.widget.listview.PullDownListView.a;
import java.io.IOException;
import java.lang.ref.WeakReference;

@com.tencent.mm.kernel.i
public class ContactInfoUI
  extends MMPreference
  implements com.tencent.mm.ak.i, f.a, com.tencent.mm.plugin.messenger.foundation.a.a.n.a, com.tencent.mm.plugin.story.api.g, com.tencent.mm.plugin.textstatus.a.e, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange
{
  private boolean BdA;
  String BdB;
  private String BdC;
  private PullDownListView BdD;
  private boolean BdE;
  private AbsStoryGallery BdF;
  private AbsStoryMuteView BdG;
  private boolean BdH;
  private boolean BdI;
  private boolean BdJ;
  private boolean BdK;
  private int BdL;
  private com.tencent.mm.plugin.textstatus.a.b BdM;
  private View.OnClickListener BdN;
  private PullDownListView.IPullDownCallback BdO;
  private PullDownListView.IPullDownCallback BdP;
  private View BdQ;
  private View BdR;
  private c.a BdS;
  private boolean BdT;
  private ContactWidgetTabBizInfo BdU;
  private com.tencent.mm.pluginsdk.b.a Bdv;
  private NormalProfileHeaderPreference Bdw;
  private boolean Bdx;
  private boolean Bdy;
  private byte[] Bdz;
  private as contact;
  private boolean iqo;
  private int kgm;
  private com.tencent.mm.pluginsdk.ui.span.i ptq;
  private String roomId;
  private com.tencent.mm.ui.base.preference.f screen;
  private long viC;
  private String wZz;
  
  public ContactInfoUI()
  {
    AppMethodBeat.i(26982);
    this.BdA = false;
    this.BdB = null;
    this.BdC = "";
    this.roomId = "";
    this.BdD = null;
    this.BdE = false;
    this.BdF = null;
    this.BdG = null;
    this.BdH = false;
    this.BdI = false;
    this.BdJ = false;
    this.BdK = false;
    this.iqo = false;
    this.BdL = 0;
    this.viC = 0L;
    this.BdM = null;
    this.BdN = null;
    this.BdO = new ContactInfoUI.1(this);
    this.BdP = new ContactInfoUI.6(this);
    this.ptq = new com.tencent.mm.pluginsdk.ui.span.i()
    {
      public final Object a(com.tencent.mm.pluginsdk.ui.applet.u paramAnonymousu)
      {
        AppMethodBeat.i(231840);
        switch (paramAnonymousu.type)
        {
        default: 
          AppMethodBeat.o(231840);
          return null;
        }
        if (ContactInfoUI.g(ContactInfoUI.this) != null)
        {
          paramAnonymousu = ContactInfoUI.g(ContactInfoUI.this).field_username;
          AppMethodBeat.o(231840);
          return paramAnonymousu;
        }
        AppMethodBeat.o(231840);
        return null;
      }
      
      public final Object b(com.tencent.mm.pluginsdk.ui.applet.u paramAnonymousu)
      {
        AppMethodBeat.i(231841);
        if (paramAnonymousu.type == 45)
        {
          String str = new String(Base64.decode(paramAnonymousu.url, 0));
          paramAnonymousu = new String(Base64.decode(Util.nullAs((String)paramAnonymousu.ba(String.class), ""), 0));
          Log.d("MicroMsg.ContactInfoUI", "appId:%s,path:%s", new Object[] { str, paramAnonymousu });
          AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
          localAppBrandStatObject.scene = 1082;
          if (ContactInfoUI.g(ContactInfoUI.this) != null) {
            localAppBrandStatObject.dCw = (ContactInfoUI.g(ContactInfoUI.this).field_username + "|2");
          }
          ((r)com.tencent.mm.kernel.g.af(r.class)).a(ContactInfoUI.this.getContext(), null, str, 0, 0, paramAnonymousu, localAppBrandStatObject);
        }
        AppMethodBeat.o(231841);
        return null;
      }
    };
    this.BdT = false;
    this.BdU = null;
    AppMethodBeat.o(26982);
  }
  
  private void eEg()
  {
    AppMethodBeat.i(26987);
    if ((this.BdQ == null) || (!com.tencent.mm.ui.statusbar.c.Qow))
    {
      AppMethodBeat.o(26987);
      return;
    }
    com.tencent.mm.ui.statusbar.c localc = com.tencent.mm.ui.statusbar.c.bt(this);
    c.a local8 = new c.a()
    {
      public final void yf(int paramAnonymousInt)
      {
        AppMethodBeat.i(231842);
        if ((ContactInfoUI.h(ContactInfoUI.this)) || (ContactInfoUI.i(ContactInfoUI.this))) {
          ContactInfoUI.j(ContactInfoUI.this).setPadding(0, paramAnonymousInt, 0, 0);
        }
        AppMethodBeat.o(231842);
      }
    };
    this.BdS = local8;
    localc.a(local8);
    getWindow().getDecorView().requestApplyInsets();
    com.tencent.mm.ui.statusbar.d.e(getWindow());
    AppMethodBeat.o(26987);
  }
  
  private void eEh()
  {
    AppMethodBeat.i(27003);
    if (com.tencent.mm.compatible.util.d.oD(19))
    {
      getWindow().clearFlags(201327616);
      AppMethodBeat.o(27003);
      return;
    }
    getWindow().clearFlags(1024);
    AppMethodBeat.o(27003);
  }
  
  private void eEi()
  {
    AppMethodBeat.i(27006);
    if (this.iqo)
    {
      com.tencent.mm.ui.base.u.makeText(MMApplicationContext.getContext(), getResources().getString(2131766547), 0).show();
      AppMethodBeat.o(27006);
      return;
    }
    if ((this.BdH) && (this.BdD != null)) {
      this.BdD.hbY();
    }
    AppMethodBeat.o(27006);
  }
  
  private void eEj()
  {
    boolean bool2 = true;
    AppMethodBeat.i(27007);
    Log.i("MicroMsg.ContactInfoUI", "updateUIByStory: %s %s %s %s", new Object[] { Boolean.valueOf(this.BdE), Boolean.valueOf(this.BdH), Boolean.valueOf(this.BdJ), Boolean.valueOf(this.BdI) });
    Object localObject;
    if ((this.BdH) && (!this.iqo))
    {
      eEg();
      setActionbarColor(getContext().getResources().getColor(2131101287));
      setMMTitle("");
      if (this.BdD != null)
      {
        this.BdD.setBackground(at.aN(getContext(), 2130969381));
        this.BdD.setSupportOverscroll(true);
      }
      if (this.BdR != null) {
        this.BdR.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(231832);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactInfoUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            Log.i("MicroMsg.ContactInfoUI", "onClick: actionBarClick action_bar_root");
            ContactInfoUI.p(ContactInfoUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactInfoUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(231832);
          }
        });
      }
      if (this.screen != null)
      {
        localObject = (NormalProfileHeaderPreference)this.screen.bmg("contact_profile_header_normal");
        if (localObject != null) {
          if ((!this.BdH) || (this.iqo)) {
            break label451;
          }
        }
      }
    }
    label281:
    label451:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((NormalProfileHeaderPreference)localObject).b(bool1, this.BdR.getHeight(), this.BdI);
      AppMethodBeat.o(27007);
      return;
      if (this.BdI)
      {
        eEg();
        setActionbarColor(getContext().getResources().getColor(2131101287));
        setMMTitle("");
        if (this.BdD != null)
        {
          this.BdD.setBackground(null);
          if (this.contact != null) {
            break label349;
          }
          localObject = "";
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((com.tencent.mm.plugin.textstatus.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).isHasStatusThumb((String)localObject))) {
            break label360;
          }
        }
        label349:
        label360:
        for (bool1 = true;; bool1 = false)
        {
          this.BdD.setSupportOverscroll(bool1);
          this.BdD.setNeedHover(true);
          if (this.BdR == null) {
            break;
          }
          this.BdR.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(231833);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactInfoUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              Log.i("MicroMsg.ContactInfoUI", "onClick: actionBarClick action_bar_root2");
              if (TextUtils.equals(ContactInfoUI.this.getIntent().getStringExtra("Contact_User"), com.tencent.mm.plugin.auth.a.a.ceA())) {
                ((com.tencent.mm.plugin.textstatus.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).goUnReadMsgPage(ContactInfoUI.this);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactInfoUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(231833);
            }
          });
          break;
          localObject = this.contact.field_username;
          break label281;
        }
      }
      getWindow().clearFlags(-2147483648);
      setActionbarColor(getContext().getResources().getColor(2131099650));
      setMMTitle("");
      if (this.BdD != null)
      {
        this.BdD.setBackground(at.aN(getContext(), 2130969382));
        this.BdD.setSupportOverscroll(false);
      }
      if (this.BdQ == null) {
        break;
      }
      this.BdQ.setPadding(0, 0, 0, 0);
      break;
    }
  }
  
  public final void a(bq parambq)
  {
    AppMethodBeat.i(231850);
    MMHandlerThread.postToMainThread(new b(this, parambq));
    AppMethodBeat.o(231850);
  }
  
  public final void a(cn paramcn)
  {
    AppMethodBeat.i(27001);
    MMHandlerThread.postToMainThread(new c(this, paramcn));
    AppMethodBeat.o(27001);
  }
  
  public final void eEb()
  {
    AppMethodBeat.i(26983);
    Log.i("MicroMsg.ContactInfoUI", "story_cat storyUINoStory");
    this.BdH = false;
    if ((this.BdD != null) && (!this.BdD.isVisible))
    {
      showTitleView();
      eEh();
      this.BdD.hbX();
    }
    eEj();
    AppMethodBeat.o(26983);
  }
  
  public final void eEc()
  {
    AppMethodBeat.i(26984);
    Log.i("MicroMsg.ContactInfoUI", "story_cat storyUIHasStory");
    this.BdH = true;
    if ((this.BdD != null) && (this.BdD.isVisible)) {
      eEj();
    }
    AppMethodBeat.o(26984);
  }
  
  public final void eEd()
  {
    AppMethodBeat.i(26985);
    Log.i("MicroMsg.ContactInfoUI", "story_cat storyUIBackPressed");
    this.BdD.hbX();
    AppMethodBeat.o(26985);
  }
  
  public final void eEe()
  {
    AppMethodBeat.i(231848);
    Log.i("MicroMsg.ContactInfoUI", "statusUINoStatus");
    this.BdI = false;
    if ((this.BdD != null) && (!this.BdD.isVisible))
    {
      showTitleView();
      eEh();
      this.BdD.hbX();
    }
    eEj();
    AppMethodBeat.o(231848);
  }
  
  public final void eEf()
  {
    AppMethodBeat.i(231849);
    Log.i("MicroMsg.ContactInfoUI", "statusUIHasStatus");
    this.BdI = true;
    if ((this.BdD != null) && (this.BdD.isVisible)) {
      eEj();
    }
    AppMethodBeat.o(231849);
  }
  
  public void finish()
  {
    AppMethodBeat.i(27008);
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.FuH;
    com.tencent.mm.plugin.story.h.h.fqi().eQv = 0L;
    super.finish();
    AppMethodBeat.o(27008);
  }
  
  public String getIdentString()
  {
    AppMethodBeat.i(26995);
    if ((this.contact == null) || ((int)this.contact.gMZ == 0) || (Util.isNullOrNil(this.contact.field_username)))
    {
      AppMethodBeat.o(26995);
      return "";
    }
    Log.i("MicroMsg.ContactInfoUI", "getIdentityString %s", new Object[] { this.contact.field_username });
    if (com.tencent.mm.al.g.DQ(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_EnterpriseChat";
    }
    if (com.tencent.mm.al.g.Ng(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_EnterpriseFatherBiz";
    }
    if (com.tencent.mm.al.g.Nf(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_EnterpriseChildBiz";
    }
    if (this.contact.gBM())
    {
      AppMethodBeat.o(26995);
      return "_bizContact";
    }
    if (ab.Eq(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_chatroom";
    }
    if (ab.IG(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_bottle";
    }
    if (ab.IH(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_QQ";
    }
    if (ab.JE(this.contact.field_username))
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
    return 2132017203;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26996);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.wZz = getIntent().getStringExtra("Verify_ticket");
    this.Bdx = getIntent().getBooleanExtra("Chat_Readonly", false);
    this.Bdy = getIntent().getBooleanExtra("User_Verify", false);
    this.roomId = getIntent().getStringExtra("Contact_ChatRoomId");
    String str1 = Util.nullAsNil(getIntent().getStringExtra("Contact_User"));
    Object localObject5 = Util.nullAsNil(getIntent().getStringExtra("Contact_Alias"));
    Object localObject1 = Util.nullAsNil(getIntent().getStringExtra("Contact_Encryptusername"));
    if (str1.endsWith("@stranger")) {
      localObject1 = str1;
    }
    bg.aVF();
    this.contact = com.tencent.mm.model.c.aSN().Kn(str1);
    this.kgm = getIntent().getIntExtra("Contact_Scene", 9);
    if (this.contact != null) {
      this.contact.Ooy = str1;
    }
    com.tencent.mm.plugin.profile.b.jRu.a(this.contact);
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
    this.BdC = getIntent().getStringExtra("Contact_BrandIconURL");
    String str9 = getIntent().getStringExtra("Contact_RegionCode");
    this.Bdz = getIntent().getByteArrayExtra("Contact_customInfo");
    int i1 = getIntent().getIntExtra("Contact_Ext_Flag", 0);
    boolean bool2 = getIntent().getBooleanExtra("force_get_contact", false);
    Log.i("MicroMsg.ContactInfoUI", "dkverify forceGetContact:%s  user:%s  roomid:%s, addContactScene: %d", new Object[] { Boolean.valueOf(bool2), str1, this.roomId, Integer.valueOf(this.kgm) });
    Object localObject2;
    Object localObject8;
    label772:
    label792:
    int k;
    int i;
    label1304:
    label1361:
    boolean bool1;
    if (bool2)
    {
      Log.d("MicroMsg.ContactInfoUI", "initView, forceGetContact, user = ".concat(String.valueOf(str1)));
      if ((this.contact != null) && (com.tencent.mm.contact.c.oR(this.contact.field_type))) {
        ay.a.iDq.aL(str1, this.roomId);
      }
    }
    else
    {
      if (((this.contact == null) || ((int)this.contact.gMZ == 0)) && (as.bjp(str1)) && (this.kgm != 15))
      {
        localObject4 = Util.nullAsNil(getIntent().getStringExtra(e.d.OyT));
        localObject2 = localObject4;
        if (Util.isNullOrNil((String)localObject4)) {
          localObject2 = this.wZz;
        }
        com.tencent.mm.kernel.g.aAg().hqi.a(new com.tencent.mm.openim.b.h(str1, Util.nullAsNil(this.roomId), (String)localObject2), 0);
      }
      if ((this.contact != null) && ((int)this.contact.gMZ > 0) && ((!ab.JF(this.contact.field_username)) || ((as.bjo(this.contact.field_username)) && (!ab.IR(this.contact.field_username)))))
      {
        if ((!this.contact.gBQ()) || (!as.bjp(this.contact.field_username))) {
          break label2031;
        }
        localObject4 = Util.nullAsNil(getIntent().getStringExtra(e.d.OyT));
        localObject2 = localObject4;
        if (Util.isNullOrNil((String)localObject4)) {
          localObject2 = this.wZz;
        }
        localObject8 = com.tencent.mm.kernel.g.aAg().hqi;
        String str10 = this.contact.field_username;
        if (!com.tencent.mm.contact.c.oR(this.contact.field_type)) {
          break label2019;
        }
        localObject4 = "";
        ((t)localObject8).a(new com.tencent.mm.openim.b.h(str10, (String)localObject4, (String)localObject2), 0);
      }
      getIntent().getIntExtra("Contact_verify_Scene", 9);
      getIntent().getIntExtra("key_add_contact_match_type", 0);
      localObject2 = getIntent().getStringExtra("key_add_contact_openim_appid");
      k = getIntent().getIntExtra("key_add_contact_custom_detail_visible", 0);
      localObject4 = getIntent().getStringExtra("key_add_contact_custom_detail");
      getIntent().getStringExtra("key_add_contact_desc_wording_id");
      getIntent().getStringExtra("key_add_contact_desc_icon");
      if ((this.contact != null) && ((int)this.contact.gMZ != 0) && (Util.nullAsNil(this.contact.field_username).length() > 0)) {
        break label2272;
      }
      this.contact = new as();
      this.contact.setUsername(str1);
      this.contact.BC((String)localObject5);
      this.contact.setNickname((String)localObject6);
      this.contact.BF(getIntent().getStringExtra("Contact_PyInitial"));
      this.contact.BG(getIntent().getStringExtra("Contact_QuanPin"));
      this.contact.nj(j);
      this.contact.BW(str4);
      this.contact.BX((String)localObject7);
      this.contact.BV(str5);
      this.contact.nf(m);
      this.contact.Ca(str6);
      this.contact.BY(str2);
      this.contact.BZ(str7);
      this.contact.ne(n);
      this.contact.BH(str8);
      this.contact.yx(l);
      this.contact.BQ(str3);
      this.contact.Cb(str9);
      this.contact.nq(i1);
      if ((!Util.isNullOrNil(this.BdB)) && (this.kgm == 15))
      {
        bg.aVF();
        localObject5 = com.tencent.mm.model.c.aSO().aEZ(str1);
        localObject6 = new cn(str1);
        ((cn)localObject6).field_conRemark = ((cn)localObject5).field_conRemark;
        ((cn)localObject6).field_conDescription = ((cn)localObject5).field_conDescription;
        ((cn)localObject6).field_contactLabels = ((cn)localObject5).field_contactLabels;
        ((cn)localObject6).field_conPhone = this.BdB;
        bg.aVF();
        com.tencent.mm.model.c.aSO().replace((IAutoDBItem)localObject6);
        this.BdB = null;
      }
      this.contact.Ck((String)localObject4);
      this.contact.nr(k);
      this.contact.BN((String)localObject2);
      if ((as.bjp(this.contact.field_username)) && ((this.kgm == 30) || (this.kgm == 45) || (this.kgm == 17)))
      {
        localObject2 = com.tencent.mm.plugin.report.service.h.CyF;
        localObject4 = this.contact.field_openImAppid;
        if (this.kgm != 17) {
          break label2893;
        }
        i = 2;
        ((com.tencent.mm.plugin.report.service.h)localObject2).a(15320, new Object[] { localObject4, Integer.valueOf(i) });
      }
      if (!Util.isNullOrNil((String)localObject1)) {
        this.contact.BK((String)localObject1);
      }
      if (this.contact != null) {
        break label2898;
      }
      Log.e("MicroMsg.ContactInfoUI", "contact = null");
      getIntent().putExtra("Contact_User", this.contact.field_username);
      if ((!bool2) && ((int)this.contact.gMZ <= 0) && (this.contact.gBM()) && ((this.kgm == 17) || (this.kgm == 41)))
      {
        Log.d("MicroMsg.ContactInfoUI", "come from card, getContact %s", new Object[] { this.contact.field_username });
        ay.a.iDq.aL(this.contact.field_username, "");
        com.tencent.mm.aj.c.Mf(this.contact.field_username);
      }
      if (this.contact.fuR != null) {
        break label3008;
      }
      bool1 = true;
      label1486:
      if (this.contact.fuR != null) {
        break label3014;
      }
      i = 0;
      label1498:
      if (this.contact.fuR != null) {
        break label3028;
      }
    }
    label2061:
    label2893:
    label2898:
    label3028:
    for (localObject1 = "";; localObject1 = Util.secPrint(this.contact.fuR))
    {
      Log.i("MicroMsg.ContactInfoUI", "contact.getRemarkDesc() (%s, %s, %s)", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), localObject1 });
      if ((!bool2) && ((int)this.contact.gMZ <= 0) && (this.kgm == 96))
      {
        Log.i("MicroMsg.ContactInfoUI", "come from chatroom accessverify, getContact %s", new Object[] { this.contact.field_username });
        ay.a.iDq.j(this.contact.field_username, 1, getIntent().getStringExtra("key_add_contact_verify_ticket"));
        com.tencent.mm.aj.c.ap(this.contact.field_username, 3);
      }
      if (this.contact.field_username.equals(z.aTY()))
      {
        bg.aVF();
        l = Util.getLong((String)com.tencent.mm.model.c.azQ().get(65825, null), 0L);
        if (l > 0L)
        {
          this.contact.yx(l);
          localObject1 = this.contact;
          bg.aVF();
          ((as)localObject1).BQ((String)com.tencent.mm.model.c.azQ().get(65826, null));
        }
        localObject1 = this.contact;
        bg.aVF();
        ((as)localObject1).Ce((String)com.tencent.mm.model.c.azQ().get(286721, null));
        localObject1 = this.contact;
        bg.aVF();
        ((as)localObject1).Cf((String)com.tencent.mm.model.c.azQ().get(286722, null));
        localObject1 = this.contact;
        bg.aVF();
        ((as)localObject1).Cg((String)com.tencent.mm.model.c.azQ().get(286723, null));
      }
      if ((this.contact.field_username != null) && (this.contact.field_username.equals(as.bjz(z.aTY()))))
      {
        localObject1 = bz.aWj();
        localObject2 = Util.nullAsNil(((bz)localObject1).getProvince());
        localObject4 = Util.nullAsNil(((bz)localObject1).getCity());
        if (!Util.isNullOrNil((String)localObject2)) {
          this.contact.BW((String)localObject2);
        }
        if (!Util.isNullOrNil((String)localObject4)) {
          this.contact.BX((String)localObject4);
        }
        if (!Util.isNullOrNil(((bz)localObject1).countryCode)) {
          this.contact.Cb(RegionCodeDecoder.bq(((bz)localObject1).countryCode, ((bz)localObject1).provinceCode, ((bz)localObject1).cityCode));
        }
        i = Util.nullAs(Integer.valueOf(((bz)localObject1).fuA), 0);
        localObject1 = Util.nullAsNil(((bz)localObject1).signature);
        this.contact.nj(i);
        this.contact.BV((String)localObject1);
      }
      if (!Util.isNullOrNil(this.contact.field_username)) {
        break label3043;
      }
      Log.e("MicroMsg.ContactInfoUI", "username is null %s", new Object[] { str1 });
      finish();
      AppMethodBeat.o(26996);
      return;
      ay.a.iDq.aL(str1, "");
      break;
      label2019:
      localObject4 = Util.nullAsNil(this.roomId);
      break label772;
      label2031:
      localObject2 = com.tencent.mm.al.g.fJ(this.contact.field_username);
      if ((this.contact.gBM()) && (com.tencent.mm.al.a.aZz()))
      {
        i = 1;
        if ((localObject2 != null) && ((!((com.tencent.mm.api.c)localObject2).Uz()) || (i != 0))) {
          break label2168;
        }
        Log.d("MicroMsg.ContactInfoUI", "update contact, verifyFlag %d.", new Object[] { Integer.valueOf(m) });
        localObject4 = ay.a.iDq;
        localObject8 = this.contact.field_username;
        if (!com.tencent.mm.contact.c.oR(this.contact.field_type)) {
          break label2159;
        }
      }
      label2159:
      for (localObject2 = "";; localObject2 = this.roomId)
      {
        ((ay.b)localObject4).aL((String)localObject8, (String)localObject2);
        com.tencent.mm.aj.c.Mf(this.contact.field_username);
        break;
        i = 0;
        break label2061;
      }
      label2168:
      if ((!this.contact.gBQ()) || (i != 0)) {
        break label792;
      }
      Log.d("MicroMsg.ContactInfoUI", "update contact, last check time=%d", new Object[] { Integer.valueOf(this.contact.fuP) });
      localObject4 = ay.a.iDq;
      localObject8 = this.contact.field_username;
      if (com.tencent.mm.contact.c.oR(this.contact.field_type)) {}
      for (localObject2 = "";; localObject2 = this.roomId)
      {
        ((ay.b)localObject4).aL((String)localObject8, (String)localObject2);
        com.tencent.mm.aj.c.Mf(this.contact.field_username);
        break;
      }
      label2272:
      if (this.contact.fuA == 0) {
        this.contact.nj(j);
      }
      if ((str4 != null) && (!str4.equals(""))) {
        this.contact.BW(str4);
      }
      if ((localObject7 != null) && (!((String)localObject7).equals(""))) {
        this.contact.BX((String)localObject7);
      }
      if ((str9 != null) && (!str9.equals(""))) {
        this.contact.Cb(str9);
      }
      if ((Util.isNullOrNil(this.contact.signature)) && (str5 != null) && (!str5.equals(""))) {
        this.contact.BV(str5);
      }
      if (m != 0) {
        this.contact.nf(m);
      }
      if ((Util.isNullOrNil(this.contact.fuN)) && (str6 != null) && (!str6.equals(""))) {
        this.contact.Ca(str6);
      }
      if ((Util.isNullOrNil(this.contact.field_nickname)) && (localObject6 != null) && (!((String)localObject6).equals(""))) {
        this.contact.setNickname((String)localObject6);
      }
      Log.i("MicroMsg.ContactInfoUI", "searchMobilePhone:%s", new Object[] { Util.nullAsNil(this.BdB) });
      if ((!Util.isNullOrNil(this.BdB)) && (this.kgm == 15))
      {
        j = 1;
        str4 = this.contact.fuX;
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
          if (localObject7[j].equals(this.BdB)) {
            i = 0;
          }
        }
        else
        {
          if (i != 0)
          {
            this.contact.Ci(str4 + this.BdB + com.tencent.mm.contact.a.d(this.contact));
            this.BdB = null;
          }
          Log.i("MicroMsg.ContactInfoUI", "contact PhoneList:%s", new Object[] { Util.nullAsNil(this.contact.fuX) });
          this.contact.setSource(15);
          this.contact.BY(str2);
          this.contact.yx(l);
          this.contact.BQ(str3);
          if (!com.tencent.mm.contact.c.oR(this.contact.field_type))
          {
            if (!Util.isNullOrNil((String)localObject5)) {
              this.contact.BC((String)localObject5);
            }
            if (!Util.isNullOrNil((String)localObject6)) {
              this.contact.setNickname((String)localObject6);
            }
            localObject5 = getIntent().getStringExtra("Contact_PyInitial");
            if (!Util.isNullOrNil((String)localObject5)) {
              this.contact.BF((String)localObject5);
            }
            localObject5 = getIntent().getStringExtra("Contact_QuanPin");
            if (!Util.isNullOrNil((String)localObject5)) {
              this.contact.BG((String)localObject5);
            }
          }
          if ((!com.tencent.mm.contact.c.oR(this.contact.field_type)) && (!Util.isNullOrNil((String)localObject4))) {
            this.contact.Ck((String)localObject4);
          }
          if ((!com.tencent.mm.contact.c.oR(this.contact.field_type)) && (k != 0)) {
            this.contact.nr(k);
          }
          if (Util.isNullOrNil((String)localObject2)) {
            break;
          }
          this.contact.BN((String)localObject2);
          break;
        }
        j += 1;
      }
      i = 1;
      break label1304;
      if (!Util.isNullOrNil((String)localObject1))
      {
        bg.aVF();
        localObject1 = com.tencent.mm.model.c.aSO().aEZ((String)localObject1);
        if ((localObject1 != null) && (!Util.isNullOrNil(((cn)localObject1).field_encryptUsername)))
        {
          this.contact.BD(((cn)localObject1).field_conRemark);
          break label1361;
        }
      }
      if (Util.isNullOrNil(str1)) {
        break label1361;
      }
      bg.aVF();
      localObject1 = com.tencent.mm.model.c.aSO().aEZ(str1);
      if ((localObject1 == null) || (Util.isNullOrNil(((cn)localObject1).field_encryptUsername))) {
        break label1361;
      }
      this.contact.BD(((cn)localObject1).field_conRemark);
      break label1361;
      bool1 = false;
      break label1486;
      i = this.contact.fuR.length();
      break label1498;
    }
    label3008:
    label3014:
    label3043:
    setMMTitle("");
    Object localObject4 = this.BdC;
    if (ab.IK(this.contact.field_username))
    {
      this.Bdv = ((com.tencent.mm.plugin.wxpaysdk.api.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.wxpaysdk.api.c.class)).hK(this);
      localObject1 = new nf();
      ((nf)localObject1).eXG = 2L;
      ((nf)localObject1).bfK();
      if (this.Bdv != null)
      {
        this.Bdv.a(this.screen, this.contact, this.Bdx, this.kgm);
        localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(this.contact.field_username);
        localObject1 = "";
        if (localObject2 != null) {
          localObject1 = Util.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).bnP()).replace(" ", "");
        }
        if ((!this.BdT) && (com.tencent.mm.contact.c.oR(this.contact.field_type)) && ((this.Bdv instanceof l)))
        {
          j = com.tencent.mm.contact.a.f(this.contact);
          if (!Util.isNullOrNil((String)localObject1)) {
            break label5425;
          }
          i = 0;
          label3233:
          j = i + j;
          localObject2 = com.tencent.mm.plugin.report.service.h.CyF;
          localObject4 = this.contact.field_username;
          if (!Util.isNullOrNil((String)localObject1)) {
            break label5430;
          }
          i = 0;
          label3261:
          if (j < 5) {
            break label5435;
          }
          j = 5;
        }
      }
    }
    label4379:
    label5425:
    label5430:
    label5435:
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject2).a(12040, new Object[] { localObject4, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(j) });
      this.BdT = true;
      if ((!(this.Bdv instanceof l)) && (!(this.Bdv instanceof c)) && (!(this.Bdv instanceof ContactWidgetTabBizInfo)))
      {
        bg.aVF();
        localObject1 = (String)com.tencent.mm.model.c.azQ().get(ar.a.Ocb, "");
        if (((String)localObject1).contains(this.contact.field_username))
        {
          localObject1 = ((String)localObject1).replaceAll(this.contact.field_username + ",*", "");
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(ar.a.Ocb, localObject1);
          Log.i("MicroMsg.ContactInfoUI", "mark plugin read, userName:%s, newVal:%s", new Object[] { this.contact.field_username, localObject1 });
          if (Util.isNullOrNil((String)localObject1)) {
            com.tencent.mm.y.c.axV().B(262158, false);
          }
        }
      }
      if (this.screen != null)
      {
        localObject1 = (NormalProfileHeaderPreference)this.screen.bmg("contact_profile_header_normal");
        if (localObject1 != null) {
          ((NormalProfileHeaderPreference)localObject1).b(this.BdH, this.BdR.getHeight(), this.BdI);
        }
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(231844);
          if (((ab.Ji(ContactInfoUI.g(ContactInfoUI.this).field_username)) && (!z.aUx())) || ((ab.Ja(ContactInfoUI.g(ContactInfoUI.this).field_username)) && (!z.aUt())) || ((ab.Jc(ContactInfoUI.g(ContactInfoUI.this).field_username)) && (!z.aUD())) || ((ab.IW(ContactInfoUI.g(ContactInfoUI.this).field_username)) && (!z.aUH())))
          {
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.addFlags(67108864);
            com.tencent.mm.plugin.profile.b.jRt.o(paramAnonymousMenuItem, ContactInfoUI.this);
          }
          ContactInfoUI.this.finish();
          com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(ContactInfoUI.g(ContactInfoUI.this).field_username, 1501, ContactInfoUI.k(ContactInfoUI.this), ContactInfoUI.l(ContactInfoUI.this));
          AppMethodBeat.o(231844);
          return true;
        }
      });
      com.tencent.mm.aj.p.aYD().Mh(this.contact.field_username);
      if (((!ab.Ji(this.contact.field_username)) || (!z.aUx())) && ((!ab.Ja(this.contact.field_username)) || (!z.aUt())) && ((!ab.Jc(this.contact.field_username)) || (!z.aUD())) && ((!ab.IW(this.contact.field_username)) || (!z.aUH()))) {
        break label5438;
      }
      this.BdA = true;
      AppMethodBeat.o(26996);
      return;
      if (ab.IL(this.contact.field_username))
      {
        this.Bdv = ((com.tencent.mm.plugin.wxpaysdk.api.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.wxpaysdk.api.c.class)).hL(this);
        break;
      }
      if ((1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.soA, 0)) && (ab.IM(this.contact.field_username)))
      {
        this.Bdv = new k(this);
        break;
      }
      if (ab.IJ(this.contact.field_username))
      {
        this.Bdv = com.tencent.mm.br.c.ak(this, "sport");
        break;
      }
      if (ab.IW(this.contact.field_username))
      {
        this.Bdv = com.tencent.mm.br.c.ak(this, "qqmail");
        break;
      }
      if (ab.IX(this.contact.field_username))
      {
        this.Bdv = new e(this);
        break;
      }
      if (ab.IY(this.contact.field_username))
      {
        this.Bdv = com.tencent.mm.br.c.ak(this, "tmessage");
        break;
      }
      if (ab.Jk(this.contact.field_username))
      {
        this.Bdv = new com.tencent.mm.plugin.topstory.ui.widget.a(this);
        break;
      }
      if (ab.IQ(this.contact.field_username))
      {
        this.Bdv = new h(this);
        break;
      }
      if (ab.Je(this.contact.field_username))
      {
        this.Bdv = new n(this);
        break;
      }
      if (as.IG(this.contact.field_username))
      {
        this.Bdv = new d(this);
        break;
      }
      if (ab.Jg(this.contact.field_username))
      {
        this.Bdv = com.tencent.mm.br.c.ak(this, "nearby");
        break;
      }
      if (ab.Jh(this.contact.field_username))
      {
        this.Bdv = com.tencent.mm.br.c.ak(this, "shake");
        break;
      }
      if (ab.Ji(this.contact.field_username))
      {
        this.Bdv = new j(this);
        break;
      }
      if (ab.Jj(this.contact.field_username))
      {
        this.Bdv = com.tencent.mm.br.c.W(this, "readerapp", "widget_type_news");
        break;
      }
      if (ab.Jr(this.contact.field_username))
      {
        this.Bdv = com.tencent.mm.br.c.W(this, "readerapp", "widget_type_weibo");
        break;
      }
      if (ab.Jb(this.contact.field_username))
      {
        this.Bdv = new f(this);
        break;
      }
      if (ab.Jc(this.contact.field_username))
      {
        this.Bdv = com.tencent.mm.br.c.ak(this, "masssend");
        break;
      }
      if (ab.Jd(this.contact.field_username))
      {
        this.Bdv = new g(this);
        break;
      }
      if ((this.contact.gBM()) || (getIntent().getBooleanExtra("key_use_new_contact_profile", false)))
      {
        for (localObject1 = null;; localObject1 = localObject2)
        {
          try
          {
            localObject2 = this.Bdz;
            if (localObject2 != null) {
              break label4379;
            }
            localObject1 = null;
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.ContactInfoUI", localIOException, "", new Object[0]);
              continue;
              if (com.tencent.mm.al.g.Nd(localIOException))
              {
                bool1 = true;
              }
              else
              {
                if (localObject1 != null)
                {
                  localObject3 = new com.tencent.mm.api.c();
                  ((com.tencent.mm.api.c)localObject3).field_extInfo = ((aeq)localObject1).ken;
                  ((com.tencent.mm.api.c)localObject3).field_type = ((com.tencent.mm.api.c)localObject3).cG(false).getServiceType();
                  if (((com.tencent.mm.api.c)localObject3).UD())
                  {
                    bool1 = true;
                    continue;
                  }
                  if (((com.tencent.mm.api.c)localObject3).UC())
                  {
                    bool1 = true;
                    continue;
                  }
                }
                if (getIntent().getBooleanExtra("key_use_new_contact_profile", false)) {
                  bool1 = true;
                } else if ((!com.tencent.mm.al.g.Ng(this.contact.field_username)) && (!com.tencent.mm.al.g.Nf(this.contact.field_username)) && (this.contact.gBM())) {
                  bool1 = true;
                } else {
                  bool1 = false;
                }
              }
            }
            localObject1 = new c(this, (String)localObject4, (aeq)localObject1);
            if (Util.isNullOrNil(this.wZz)) {
              break label4605;
            }
            ((c)localObject1).wZz = this.wZz;
            this.Bdv = ((com.tencent.mm.pluginsdk.b.a)localObject1);
          }
          localObject2 = this.contact.field_username;
          if ((!MMApplicationContext.getDefaultPreference().getBoolean("use_new_profile", true)) || (ab.JM((String)localObject2)) || (ab.Jf((String)localObject2)) || (ab.Jq((String)localObject2))) {
            break label4566;
          }
          if (!com.tencent.mm.al.g.Nb((String)localObject2)) {
            break label4424;
          }
          bool1 = true;
          Log.i("MicroMsg.ContactInfoUI", "username:%s, isUseNewProfileUI:%b", new Object[] { this.contact.field_username, Boolean.valueOf(bool1) });
          if (!bool1) {
            break label4572;
          }
          if (this.BdU == null) {
            this.BdU = new ContactWidgetTabBizInfo(this, (String)localObject4, (aeq)localObject1, this.viC);
          }
          this.BdU.BdC = ((String)localObject4);
          this.BdU.BeX = ((aeq)localObject1);
          this.BdU.enterTime = this.viC;
          this.BdU.wZz = this.wZz;
          this.Bdv = this.BdU;
          break;
          localObject2 = (aeq)new aeq().parseFrom(this.Bdz);
        }
        label4424:
        label4566:
        label4572:
        label4605:
        break;
      }
      if (ab.Jn(this.contact.field_username))
      {
        this.Bdv = new o(this);
        break;
      }
      if (ab.Jo(this.contact.field_username))
      {
        this.Bdv = new i(this);
        break;
      }
      if (ab.IP(this.contact.field_username))
      {
        this.Bdv = new com.tencent.mm.plugin.downloader_app.d.a(this);
        break;
      }
      this.Bdv = new com.tencent.mm.plugin.profile.a(this);
      if ((this.BdE) || ((this.Bdv instanceof ContactWidgetTabBizInfo))) {
        break;
      }
      localObject1 = (RelativeLayout)findViewById(2131304720);
      if (localObject1 == null) {
        break;
      }
      Log.i("MicroMsg.ContactInfoUI", "setupStory %s stack %s", new Object[] { this, Util.getStack().toString() });
      this.BdE = true;
      this.BdD = ((PullDownListView)getListView());
      this.BdD.setBackground(at.aN(getContext(), 2130969381));
      if (this.BdJ)
      {
        this.BdD.setBackground(null);
        this.BdD.QRK = this.BdP;
        localObject3 = new View(this);
        ((RelativeLayout)localObject1).addView((View)localObject3, 0);
        localObject4 = (RelativeLayout.LayoutParams)((View)localObject3).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject4).width = -1;
        ((RelativeLayout.LayoutParams)localObject4).height = -1;
        ((RelativeLayout.LayoutParams)localObject4).topMargin = au.az(getContext()).x;
        ((View)localObject3).setBackgroundColor(getResources().getColor(2131099648));
        float f = ah.jS(getContext()).width;
        this.BdD.setTranslationListener(new PullDownListView.a()
        {
          public final void bI(float paramAnonymousFloat)
          {
            float f1 = 0.0F;
            AppMethodBeat.i(231830);
            this.val$v.setTranslationY(paramAnonymousFloat);
            float f2 = paramAnonymousFloat / this.BdW;
            if (paramAnonymousFloat < 0.0F) {}
            for (;;)
            {
              if (paramAnonymousFloat > this.BdW) {}
              for (paramAnonymousFloat = 1.0F;; paramAnonymousFloat = f1)
              {
                if (ContactInfoUI.e(ContactInfoUI.this) != null) {
                  ContactInfoUI.e(ContactInfoUI.this).cd(paramAnonymousFloat);
                }
                if (ContactInfoUI.o(ContactInfoUI.this) != null)
                {
                  localObject = ContactInfoUI.o(ContactInfoUI.this);
                  if (((NormalProfileHeaderPreference)localObject).zlc == null) {
                    break label126;
                  }
                }
                label126:
                for (Object localObject = ((NormalProfileHeaderPreference.a)((NormalProfileHeaderPreference)localObject).zlc.getTag()).BgT;; localObject = null)
                {
                  if (localObject != null) {
                    ((View)localObject).setAlpha((1.0F - paramAnonymousFloat) * 1.0F);
                  }
                  AppMethodBeat.o(231830);
                  return;
                }
              }
              f1 = f2;
            }
          }
        });
        localObject3 = ((com.tencent.mm.plugin.textstatus.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).getBackPreview(this);
        localObject4 = getIntent().getStringExtra("Contact_User");
        if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (localObject3 != null) && (((com.tencent.mm.plugin.textstatus.a.b)localObject3).getView() != null))
        {
          ((RelativeLayout)localObject1).addView(((com.tencent.mm.plugin.textstatus.a.b)localObject3).getView(), 0);
          localObject1 = (RelativeLayout.LayoutParams)((com.tencent.mm.plugin.textstatus.a.b)localObject3).getView().getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).width = -1;
          ((RelativeLayout.LayoutParams)localObject1).height = -1;
          ((com.tencent.mm.plugin.textstatus.a.b)localObject3).a(this);
          ((com.tencent.mm.plugin.textstatus.a.b)localObject3).DV((String)localObject4);
        }
        this.BdM = ((com.tencent.mm.plugin.textstatus.a.b)localObject3);
        this.BdD.setNavigationBarHeight(au.aD(getContext()));
        this.BdN = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(231831);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactInfoUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            Log.i("MicroMsg.ContactInfoUI", "onClick: NormalProfileHeaderPreference");
            ContactInfoUI.p(ContactInfoUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactInfoUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(231831);
          }
        };
        localObject1 = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.fqi().eQv = 3L;
        break;
      }
      if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).isShowStoryCheck()) {
        break;
      }
      this.BdD.QRK = this.BdO;
      i = -au.az(getContext()).y / 10;
      Object localObject3 = new RelativeLayout.LayoutParams(-1, au.az(getContext()).y);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = (-au.aD(getContext()));
      if (this.contact.field_username.equals(z.aTY())) {}
      for (this.BdF = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(this, com.tencent.mm.plugin.story.api.n.a.Fky, this.roomId);; this.BdF = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(this, com.tencent.mm.plugin.story.api.n.a.Fkz, this.roomId))
      {
        this.BdF.fmS();
        this.BdD.y(this.BdF, com.tencent.mm.cb.a.aH(getContext(), 2131166841), i);
        this.BdF.setStoryBrowseUIListener(this);
        this.BdF.setDataSeed(this.contact.field_username);
        this.BdF.a(this.BdD);
        ((RelativeLayout)localObject1).addView(this.BdF, 0, (ViewGroup.LayoutParams)localObject3);
        com.tencent.mm.kernel.g.aAi();
        this.BdG = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().hh(this);
        localObject3 = new RelativeLayout.LayoutParams(com.tencent.mm.cb.a.aH(getContext(), 2131166840), com.tencent.mm.cb.a.aH(getContext(), 2131166840));
        ((RelativeLayout.LayoutParams)localObject3).addRule(9);
        ((RelativeLayout.LayoutParams)localObject3).addRule(12);
        ((RelativeLayout)localObject1).addView(this.BdG, 0, (ViewGroup.LayoutParams)localObject3);
        this.BdD.setMuteView(this.BdG);
        break;
      }
      i = 1;
      break label3233;
      i = 1;
      break label3261;
    }
    label5438:
    this.BdA = false;
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
    if (this.Bdv != null) {
      this.Bdv.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(26997);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(27005);
    if (((this.BdF == null) || (!this.BdF.onBackPressed())) && (!getSupportFragmentManager().isDestroyed())) {
      super.onBackPressed();
    }
    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(this.contact.field_username, 1501, this.kgm, this.viC);
    AppMethodBeat.o(27005);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(26988);
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1) {
      this.iqo = false;
    }
    for (;;)
    {
      if ((this.BdD != null) && (!this.BdD.isVisible)) {
        this.BdD.hbX();
      }
      eEj();
      AppMethodBeat.o(26988);
      return;
      if (paramConfiguration.orientation == 2) {
        this.iqo = true;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26986);
    this.BdJ = com.tencent.mm.plugin.textstatus.a.p.fvC();
    if ((this.BdJ) && (((com.tencent.mm.plugin.textstatus.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).hasStatus(getIntent().getStringExtra("Contact_User"))))
    {
      bool = true;
      this.BdI = bool;
      bg.aVF();
      as localas = com.tencent.mm.model.c.aSN().Kn(Util.nullAsNil(getIntent().getStringExtra("Contact_User")));
      if (localas == null) {
        break label292;
      }
      com.tencent.mm.kernel.g.aAi();
      if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(localas.field_username)) {
        break label292;
      }
      this.BdH = true;
      label114:
      if (this.BdJ) {
        this.BdH = false;
      }
      if ((this.BdH) || (this.BdI)) {
        customfixStatusbar(true);
      }
      super.onCreate(paramBundle);
      if (getResources().getConfiguration().orientation != 2) {
        break label300;
      }
    }
    label292:
    label300:
    for (boolean bool = true;; bool = false)
    {
      this.iqo = bool;
      this.viC = System.currentTimeMillis();
      this.BdQ = findViewById(2131296366);
      this.BdR = this.BdQ.findViewById(2131296369);
      eEj();
      paramBundle = getWindow().getDecorView();
      paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x400 | 0x100);
      Log.i("MicroMsg.ContactInfoUI", "onCreate MMCore.accHasReady[%b]", new Object[] { Boolean.valueOf(bg.aAc()) });
      this.BdB = getIntent().getStringExtra("Contact_Search_Mobile");
      if (com.tencent.mm.kernel.g.aAf().azp()) {
        break label305;
      }
      finish();
      AppMethodBeat.o(26986);
      return;
      bool = false;
      break;
      this.BdH = false;
      break label114;
    }
    label305:
    bg.aVF();
    com.tencent.mm.model.c.aSN().add(this);
    bg.aVF();
    com.tencent.mm.model.c.aSO().a(this);
    bg.aVF();
    com.tencent.mm.model.c.aSP().a(this);
    initView();
    hideActionbarLine();
    if ((this.Bdv instanceof com.tencent.mm.pluginsdk.b.b)) {
      ((com.tencent.mm.pluginsdk.b.b)this.Bdv).onCreate();
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(getIntent())), Integer.valueOf(1), Integer.valueOf(1), this.contact.field_username });
    paramBundle = com.tencent.mm.plugin.story.h.h.FuH;
    com.tencent.mm.plugin.story.h.h.fqi().eRK = com.tencent.mm.plugin.profile.d.aP(getIntent());
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(273, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(291, this);
    AppMethodBeat.o(26986);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26989);
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.FuH;
    com.tencent.mm.plugin.story.h.h.fqi().eRK = 0L;
    if (com.tencent.mm.kernel.g.aAf().azp())
    {
      bg.aVF();
      com.tencent.mm.model.c.aSN().remove(this);
      bg.aVF();
      com.tencent.mm.model.c.aSO().b(this);
      bg.aVF();
      com.tencent.mm.model.c.aSP().b(this);
    }
    if (this.Bdv == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ContactInfoUI", "onDestroy bodyWidget is null?%s", new Object[] { Boolean.valueOf(bool) });
      if (this.Bdv != null) {
        this.Bdv.cCs();
      }
      if ((this.Bdv instanceof com.tencent.mm.pluginsdk.b.b)) {
        ((com.tencent.mm.pluginsdk.b.b)this.Bdv).axa();
      }
      if (com.tencent.mm.plugin.sns.b.o.DCM != null) {
        com.tencent.mm.plugin.sns.b.o.DCM.aI(this);
      }
      super.onDestroy();
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.b(273, this);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.b(291, this);
      if (this.BdF != null) {
        this.BdF.onDestroy();
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(getIntent())), Integer.valueOf(18), Integer.valueOf(1), this.contact.field_username });
      com.tencent.mm.plugin.report.service.h.CyF.a(17283, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(getIntent())), this.contact.field_username, Boolean.valueOf(this.BdH), Boolean.valueOf(this.BdK), Integer.valueOf(this.contact.uin), Integer.valueOf(this.BdL) });
      if (this.BdM != null) {
        this.BdM.fvv();
      }
      AppMethodBeat.o(26989);
      return;
    }
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(26999);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      Log.i("MicroMsg.ContactInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(26999);
      return;
    }
    onNotifyChange((String)paramObject, null);
    AppMethodBeat.o(26999);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(27000);
    new MMHandler().post(new a(this, paramString));
    AppMethodBeat.o(27000);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26993);
    com.tencent.mm.modelstat.d.d(4, "ContactInfoUI" + getIdentString(), hashCode());
    ag.bah().remove(this);
    super.onPause();
    bg.aAk().postAtFrontOfQueueToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(231843);
        bg.aVF();
        com.tencent.mm.model.c.azQ().gBI();
        AppMethodBeat.o(231843);
      }
    });
    if (getIntent().getBooleanExtra("key_from_wesport_right_newtips", false))
    {
      com.tencent.mm.plugin.newtips.a.exl();
      com.tencent.mm.plugin.newtips.a.i.aw(com.tencent.mm.plugin.newtips.a.d.ADd, getActivityBrowseTimeMs());
    }
    for (;;)
    {
      eEh();
      if (this.BdF != null) {
        this.BdF.onPause();
      }
      if (((this.Bdv instanceof c)) || ((this.Bdv instanceof ContactWidgetTabBizInfo))) {
        this.Bdv.cCs();
      }
      com.tencent.mm.pluginsdk.ui.span.l.b(this.ptq);
      if (this.BdM != null) {
        this.BdM.fvx();
      }
      AppMethodBeat.o(26993);
      return;
      if (getIntent().getBooleanExtra("key_from_wesport_plugin_newtips", false))
      {
        com.tencent.mm.plugin.newtips.a.exl();
        com.tencent.mm.plugin.newtips.a.i.aw(com.tencent.mm.plugin.newtips.a.d.ADb, getActivityBrowseTimeMs());
      }
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(26998);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.ContactInfoUI", paramf + " item has been clicked!");
    if (this.Bdv != null) {
      this.Bdv.alD(paramf);
    }
    if (paramPreference != null)
    {
      if (!paramPreference.mKey.equals("contact_info_sns")) {
        break label141;
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(getIntent())), Integer.valueOf(3), Integer.valueOf(1), this.contact.field_username });
    }
    for (;;)
    {
      if ((paramPreference instanceof NormalProfileHeaderPreference)) {
        eEi();
      }
      AppMethodBeat.o(26998);
      return false;
      label141:
      if (paramPreference.mKey.equals("contact_info_more")) {
        com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(getIntent())), Integer.valueOf(6), Integer.valueOf(1), this.contact.field_username });
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(27002);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.ContactInfoUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(27002);
      return;
    }
    Log.i("MicroMsg.ContactInfoUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(27002);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        paramArrayOfString = (NormalUserFooterPreference)this.screen.bmg("contact_info_footer_normal");
        if (paramArrayOfString != null) {
          paramArrayOfString.eEL();
        }
        AppMethodBeat.o(27002);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131763864;; paramInt = 2131763876)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this, getString(paramInt), getString(2131763890), getString(2131762043), getString(2131756929), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(26975);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = ContactInfoUI.this;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/profile/ui/ContactInfoUI$7", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/profile/ui/ContactInfoUI$7", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(26975);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(26976);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(26976);
            }
          });
        }
        AppMethodBeat.o(27002);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        paramArrayOfString = (NormalUserFooterPreference)this.screen.bmg("contact_info_footer_normal");
        if (paramArrayOfString != null) {
          paramArrayOfString.eEK();
        }
        AppMethodBeat.o(27002);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131763876), getString(2131763890), getString(2131762043), getString(2131756929), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(231845);
          paramAnonymousDialogInterface = ContactInfoUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/profile/ui/ContactInfoUI$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/profile/ui/ContactInfoUI$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(231845);
        }
      }, null);
    }
  }
  
  protected void onRestart()
  {
    AppMethodBeat.i(26992);
    super.onRestart();
    this.BdT = false;
    AppMethodBeat.o(26992);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26990);
    com.tencent.mm.modelstat.d.d(3, "ContactInfoUI" + getIdentString(), hashCode());
    ag.bah().add(this);
    super.onResume();
    View localView = ((ViewGroup)getContentView()).getFocusedChild();
    if (localView != null)
    {
      localView.clearFocus();
      Log.i("MicroMsg.ContactInfoUI", "try to clear focus. id:%s", new Object[] { Integer.valueOf(localView.getId()) });
    }
    this.BdD = ((PullDownListView)getListView());
    if (this.BdF != null) {
      this.BdF.onResume();
    }
    if (this.screen != null)
    {
      this.Bdw = ((NormalProfileHeaderPreference)this.screen.bmg("contact_profile_header_normal"));
      if (this.Bdw != null) {
        this.Bdw.b(this.BdH, this.BdR.getHeight(), this.BdI);
      }
    }
    if (((this.Bdv instanceof c)) || ((this.Bdv instanceof ContactWidgetTabBizInfo))) {
      this.Bdv.a(this.screen, this.contact, this.Bdx, this.kgm);
    }
    com.tencent.mm.pluginsdk.ui.span.l.a(this.ptq);
    if (this.BdM != null) {
      this.BdM.fvw();
    }
    AppMethodBeat.o(26990);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(27004);
    Log.d("MicroMsg.ContactInfoUI", "onSceneEnd errType[%s] errCode[%s] errMsg[%s] sceneType[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.getType()) });
    if ((273 == paramq.getType()) && (this.contact != null) && ((this.Bdv instanceof com.tencent.mm.plugin.profile.a)) && (Util.isEqual(this.contact.field_username, ((com.tencent.mm.plugin.story.f.a.i)paramq).userName)))
    {
      int i = ((com.tencent.mm.plugin.story.f.a.i)paramq).source;
      paramString = com.tencent.mm.plugin.story.i.a.FvD;
      if (i == com.tencent.mm.plugin.story.i.a.frj())
      {
        i = 1;
        if (i != 0) {
          if (((paramInt1 != 0) && (paramInt1 != 4)) || (paramInt2 == 315)) {
            break label177;
          }
        }
      }
      label177:
      for (boolean bool = true;; bool = false)
      {
        this.BdK = bool;
        this.BdL = ((com.tencent.mm.plugin.story.f.a.i)paramq).wHW;
        AppMethodBeat.o(27004);
        return;
        i = 0;
        break;
      }
    }
    if ((291 == paramq.getType()) && (this.contact != null)) {
      new MMHandler().post(new a(this, this.contact.field_username));
    }
    AppMethodBeat.o(27004);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(26991);
    super.onStart();
    if (this.BdF != null) {
      this.BdF.onStart();
    }
    AppMethodBeat.o(26991);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(26994);
    super.onStop();
    if (this.BdF != null) {
      this.BdF.onStop();
    }
    AppMethodBeat.o(26994);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    implements Runnable
  {
    private WeakReference<ContactInfoUI> cMO;
    private String goe;
    
    a(ContactInfoUI paramContactInfoUI, String paramString)
    {
      AppMethodBeat.i(26978);
      this.cMO = new WeakReference(paramContactInfoUI);
      this.goe = paramString;
      AppMethodBeat.o(26978);
    }
    
    public final void run()
    {
      AppMethodBeat.i(26979);
      ContactInfoUI localContactInfoUI = (ContactInfoUI)this.cMO.get();
      Log.i("MicroMsg.ContactInfoUI", "onNotifyChange contact %s", new Object[] { this.goe });
      if ((localContactInfoUI == null) || (localContactInfoUI.isFinishing()) || (localContactInfoUI.isDestroyed()))
      {
        AppMethodBeat.o(26979);
        return;
      }
      Log.i("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", new Object[] { Boolean.valueOf(ContactInfoUI.m(localContactInfoUI)), ContactInfoUI.g(localContactInfoUI).field_username, this.goe });
      if ((ContactInfoUI.g(localContactInfoUI) != null) && (!Util.isNullOrNil(ContactInfoUI.g(localContactInfoUI).field_username)) && ((ContactInfoUI.g(localContactInfoUI).field_username.equals(this.goe)) || (ContactInfoUI.g(localContactInfoUI).field_username.equals(as.bjz(this.goe)))))
      {
        ContactInfoUI.a(localContactInfoUI, ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.goe));
        if (ContactInfoUI.n(localContactInfoUI) != null)
        {
          ContactInfoUI.n(localContactInfoUI).cCs();
          ContactInfoUI.f(localContactInfoUI).removeAll();
        }
        localContactInfoUI.initView();
      }
      AppMethodBeat.o(26979);
    }
  }
  
  static final class b
    implements Runnable
  {
    private bq BdX;
    private WeakReference<ContactInfoUI> cMO;
    
    b(ContactInfoUI paramContactInfoUI, bq parambq)
    {
      AppMethodBeat.i(231846);
      this.cMO = new WeakReference(paramContactInfoUI);
      this.BdX = parambq;
      AppMethodBeat.o(231846);
    }
    
    public final void run()
    {
      AppMethodBeat.i(231847);
      ContactInfoUI localContactInfoUI = (ContactInfoUI)this.cMO.get();
      Log.i("MicroMsg.ContactInfoUI", "onNotifyFriendUserChange user: %s", new Object[] { this.BdX });
      if ((localContactInfoUI == null) || (localContactInfoUI.isFinishing()) || (localContactInfoUI.isDestroyed()))
      {
        AppMethodBeat.o(231847);
        return;
      }
      String str2 = ContactInfoUI.g(localContactInfoUI).field_username;
      if (this.BdX != null) {}
      for (String str1 = this.BdX.field_encryptUsername;; str1 = "")
      {
        Log.i("MicroMsg.ContactInfoUI", "onNotifyFriendUserChange contact.user:%s, notify.user:%s, friendUser:%s", new Object[] { str2, str1, this.BdX.field_username });
        if ((ContactInfoUI.g(localContactInfoUI) != null) && (this.BdX != null) && (!Util.isNullOrNil(ContactInfoUI.g(localContactInfoUI).field_username)) && (ContactInfoUI.g(localContactInfoUI).field_username.equals(this.BdX.field_encryptUsername)) && (!ab.JF(ContactInfoUI.g(localContactInfoUI).field_username)))
        {
          str1 = this.BdX.field_username;
          if ((!Util.isNullOrNil(str1)) && (!str1.equals(ContactInfoUI.g(localContactInfoUI).field_username))) {
            com.tencent.mm.plugin.report.service.h.CyF.dN(1430, 4);
          }
          if (!Util.isNullOrNil(str1)) {
            ContactInfoUI.a(localContactInfoUI, ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str1));
          }
          localContactInfoUI.getIntent().putExtra("Contact_User", ContactInfoUI.g(localContactInfoUI).field_username);
          Log.i("MicroMsg.ContactInfoUI", "new contact user:%s", new Object[] { ContactInfoUI.g(localContactInfoUI).field_username });
          if (ContactInfoUI.n(localContactInfoUI) != null)
          {
            ContactInfoUI.n(localContactInfoUI).cCs();
            ContactInfoUI.f(localContactInfoUI).removeAll();
          }
          localContactInfoUI.initView();
        }
        AppMethodBeat.o(231847);
        return;
      }
    }
  }
  
  static final class c
    implements Runnable
  {
    private cn BdY;
    private WeakReference<ContactInfoUI> cMO;
    
    c(ContactInfoUI paramContactInfoUI, cn paramcn)
    {
      AppMethodBeat.i(26980);
      this.cMO = new WeakReference(paramContactInfoUI);
      this.BdY = paramcn;
      AppMethodBeat.o(26980);
    }
    
    public final void run()
    {
      AppMethodBeat.i(26981);
      ContactInfoUI localContactInfoUI = (ContactInfoUI)this.cMO.get();
      Log.i("MicroMsg.ContactInfoUI", "onNotifyChange stranger %s", new Object[] { this.BdY });
      if ((localContactInfoUI == null) || (localContactInfoUI.isFinishing()) || (localContactInfoUI.isDestroyed()))
      {
        AppMethodBeat.o(26981);
        return;
      }
      Log.i("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", new Object[] { Boolean.valueOf(ContactInfoUI.m(localContactInfoUI)), ContactInfoUI.g(localContactInfoUI).field_username, this.BdY });
      if ((ContactInfoUI.g(localContactInfoUI) != null) && (this.BdY != null) && (!Util.isNullOrNil(ContactInfoUI.g(localContactInfoUI).field_username)) && (ContactInfoUI.g(localContactInfoUI).field_username.equals(this.BdY.field_encryptUsername)) && (!ab.JF(ContactInfoUI.g(localContactInfoUI).field_username)))
      {
        ContactInfoUI.g(localContactInfoUI).BD(this.BdY.field_conRemark);
        localContactInfoUI.getIntent().putExtra("Contact_User", ContactInfoUI.g(localContactInfoUI).field_username);
        if (ContactInfoUI.n(localContactInfoUI) != null)
        {
          ContactInfoUI.n(localContactInfoUI).cCs();
          ContactInfoUI.f(localContactInfoUI).removeAll();
        }
        localContactInfoUI.initView();
      }
      AppMethodBeat.o(26981);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI
 * JD-Core Version:    0.7.0.1
 */