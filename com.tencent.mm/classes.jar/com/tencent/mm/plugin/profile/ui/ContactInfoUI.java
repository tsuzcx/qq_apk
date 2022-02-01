package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.d;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ao.af;
import com.tencent.mm.api.c.b;
import com.tencent.mm.f.b.a.qe;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.a;
import com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizInfo;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
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
import com.tencent.mm.storage.co;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.f.d;
import com.tencent.mm.ui.statusbar.c.a;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback;
import com.tencent.mm.ui.widget.listview.PullDownListView.a;
import java.io.IOException;
import java.lang.ref.WeakReference;

@com.tencent.mm.kernel.k
public class ContactInfoUI
  extends MMPreference
  implements com.tencent.mm.an.i, f.a, com.tencent.mm.plugin.messenger.foundation.a.a.n.a, com.tencent.mm.plugin.story.api.g, com.tencent.mm.plugin.textstatus.a.g, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange
{
  private String BLy;
  private View Cwk;
  private c.a Cwl;
  String GXA;
  private String GXB;
  private PullDownListView GXC;
  private boolean GXD;
  private AbsStoryMuteView GXE;
  private boolean GXF;
  private boolean GXG;
  private boolean GXH;
  private boolean GXI;
  private int GXJ;
  private com.tencent.mm.plugin.textstatus.a.b GXK;
  private View.OnClickListener GXL;
  private PullDownListView.IPullDownCallback GXM;
  private PullDownListView.IPullDownCallback GXN;
  private View GXO;
  private boolean GXP;
  private ContactWidgetTabBizInfo GXQ;
  private com.tencent.mm.pluginsdk.c.a GXu;
  private NormalProfileHeaderPreference GXv;
  private boolean GXw;
  private boolean GXx;
  private byte[] GXy;
  private boolean GXz;
  private as contact;
  private boolean lft;
  private int mXL;
  private String roomId;
  private com.tencent.mm.pluginsdk.ui.span.i sCG;
  private com.tencent.mm.ui.base.preference.f screen;
  private AbsStoryGallery storyGallery;
  private long zUF;
  
  public ContactInfoUI()
  {
    AppMethodBeat.i(26982);
    this.GXz = false;
    this.GXA = null;
    this.GXB = "";
    this.roomId = "";
    this.GXC = null;
    this.GXD = false;
    this.storyGallery = null;
    this.GXE = null;
    this.GXF = false;
    this.GXG = false;
    this.GXH = false;
    this.GXI = false;
    this.lft = false;
    this.GXJ = 0;
    this.zUF = 0L;
    this.GXK = null;
    this.GXL = null;
    this.GXM = new PullDownListView.IPullDownCallback()
    {
      public final void abo(int paramAnonymousInt)
      {
        AppMethodBeat.i(26966);
        if (ContactInfoUI.a(ContactInfoUI.this) != null) {
          ContactInfoUI.a(ContactInfoUI.this).ahW(paramAnonymousInt);
        }
        AppMethodBeat.o(26966);
      }
      
      public final void abp(int paramAnonymousInt)
      {
        AppMethodBeat.i(26967);
        if (ContactInfoUI.a(ContactInfoUI.this) != null) {
          ContactInfoUI.a(ContactInfoUI.this).ahX(paramAnonymousInt);
        }
        AppMethodBeat.o(26967);
      }
      
      public final void abq(int paramAnonymousInt) {}
      
      public final void dDB()
      {
        AppMethodBeat.i(26962);
        if (ContactInfoUI.a(ContactInfoUI.this) != null) {
          ContactInfoUI.a(ContactInfoUI.this).gbh();
        }
        AppMethodBeat.o(26962);
      }
      
      public final void dDC()
      {
        AppMethodBeat.i(26963);
        if (ContactInfoUI.a(ContactInfoUI.this) != null) {
          ContactInfoUI.a(ContactInfoUI.this).gbi();
        }
        AppMethodBeat.o(26963);
      }
      
      public final void fqe()
      {
        AppMethodBeat.i(26964);
        Log.i("MicroMsg.ContactInfoUI", "story_cat onMuteIn");
        ContactInfoUI.d(ContactInfoUI.this).gbo();
        AppMethodBeat.o(26964);
      }
      
      public final void fqf()
      {
        AppMethodBeat.i(26965);
        ContactInfoUI.d(ContactInfoUI.this).gbp();
        AppMethodBeat.o(26965);
      }
      
      public final void onPostClose()
      {
        AppMethodBeat.i(26961);
        if (ContactInfoUI.a(ContactInfoUI.this) != null)
        {
          Log.i("MicroMsg.ContactInfoUI", "story_cat onPostClose");
          ContactInfoUI.a(ContactInfoUI.this).zm(true);
          ContactInfoUI.this.showTitleView();
          ContactInfoUI.c(ContactInfoUI.this);
        }
        AppMethodBeat.o(26961);
      }
      
      public final void onPostOpen(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26960);
        if (ContactInfoUI.a(ContactInfoUI.this) != null)
        {
          Log.i("MicroMsg.ContactInfoUI", "story_cat onPostOpen");
          ContactInfoUI.a(ContactInfoUI.this).aD(paramAnonymousBoolean, true);
          ContactInfoUI.this.hideTitleView();
          ContactInfoUI.b(ContactInfoUI.this);
        }
        AppMethodBeat.o(26960);
      }
    };
    this.GXN = new PullDownListView.IPullDownCallback()
    {
      public final void abo(int paramAnonymousInt) {}
      
      public final void abp(int paramAnonymousInt) {}
      
      public final void abq(int paramAnonymousInt) {}
      
      public final void dDB()
      {
        AppMethodBeat.i(282381);
        if (ContactInfoUI.e(ContactInfoUI.this) != null)
        {
          ContactInfoUI.e(ContactInfoUI.this).dDB();
          if (ContactInfoUI.g(ContactInfoUI.this) != null)
          {
            Object localObject = (NormalProfileHeaderPreference)ContactInfoUI.g(ContactInfoUI.this).byG("contact_profile_header_normal");
            if (localObject != null)
            {
              localObject = ((NormalProfileHeaderPreference)localObject).fpU();
              if (localObject != null) {
                ((com.tencent.mm.plugin.textstatus.a.e)localObject).dDB();
              }
            }
          }
        }
        AppMethodBeat.o(282381);
      }
      
      public final void dDC()
      {
        AppMethodBeat.i(282383);
        if (ContactInfoUI.e(ContactInfoUI.this) != null)
        {
          ContactInfoUI.e(ContactInfoUI.this).dDC();
          if (ContactInfoUI.g(ContactInfoUI.this) != null)
          {
            Object localObject = (NormalProfileHeaderPreference)ContactInfoUI.g(ContactInfoUI.this).byG("contact_profile_header_normal");
            if (localObject != null)
            {
              localObject = ((NormalProfileHeaderPreference)localObject).fpU();
              if (localObject != null) {
                ((com.tencent.mm.plugin.textstatus.a.e)localObject).dDC();
              }
            }
          }
        }
        AppMethodBeat.o(282383);
      }
      
      public final void fqe()
      {
        AppMethodBeat.i(282384);
        Log.i("MicroMsg.ContactInfoUI", "story_cat onMuteIn");
        if (ContactInfoUI.d(ContactInfoUI.this) != null) {
          ContactInfoUI.d(ContactInfoUI.this).gbo();
        }
        AppMethodBeat.o(282384);
      }
      
      public final void fqf()
      {
        AppMethodBeat.i(282385);
        if (ContactInfoUI.d(ContactInfoUI.this) != null) {
          ContactInfoUI.d(ContactInfoUI.this).gbp();
        }
        AppMethodBeat.o(282385);
      }
      
      public final void onPostClose()
      {
        AppMethodBeat.i(282378);
        if (ContactInfoUI.e(ContactInfoUI.this) != null) {
          ContactInfoUI.e(ContactInfoUI.this).onPostClose();
        }
        if (ContactInfoUI.g(ContactInfoUI.this) != null)
        {
          Object localObject = (NormalProfileHeaderPreference)ContactInfoUI.g(ContactInfoUI.this).byG("contact_profile_header_normal");
          if (localObject != null)
          {
            localObject = ((NormalProfileHeaderPreference)localObject).fpU();
            if (localObject != null) {
              ((com.tencent.mm.plugin.textstatus.a.e)localObject).onPostClose();
            }
          }
        }
        ContactInfoUI.this.showTitleView();
        AppMethodBeat.o(282378);
      }
      
      public final void onPostOpen(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(282377);
        if (ContactInfoUI.e(ContactInfoUI.this) != null) {
          ContactInfoUI.e(ContactInfoUI.this).onPostOpen(paramAnonymousBoolean);
        }
        com.tencent.mm.plugin.textstatus.a.e locale = ContactInfoUI.f(ContactInfoUI.this);
        if (locale != null) {
          locale.onPostOpen(paramAnonymousBoolean);
        }
        ContactInfoUI.this.hideTitleView();
        AppMethodBeat.o(282377);
      }
    };
    this.sCG = new com.tencent.mm.pluginsdk.ui.span.i()
    {
      public final Object a(u paramAnonymousu)
      {
        AppMethodBeat.i(282654);
        switch (paramAnonymousu.type)
        {
        default: 
          AppMethodBeat.o(282654);
          return null;
        }
        if (ContactInfoUI.h(ContactInfoUI.this) != null)
        {
          paramAnonymousu = ContactInfoUI.h(ContactInfoUI.this).field_username;
          AppMethodBeat.o(282654);
          return paramAnonymousu;
        }
        AppMethodBeat.o(282654);
        return null;
      }
      
      public final Object b(u paramAnonymousu)
      {
        AppMethodBeat.i(282656);
        if (paramAnonymousu.type == 45)
        {
          String str = new String(Base64.decode(paramAnonymousu.url, 0));
          paramAnonymousu = new String(Base64.decode(Util.nullAs((String)paramAnonymousu.bv(String.class), ""), 0));
          Log.d("MicroMsg.ContactInfoUI", "appId:%s,path:%s", new Object[] { str, paramAnonymousu });
          AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
          localAppBrandStatObject.scene = 1082;
          if (ContactInfoUI.h(ContactInfoUI.this) != null) {
            localAppBrandStatObject.fvd = (ContactInfoUI.h(ContactInfoUI.this).field_username + "|2");
          }
          ((r)com.tencent.mm.kernel.h.ae(r.class)).a(ContactInfoUI.this.getContext(), null, str, 0, 0, paramAnonymousu, localAppBrandStatObject);
        }
        AppMethodBeat.o(282656);
        return null;
      }
    };
    this.GXP = false;
    this.GXQ = null;
    AppMethodBeat.o(26982);
  }
  
  private com.tencent.mm.plugin.textstatus.a.e fpU()
  {
    AppMethodBeat.i(272835);
    if (this.screen != null)
    {
      Object localObject = (NormalProfileHeaderPreference)this.screen.byG("contact_profile_header_normal");
      if (localObject != null)
      {
        localObject = ((NormalProfileHeaderPreference)localObject).fpU();
        AppMethodBeat.o(272835);
        return localObject;
      }
    }
    AppMethodBeat.o(272835);
    return null;
  }
  
  private void fqa()
  {
    AppMethodBeat.i(26987);
    if ((this.Cwk == null) || (!com.tencent.mm.ui.statusbar.c.XMC))
    {
      AppMethodBeat.o(26987);
      return;
    }
    com.tencent.mm.ui.statusbar.c localc = com.tencent.mm.ui.statusbar.c.bA(this);
    localc.b(this.Cwl);
    c.a local9 = new c.a()
    {
      public final void BF(int paramAnonymousInt)
      {
        AppMethodBeat.i(272953);
        if ((ContactInfoUI.i(ContactInfoUI.this)) || (ContactInfoUI.j(ContactInfoUI.this))) {
          ContactInfoUI.k(ContactInfoUI.this).setPadding(0, paramAnonymousInt, 0, 0);
        }
        AppMethodBeat.o(272953);
      }
    };
    this.Cwl = local9;
    localc.a(local9);
    getWindow().getDecorView().requestApplyInsets();
    com.tencent.mm.ui.statusbar.d.e(getWindow());
    AppMethodBeat.o(26987);
  }
  
  private void fqb()
  {
    AppMethodBeat.i(27003);
    if (com.tencent.mm.compatible.util.d.qV(19))
    {
      getWindow().clearFlags(201327616);
      AppMethodBeat.o(27003);
      return;
    }
    getWindow().clearFlags(1024);
    AppMethodBeat.o(27003);
  }
  
  private void fqc()
  {
    AppMethodBeat.i(27006);
    if (this.lft)
    {
      w.makeText(MMApplicationContext.getContext(), getResources().getString(R.l.eTH), 0).show();
      AppMethodBeat.o(27006);
      return;
    }
    if ((this.GXF) && (this.GXC != null)) {
      this.GXC.idh();
    }
    AppMethodBeat.o(27006);
  }
  
  private void fqd()
  {
    boolean bool2 = true;
    AppMethodBeat.i(27007);
    Log.i("MicroMsg.ContactInfoUI", "updateUIByStory: %s %s %s %s", new Object[] { Boolean.valueOf(this.GXD), Boolean.valueOf(this.GXF), Boolean.valueOf(this.GXH), Boolean.valueOf(this.GXG) });
    label180:
    NormalProfileHeaderPreference localNormalProfileHeaderPreference;
    boolean bool1;
    label224:
    int i;
    if ((this.GXF) && (!this.lft))
    {
      fqa();
      setActionbarColor(getContext().getResources().getColor(R.e.transparent));
      setMMTitle("");
      if (this.GXC != null)
      {
        this.GXC.setBackground(aw.bf(getContext(), R.d.me_alpha_bg));
        this.GXC.setSupportOverscroll(true);
      }
      if (this.GXO != null) {
        this.GXO.setOnClickListener(new ContactInfoUI.5(this));
      }
      if (this.GXC != null)
      {
        if (!this.GXG) {
          break label497;
        }
        this.GXC.setSelector(R.e.BG_0);
      }
      if (this.screen != null)
      {
        localNormalProfileHeaderPreference = (NormalProfileHeaderPreference)this.screen.byG("contact_profile_header_normal");
        if (localNormalProfileHeaderPreference != null)
        {
          if ((!this.GXF) || (this.lft)) {
            break label510;
          }
          bool1 = true;
          i = this.GXO.getHeight();
          if ((!this.GXG) || (this.lft)) {
            break label515;
          }
        }
      }
    }
    for (;;)
    {
      localNormalProfileHeaderPreference.b(bool1, i, bool2);
      AppMethodBeat.o(27007);
      return;
      if ((this.GXG) && (!this.lft))
      {
        fqa();
        setActionbarColor(getContext().getResources().getColor(R.e.transparent));
        setMMTitle("");
        if (this.GXC != null)
        {
          this.GXC.setBackground(null);
          if ((this.GXK == null) || (!this.GXK.gkG())) {
            break label399;
          }
        }
        label399:
        for (bool1 = true;; bool1 = false)
        {
          this.GXC.setSupportOverscroll(bool1);
          this.GXC.ayC(com.tencent.mm.plugin.textstatus.a.a.is(this));
          if (this.GXO != null) {
            this.GXO.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(292352);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/ContactInfoUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                Log.i("MicroMsg.ContactInfoUI", "onClick: actionBarClick action_bar_root2");
                if (TextUtils.equals(ContactInfoUI.this.getIntent().getStringExtra("Contact_User"), com.tencent.mm.plugin.auth.a.a.crN())) {
                  ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).goUnReadMsgPage(ContactInfoUI.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactInfoUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(292352);
              }
            });
          }
          if (getBounceView() == null) {
            break;
          }
          getBounceView().setBounceEnabled(false);
          break;
        }
      }
      setActionbarColor(getContext().getResources().getColor(R.e.BG_2));
      setMMTitle("");
      if (this.GXC != null)
      {
        this.GXC.setBackground(aw.bf(getContext(), R.d.me_normal_bg));
        this.GXC.setSupportOverscroll(false);
      }
      if (this.Cwk != null) {
        this.Cwk.setPadding(0, 0, 0, 0);
      }
      if (getBounceView() == null) {
        break;
      }
      getBounceView().setBounceEnabled(true);
      break;
      label497:
      this.GXC.setSelector(R.e.transparent);
      break label180;
      label510:
      bool1 = false;
      break label224;
      label515:
      bool2 = false;
    }
  }
  
  public final void a(bq parambq)
  {
    AppMethodBeat.i(272849);
    MMHandlerThread.postToMainThread(new b(this, parambq));
    AppMethodBeat.o(272849);
  }
  
  public final void a(co paramco)
  {
    AppMethodBeat.i(27001);
    MMHandlerThread.postToMainThread(new c(this, paramco));
    AppMethodBeat.o(27001);
  }
  
  public void finish()
  {
    AppMethodBeat.i(27008);
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.LOJ;
    com.tencent.mm.plugin.story.h.h.geE().gQR = 0L;
    super.finish();
    AppMethodBeat.o(27008);
  }
  
  public final void fpV()
  {
    AppMethodBeat.i(26983);
    Log.i("MicroMsg.ContactInfoUI", "story_cat storyUINoStory");
    this.GXF = false;
    if ((this.GXC != null) && (!this.GXC.isVisible))
    {
      showTitleView();
      fqb();
      this.GXC.idf();
    }
    fqd();
    AppMethodBeat.o(26983);
  }
  
  public final void fpW()
  {
    AppMethodBeat.i(26984);
    Log.i("MicroMsg.ContactInfoUI", "story_cat storyUIHasStory");
    this.GXF = true;
    if ((this.GXC != null) && (this.GXC.isVisible)) {
      fqd();
    }
    AppMethodBeat.o(26984);
  }
  
  public final void fpX()
  {
    AppMethodBeat.i(26985);
    Log.i("MicroMsg.ContactInfoUI", "story_cat storyUIBackPressed");
    this.GXC.idf();
    AppMethodBeat.o(26985);
  }
  
  public final void fpY()
  {
    AppMethodBeat.i(272836);
    Log.i("MicroMsg.ContactInfoUI", "statusUINoStatus");
    this.GXG = false;
    if ((this.GXC != null) && (!this.GXC.isVisible))
    {
      showTitleView();
      fqb();
      this.GXC.idf();
    }
    fqd();
    AppMethodBeat.o(272836);
  }
  
  public final void fpZ()
  {
    AppMethodBeat.i(272838);
    Log.i("MicroMsg.ContactInfoUI", "statusUIHasStatus");
    this.GXG = true;
    if ((this.GXC != null) && (this.GXC.isVisible)) {
      fqd();
    }
    AppMethodBeat.o(272838);
  }
  
  public String getIdentString()
  {
    AppMethodBeat.i(26995);
    if ((this.contact == null) || ((int)this.contact.jxt == 0) || (Util.isNullOrNil(this.contact.field_username)))
    {
      AppMethodBeat.o(26995);
      return "";
    }
    Log.i("MicroMsg.ContactInfoUI", "getIdentityString %s", new Object[] { this.contact.field_username });
    if (com.tencent.mm.ao.g.KI(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_EnterpriseChat";
    }
    if (com.tencent.mm.ao.g.UC(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_EnterpriseFatherBiz";
    }
    if (com.tencent.mm.ao.g.UB(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_EnterpriseChildBiz";
    }
    if (this.contact.hxX())
    {
      AppMethodBeat.o(26995);
      return "_bizContact";
    }
    if (ab.Lj(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_chatroom";
    }
    if (ab.PY(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_bottle";
    }
    if (ab.PZ(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_QQ";
    }
    if (ab.QX(this.contact.field_username))
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
    return R.o.eXy;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26996);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.BLy = getIntent().getStringExtra("Verify_ticket");
    this.GXw = getIntent().getBooleanExtra("Chat_Readonly", false);
    this.GXx = getIntent().getBooleanExtra("User_Verify", false);
    this.roomId = getIntent().getStringExtra("Contact_ChatRoomId");
    String str1 = Util.nullAsNil(getIntent().getStringExtra("Contact_User"));
    Object localObject5 = Util.nullAsNil(getIntent().getStringExtra("Contact_Alias"));
    Object localObject1 = Util.nullAsNil(getIntent().getStringExtra("Contact_Encryptusername"));
    if (str1.endsWith("@stranger")) {
      localObject1 = str1;
    }
    bh.beI();
    this.contact = com.tencent.mm.model.c.bbL().RG(str1);
    this.mXL = getIntent().getIntExtra("Contact_Scene", 9);
    if (this.contact != null) {
      this.contact.VEr = str1;
    }
    com.tencent.mm.plugin.profile.b.mIH.a(this.contact);
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
    this.GXB = getIntent().getStringExtra("Contact_BrandIconURL");
    String str9 = getIntent().getStringExtra("Contact_RegionCode");
    this.GXy = getIntent().getByteArrayExtra("Contact_customInfo");
    int i1 = getIntent().getIntExtra("Contact_Ext_Flag", 0);
    boolean bool2 = getIntent().getBooleanExtra("force_get_contact", false);
    Log.i("MicroMsg.ContactInfoUI", "dkverify forceGetContact:%s  user:%s  roomid:%s, addContactScene: %d", new Object[] { Boolean.valueOf(bool2), str1, this.roomId, Integer.valueOf(this.mXL) });
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
      if ((this.contact != null) && (com.tencent.mm.contact.d.rk(this.contact.field_type))) {
        az.a.ltq.aP(str1, this.roomId);
      }
    }
    else
    {
      if (((this.contact == null) || ((int)this.contact.jxt == 0)) && (as.bvK(str1)) && (this.mXL != 15))
      {
        localObject4 = Util.nullAsNil(getIntent().getStringExtra(f.d.VRW));
        localObject2 = localObject4;
        if (Util.isNullOrNil((String)localObject4)) {
          localObject2 = this.BLy;
        }
        com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.openim.b.h(str1, Util.nullAsNil(this.roomId), (String)localObject2), 0);
      }
      if ((this.contact != null) && ((int)this.contact.jxt > 0) && ((!ab.QY(this.contact.field_username)) || ((as.bvJ(this.contact.field_username)) && (!ab.Qk(this.contact.field_username)))))
      {
        if ((!this.contact.hyb()) || (!as.bvK(this.contact.field_username))) {
          break label2031;
        }
        localObject4 = Util.nullAsNil(getIntent().getStringExtra(f.d.VRW));
        localObject2 = localObject4;
        if (Util.isNullOrNil((String)localObject4)) {
          localObject2 = this.BLy;
        }
        localObject8 = com.tencent.mm.kernel.h.aHF().kcd;
        String str10 = this.contact.field_username;
        if (!com.tencent.mm.contact.d.rk(this.contact.field_type)) {
          break label2019;
        }
        localObject4 = "";
        ((com.tencent.mm.an.t)localObject8).a(new com.tencent.mm.openim.b.h(str10, (String)localObject4, (String)localObject2), 0);
      }
      getIntent().getIntExtra("Contact_verify_Scene", 9);
      getIntent().getIntExtra("key_add_contact_match_type", 0);
      localObject2 = getIntent().getStringExtra("key_add_contact_openim_appid");
      k = getIntent().getIntExtra("key_add_contact_custom_detail_visible", 0);
      localObject4 = getIntent().getStringExtra("key_add_contact_custom_detail");
      getIntent().getStringExtra("key_add_contact_desc_wording_id");
      getIntent().getStringExtra("key_add_contact_desc_icon");
      if ((this.contact != null) && ((int)this.contact.jxt != 0) && (Util.nullAsNil(this.contact.field_username).length() > 0)) {
        break label2272;
      }
      this.contact = new as();
      this.contact.setUsername(str1);
      this.contact.Iq((String)localObject5);
      this.contact.setNickname((String)localObject6);
      this.contact.It(getIntent().getStringExtra("Contact_PyInitial"));
      this.contact.Iu(getIntent().getStringExtra("Contact_QuanPin"));
      this.contact.pw(j);
      this.contact.IK(str4);
      this.contact.IL((String)localObject7);
      this.contact.IJ(str5);
      this.contact.ps(m);
      this.contact.IO(str6);
      this.contact.IM(str2);
      this.contact.IN(str7);
      this.contact.pr(n);
      this.contact.Iv(str8);
      this.contact.Ey(l);
      this.contact.IE(str3);
      this.contact.IP(str9);
      this.contact.pE(i1);
      if ((!Util.isNullOrNil(this.GXA)) && (this.mXL == 15))
      {
        bh.beI();
        localObject5 = com.tencent.mm.model.c.bbM().aPj(str1);
        localObject6 = new co(str1);
        ((co)localObject6).field_conRemark = ((co)localObject5).field_conRemark;
        ((co)localObject6).field_conDescription = ((co)localObject5).field_conDescription;
        ((co)localObject6).field_contactLabels = ((co)localObject5).field_contactLabels;
        ((co)localObject6).field_conPhone = this.GXA;
        bh.beI();
        com.tencent.mm.model.c.bbM().replace((IAutoDBItem)localObject6);
        this.GXA = null;
      }
      this.contact.IY((String)localObject4);
      this.contact.pF(k);
      this.contact.IB((String)localObject2);
      if ((as.bvK(this.contact.field_username)) && ((this.mXL == 30) || (this.mXL == 45) || (this.mXL == 17)))
      {
        localObject2 = com.tencent.mm.plugin.report.service.h.IzE;
        localObject4 = this.contact.field_openImAppid;
        if (this.mXL != 17) {
          break label2893;
        }
        i = 2;
        ((com.tencent.mm.plugin.report.service.h)localObject2).a(15320, new Object[] { localObject4, Integer.valueOf(i) });
      }
      if (!Util.isNullOrNil((String)localObject1)) {
        this.contact.Iy((String)localObject1);
      }
      if (this.contact != null) {
        break label2898;
      }
      Log.e("MicroMsg.ContactInfoUI", "contact = null");
      getIntent().putExtra("Contact_User", this.contact.field_username);
      if ((!bool2) && ((int)this.contact.jxt <= 0) && (this.contact.hxX()) && ((this.mXL == 17) || (this.mXL == 41)))
      {
        Log.d("MicroMsg.ContactInfoUI", "come from card, getContact %s", new Object[] { this.contact.field_username });
        az.a.ltq.aP(this.contact.field_username, "");
        com.tencent.mm.am.d.TA(this.contact.field_username);
      }
      if (this.contact.hDq != null) {
        break label3008;
      }
      bool1 = true;
      label1486:
      if (this.contact.hDq != null) {
        break label3014;
      }
      i = 0;
      label1498:
      if (this.contact.hDq != null) {
        break label3028;
      }
    }
    label2061:
    label2893:
    label2898:
    label3028:
    for (localObject1 = "";; localObject1 = Util.secPrint(this.contact.hDq))
    {
      Log.i("MicroMsg.ContactInfoUI", "contact.getRemarkDesc() (%s, %s, %s)", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), localObject1 });
      if ((!bool2) && ((int)this.contact.jxt <= 0) && (this.mXL == 96))
      {
        Log.i("MicroMsg.ContactInfoUI", "come from chatroom accessverify, getContact %s", new Object[] { this.contact.field_username });
        az.a.ltq.h(this.contact.field_username, 1, getIntent().getStringExtra("key_add_contact_verify_ticket"));
        com.tencent.mm.am.d.aH(this.contact.field_username, 3);
      }
      if (this.contact.field_username.equals(z.bcZ()))
      {
        bh.beI();
        l = Util.getLong((String)com.tencent.mm.model.c.aHp().b(65825, null), 0L);
        if (l > 0L)
        {
          this.contact.Ey(l);
          localObject1 = this.contact;
          bh.beI();
          ((as)localObject1).IE((String)com.tencent.mm.model.c.aHp().b(65826, null));
        }
        localObject1 = this.contact;
        bh.beI();
        ((as)localObject1).IS((String)com.tencent.mm.model.c.aHp().b(286721, null));
        localObject1 = this.contact;
        bh.beI();
        ((as)localObject1).IT((String)com.tencent.mm.model.c.aHp().b(286722, null));
        localObject1 = this.contact;
        bh.beI();
        ((as)localObject1).IU((String)com.tencent.mm.model.c.aHp().b(286723, null));
      }
      if ((this.contact.field_username != null) && (this.contact.field_username.equals(as.bvW(z.bcZ()))))
      {
        localObject1 = ca.bfn();
        localObject2 = Util.nullAsNil(((ca)localObject1).getProvince());
        localObject4 = Util.nullAsNil(((ca)localObject1).getCity());
        if (!Util.isNullOrNil((String)localObject2)) {
          this.contact.IK((String)localObject2);
        }
        if (!Util.isNullOrNil((String)localObject4)) {
          this.contact.IL((String)localObject4);
        }
        if (!Util.isNullOrNil(((ca)localObject1).countryCode)) {
          this.contact.IP(RegionCodeDecoder.bl(((ca)localObject1).countryCode, ((ca)localObject1).provinceCode, ((ca)localObject1).cityCode));
        }
        i = Util.nullAs(Integer.valueOf(((ca)localObject1).sex), 0);
        localObject1 = Util.nullAsNil(((ca)localObject1).signature);
        this.contact.pw(i);
        this.contact.IJ((String)localObject1);
      }
      if (!Util.isNullOrNil(this.contact.field_username)) {
        break label3043;
      }
      Log.e("MicroMsg.ContactInfoUI", "username is null %s", new Object[] { str1 });
      finish();
      AppMethodBeat.o(26996);
      return;
      az.a.ltq.aP(str1, "");
      break;
      label2019:
      localObject4 = Util.nullAsNil(this.roomId);
      break label772;
      label2031:
      localObject2 = com.tencent.mm.ao.g.gu(this.contact.field_username);
      if ((this.contact.hxX()) && (com.tencent.mm.ao.a.biP()))
      {
        i = 1;
        if ((localObject2 != null) && ((!((com.tencent.mm.api.c)localObject2).YR()) || (i != 0))) {
          break label2168;
        }
        Log.d("MicroMsg.ContactInfoUI", "update contact, verifyFlag %d.", new Object[] { Integer.valueOf(m) });
        localObject4 = az.a.ltq;
        localObject8 = this.contact.field_username;
        if (!com.tencent.mm.contact.d.rk(this.contact.field_type)) {
          break label2159;
        }
      }
      label2159:
      for (localObject2 = "";; localObject2 = this.roomId)
      {
        ((az.b)localObject4).aP((String)localObject8, (String)localObject2);
        com.tencent.mm.am.d.TA(this.contact.field_username);
        break;
        i = 0;
        break label2061;
      }
      label2168:
      if ((!this.contact.hyb()) || (i != 0)) {
        break label792;
      }
      Log.d("MicroMsg.ContactInfoUI", "update contact, last check time=%d", new Object[] { Integer.valueOf(this.contact.hDo) });
      localObject4 = az.a.ltq;
      localObject8 = this.contact.field_username;
      if (com.tencent.mm.contact.d.rk(this.contact.field_type)) {}
      for (localObject2 = "";; localObject2 = this.roomId)
      {
        ((az.b)localObject4).aP((String)localObject8, (String)localObject2);
        com.tencent.mm.am.d.TA(this.contact.field_username);
        break;
      }
      label2272:
      if (this.contact.sex == 0) {
        this.contact.pw(j);
      }
      if ((str4 != null) && (!str4.equals(""))) {
        this.contact.IK(str4);
      }
      if ((localObject7 != null) && (!((String)localObject7).equals(""))) {
        this.contact.IL((String)localObject7);
      }
      if ((str9 != null) && (!str9.equals(""))) {
        this.contact.IP(str9);
      }
      if ((Util.isNullOrNil(this.contact.signature)) && (str5 != null) && (!str5.equals(""))) {
        this.contact.IJ(str5);
      }
      if (m != 0) {
        this.contact.ps(m);
      }
      if ((Util.isNullOrNil(this.contact.verifyInfo)) && (str6 != null) && (!str6.equals(""))) {
        this.contact.IO(str6);
      }
      if ((Util.isNullOrNil(this.contact.field_nickname)) && (localObject6 != null) && (!((String)localObject6).equals(""))) {
        this.contact.setNickname((String)localObject6);
      }
      Log.i("MicroMsg.ContactInfoUI", "searchMobilePhone:%s", new Object[] { Util.nullAsNil(this.GXA) });
      if ((!Util.isNullOrNil(this.GXA)) && (this.mXL == 15))
      {
        j = 1;
        str4 = this.contact.hDw;
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
          if (localObject7[j].equals(this.GXA)) {
            i = 0;
          }
        }
        else
        {
          if (i != 0)
          {
            this.contact.IW(str4 + this.GXA + com.tencent.mm.contact.a.d(this.contact));
            this.GXA = null;
          }
          Log.i("MicroMsg.ContactInfoUI", "contact PhoneList:%s", new Object[] { Util.nullAsNil(this.contact.hDw) });
          this.contact.setSource(15);
          this.contact.IM(str2);
          this.contact.Ey(l);
          this.contact.IE(str3);
          if (!com.tencent.mm.contact.d.rk(this.contact.field_type))
          {
            if (!Util.isNullOrNil((String)localObject5)) {
              this.contact.Iq((String)localObject5);
            }
            if (!Util.isNullOrNil((String)localObject6)) {
              this.contact.setNickname((String)localObject6);
            }
            localObject5 = getIntent().getStringExtra("Contact_PyInitial");
            if (!Util.isNullOrNil((String)localObject5)) {
              this.contact.It((String)localObject5);
            }
            localObject5 = getIntent().getStringExtra("Contact_QuanPin");
            if (!Util.isNullOrNil((String)localObject5)) {
              this.contact.Iu((String)localObject5);
            }
          }
          if ((!com.tencent.mm.contact.d.rk(this.contact.field_type)) && (!Util.isNullOrNil((String)localObject4))) {
            this.contact.IY((String)localObject4);
          }
          if ((!com.tencent.mm.contact.d.rk(this.contact.field_type)) && (k != 0)) {
            this.contact.pF(k);
          }
          if (Util.isNullOrNil((String)localObject2)) {
            break;
          }
          this.contact.IB((String)localObject2);
          break;
        }
        j += 1;
      }
      i = 1;
      break label1304;
      if (!Util.isNullOrNil((String)localObject1))
      {
        bh.beI();
        localObject1 = com.tencent.mm.model.c.bbM().aPj((String)localObject1);
        if ((localObject1 != null) && (!Util.isNullOrNil(((co)localObject1).field_encryptUsername)))
        {
          this.contact.Ir(((co)localObject1).field_conRemark);
          break label1361;
        }
      }
      if (Util.isNullOrNil(str1)) {
        break label1361;
      }
      bh.beI();
      localObject1 = com.tencent.mm.model.c.bbM().aPj(str1);
      if ((localObject1 == null) || (Util.isNullOrNil(((co)localObject1).field_encryptUsername))) {
        break label1361;
      }
      this.contact.Ir(((co)localObject1).field_conRemark);
      break label1361;
      bool1 = false;
      break label1486;
      i = this.contact.hDq.length();
      break label1498;
    }
    label3008:
    label3014:
    label3043:
    setMMTitle("");
    Object localObject4 = this.GXB;
    if (ab.Qc(this.contact.field_username))
    {
      this.GXu = ((com.tencent.mm.plugin.wxpaysdk.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.wxpaysdk.api.c.class)).iO(this);
      localObject1 = new qe();
      ((qe)localObject1).hal = 2L;
      ((qe)localObject1).bpa();
      if (this.GXu != null)
      {
        this.GXu.a(this.screen, this.contact, this.GXw, this.mXL);
        localObject2 = com.tencent.mm.plugin.account.b.getAddrUploadStg().aax(this.contact.field_username);
        localObject1 = "";
        if (localObject2 != null) {
          localObject1 = Util.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).bxY()).replace(" ", "");
        }
        if ((!this.GXP) && (com.tencent.mm.contact.d.rk(this.contact.field_type)) && ((this.GXu instanceof l)))
        {
          j = com.tencent.mm.contact.a.f(this.contact);
          if (!Util.isNullOrNil((String)localObject1)) {
            break label5455;
          }
          i = 0;
          label3233:
          j = i + j;
          localObject2 = com.tencent.mm.plugin.report.service.h.IzE;
          localObject4 = this.contact.field_username;
          if (!Util.isNullOrNil((String)localObject1)) {
            break label5460;
          }
          i = 0;
          label3261:
          if (j < 5) {
            break label5465;
          }
          j = 5;
        }
      }
    }
    label4419:
    label5455:
    label5460:
    label5465:
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject2).a(12040, new Object[] { localObject4, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(j) });
      this.GXP = true;
      if ((!(this.GXu instanceof l)) && (!(this.GXu instanceof c)) && (!(this.GXu instanceof ContactWidgetTabBizInfo)))
      {
        bh.beI();
        localObject1 = (String)com.tencent.mm.model.c.aHp().get(ar.a.Vqe, "");
        if (((String)localObject1).contains(this.contact.field_username))
        {
          localObject1 = ((String)localObject1).replaceAll(this.contact.field_username + ",*", "");
          bh.beI();
          com.tencent.mm.model.c.aHp().set(ar.a.Vqe, localObject1);
          Log.i("MicroMsg.ContactInfoUI", "mark plugin read, userName:%s, newVal:%s", new Object[] { this.contact.field_username, localObject1 });
          if (Util.isNullOrNil((String)localObject1)) {
            com.tencent.mm.aa.c.aFn().D(262158, false);
          }
        }
      }
      if (this.screen != null)
      {
        this.GXv = ((NormalProfileHeaderPreference)this.screen.byG("contact_profile_header_normal"));
        if (this.GXv != null) {
          this.GXv.b(this.GXF, this.GXO.getHeight(), this.GXG);
        }
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(224789);
          if (((ab.QB(ContactInfoUI.h(ContactInfoUI.this).field_username)) && (!z.bdz())) || ((ab.Qt(ContactInfoUI.h(ContactInfoUI.this).field_username)) && (!z.bdv())) || ((ab.Qv(ContactInfoUI.h(ContactInfoUI.this).field_username)) && (!z.bdF())) || ((ab.Qp(ContactInfoUI.h(ContactInfoUI.this).field_username)) && (!z.bdJ())))
          {
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.addFlags(67108864);
            com.tencent.mm.plugin.profile.b.mIG.n(paramAnonymousMenuItem, ContactInfoUI.this);
          }
          ContactInfoUI.this.finish();
          com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(ContactInfoUI.h(ContactInfoUI.this).field_username, 1501, ContactInfoUI.l(ContactInfoUI.this), ContactInfoUI.m(ContactInfoUI.this));
          AppMethodBeat.o(224789);
          return true;
        }
      });
      com.tencent.mm.am.q.bhR().Rv(this.contact.field_username);
      if (((!ab.QB(this.contact.field_username)) || (!z.bdz())) && ((!ab.Qt(this.contact.field_username)) || (!z.bdv())) && ((!ab.Qv(this.contact.field_username)) || (!z.bdF())) && ((!ab.Qp(this.contact.field_username)) || (!z.bdJ()))) {
        break label5468;
      }
      this.GXz = true;
      AppMethodBeat.o(26996);
      return;
      if (ab.Qd(this.contact.field_username))
      {
        this.GXu = ((com.tencent.mm.plugin.wxpaysdk.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.wxpaysdk.api.c.class)).iQ(this);
        break;
      }
      if (ab.Qe(this.contact.field_username))
      {
        this.GXu = ((com.tencent.mm.plugin.wxpaysdk.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.wxpaysdk.api.c.class)).iP(this);
        break;
      }
      if ((1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.waa, 0)) && (ab.Qf(this.contact.field_username)))
      {
        this.GXu = new k(this);
        break;
      }
      if (ab.Qb(this.contact.field_username))
      {
        this.GXu = com.tencent.mm.by.c.ak(this, "sport");
        break;
      }
      if (ab.Qp(this.contact.field_username))
      {
        this.GXu = com.tencent.mm.by.c.ak(this, "qqmail");
        break;
      }
      if (ab.Qq(this.contact.field_username))
      {
        this.GXu = new e(this);
        break;
      }
      if (ab.Qr(this.contact.field_username))
      {
        this.GXu = com.tencent.mm.by.c.ak(this, "tmessage");
        break;
      }
      if (ab.QD(this.contact.field_username))
      {
        this.GXu = new com.tencent.mm.plugin.topstory.ui.widget.a(this);
        break;
      }
      if (ab.Qj(this.contact.field_username))
      {
        this.GXu = new h(this);
        break;
      }
      if (ab.Qx(this.contact.field_username))
      {
        this.GXu = new n(this);
        break;
      }
      if (as.PY(this.contact.field_username))
      {
        this.GXu = new d(this);
        break;
      }
      if (ab.Qz(this.contact.field_username))
      {
        this.GXu = com.tencent.mm.by.c.ak(this, "nearby");
        break;
      }
      if (ab.QA(this.contact.field_username))
      {
        this.GXu = com.tencent.mm.by.c.ak(this, "shake");
        break;
      }
      if (ab.QB(this.contact.field_username))
      {
        this.GXu = new j(this);
        break;
      }
      if (ab.QC(this.contact.field_username))
      {
        this.GXu = com.tencent.mm.by.c.ae(this, "readerapp", "widget_type_news");
        break;
      }
      if (ab.QK(this.contact.field_username))
      {
        this.GXu = com.tencent.mm.by.c.ae(this, "readerapp", "widget_type_weibo");
        break;
      }
      if (ab.Qu(this.contact.field_username))
      {
        this.GXu = new f(this);
        break;
      }
      if (ab.Qv(this.contact.field_username))
      {
        this.GXu = com.tencent.mm.by.c.ak(this, "masssend");
        break;
      }
      if (ab.Qw(this.contact.field_username))
      {
        this.GXu = new g(this);
        break;
      }
      if ((this.contact.hxX()) || (getIntent().getBooleanExtra("key_use_new_contact_profile", false)))
      {
        for (localObject1 = null;; localObject1 = localObject2)
        {
          try
          {
            localObject2 = this.GXy;
            if (localObject2 != null) {
              break label4419;
            }
            localObject1 = null;
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.ContactInfoUI", localIOException, "", new Object[0]);
              continue;
              if (com.tencent.mm.ao.g.Uz(localIOException))
              {
                bool1 = true;
              }
              else
              {
                if (localObject1 != null)
                {
                  localObject3 = new com.tencent.mm.api.c();
                  ((com.tencent.mm.api.c)localObject3).field_extInfo = ((aez)localObject1).mVN;
                  ((com.tencent.mm.api.c)localObject3).field_type = ((com.tencent.mm.api.c)localObject3).dc(false).getServiceType();
                  if (((com.tencent.mm.api.c)localObject3).YV())
                  {
                    bool1 = true;
                    continue;
                  }
                  if (((com.tencent.mm.api.c)localObject3).YU())
                  {
                    bool1 = true;
                    continue;
                  }
                }
                if (getIntent().getBooleanExtra("key_use_new_contact_profile", false)) {
                  bool1 = true;
                } else if ((!com.tencent.mm.ao.g.UC(this.contact.field_username)) && (!com.tencent.mm.ao.g.UB(this.contact.field_username)) && (this.contact.hxX())) {
                  bool1 = true;
                } else {
                  bool1 = false;
                }
              }
            }
            localObject1 = new c(this, (String)localObject4, (aez)localObject1);
            if (Util.isNullOrNil(this.BLy)) {
              break label4645;
            }
            ((c)localObject1).BLy = this.BLy;
            this.GXu = ((com.tencent.mm.pluginsdk.c.a)localObject1);
          }
          localObject2 = this.contact.field_username;
          if ((!MMApplicationContext.getDefaultPreference().getBoolean("use_new_profile", true)) || (ab.Rf((String)localObject2)) || (ab.Qy((String)localObject2)) || (ab.QJ((String)localObject2))) {
            break label4606;
          }
          if (!com.tencent.mm.ao.g.Ux((String)localObject2)) {
            break label4464;
          }
          bool1 = true;
          Log.i("MicroMsg.ContactInfoUI", "username:%s, isUseNewProfileUI:%b", new Object[] { this.contact.field_username, Boolean.valueOf(bool1) });
          if (!bool1) {
            break label4612;
          }
          if (this.GXQ == null) {
            this.GXQ = new ContactWidgetTabBizInfo(this, (String)localObject4, (aez)localObject1, this.zUF);
          }
          this.GXQ.GXB = ((String)localObject4);
          this.GXQ.GYV = ((aez)localObject1);
          this.GXQ.enterTime = this.zUF;
          this.GXQ.BLy = this.BLy;
          this.GXu = this.GXQ;
          break;
          localObject2 = (aez)new aez().parseFrom(this.GXy);
        }
        label4464:
        label4606:
        break;
      }
      if (ab.QG(this.contact.field_username))
      {
        this.GXu = new o(this);
        break;
      }
      if (ab.QH(this.contact.field_username))
      {
        this.GXu = new i(this);
        break;
      }
      if (ab.Qi(this.contact.field_username))
      {
        this.GXu = new com.tencent.mm.plugin.downloader_app.d.a(this);
        break;
      }
      this.GXu = new com.tencent.mm.plugin.profile.a(this);
      if ((this.GXD) || ((this.GXu instanceof ContactWidgetTabBizInfo))) {
        break;
      }
      localObject1 = (RelativeLayout)findViewById(R.h.mm_preference_list_content_root);
      if (localObject1 == null) {
        break;
      }
      Log.i("MicroMsg.ContactInfoUI", "setupStory %s stack %s", new Object[] { this, Util.getStack().toString() });
      this.GXD = true;
      this.GXC = ((PullDownListView)getListView());
      this.GXC.setBackground(aw.bf(getContext(), R.d.me_alpha_bg));
      if (this.GXH)
      {
        this.GXC.setBackground(null);
        this.GXC.Yqv = this.GXN;
        localObject3 = new View(this);
        ((RelativeLayout)localObject1).addView((View)localObject3, 0);
        localObject4 = (RelativeLayout.LayoutParams)((View)localObject3).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject4).width = -1;
        ((RelativeLayout.LayoutParams)localObject4).height = -1;
        ((RelativeLayout.LayoutParams)localObject4).topMargin = com.tencent.mm.ui.ax.au(getContext()).x;
        ((View)localObject3).setBackgroundColor(getResources().getColor(R.e.BG_0));
        ak.kU(getContext());
        final float f = com.tencent.mm.plugin.textstatus.a.a.is(getContext());
        this.GXC.setTranslationListener(new PullDownListView.a()
        {
          public final void bO(float paramAnonymousFloat)
          {
            AppMethodBeat.i(292032);
            this.val$v.setTranslationY(paramAnonymousFloat);
            float f1 = paramAnonymousFloat / f;
            if (paramAnonymousFloat < 0.0F) {
              f1 = 0.0F;
            }
            if (paramAnonymousFloat > f) {
              f1 = 1.0F;
            }
            for (;;)
            {
              if (ContactInfoUI.e(ContactInfoUI.this) != null) {
                ContactInfoUI.e(ContactInfoUI.this).r(f1, paramAnonymousFloat, f);
              }
              if (ContactInfoUI.p(ContactInfoUI.this) == null) {
                ContactInfoUI.a(ContactInfoUI.this, (NormalProfileHeaderPreference)ContactInfoUI.g(ContactInfoUI.this).byG("contact_profile_header_normal"));
              }
              Object localObject;
              if (ContactInfoUI.p(ContactInfoUI.this) != null)
              {
                localObject = ContactInfoUI.p(ContactInfoUI.this);
                if (((NormalProfileHeaderPreference)localObject).EQs == null) {
                  break label248;
                }
                localObject = ((NormalProfileHeaderPreference.a)((NormalProfileHeaderPreference)localObject).EQs.getTag()).HaD;
                if (localObject != null)
                {
                  float f2 = 1.0F * (1.0F - f1);
                  ((View)localObject).setAlpha(f2);
                  localObject = ContactInfoUI.p(ContactInfoUI.this);
                  if (((NormalProfileHeaderPreference)localObject).EQs == null) {
                    break label254;
                  }
                  localObject = ((NormalProfileHeaderPreference.a)((NormalProfileHeaderPreference)localObject).EQs.getTag()).HaF;
                  label195:
                  if (localObject != null)
                  {
                    if (f2 > 0.0F) {
                      break label260;
                    }
                    ((View)localObject).setVisibility(0);
                  }
                }
              }
              for (;;)
              {
                localObject = ContactInfoUI.p(ContactInfoUI.this).fpU();
                if (localObject != null) {
                  ((com.tencent.mm.plugin.textstatus.a.e)localObject).r(f1, paramAnonymousFloat, f);
                }
                AppMethodBeat.o(292032);
                return;
                label248:
                localObject = null;
                break;
                label254:
                localObject = null;
                break label195;
                label260:
                ((View)localObject).setVisibility(8);
              }
            }
          }
        });
        localObject3 = ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).getBackPreview(this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(264112);
            if ((ContactInfoUI.q(ContactInfoUI.this) != null) && (!ContactInfoUI.q(ContactInfoUI.this).isVisible)) {
              ContactInfoUI.q(ContactInfoUI.this).idg();
            }
            AppMethodBeat.o(264112);
          }
        }, true);
        this.GXK = ((com.tencent.mm.plugin.textstatus.a.b)localObject3);
        localObject4 = getIntent().getStringExtra("Contact_User");
        if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (localObject3 != null) && (((com.tencent.mm.plugin.textstatus.a.b)localObject3).getView() != null))
        {
          ((RelativeLayout)localObject1).addView(((com.tencent.mm.plugin.textstatus.a.b)localObject3).getView(), 0);
          ((com.tencent.mm.plugin.textstatus.a.b)localObject3).gkD();
          ((com.tencent.mm.plugin.textstatus.a.b)localObject3).a(this);
          ((com.tencent.mm.plugin.textstatus.a.b)localObject3).KN((String)localObject4);
        }
        this.GXC.setNavigationBarHeight(com.tencent.mm.ui.ax.aB(getContext()));
        this.GXL = new ContactInfoUI.4(this);
        localObject1 = com.tencent.mm.plugin.story.h.h.LOJ;
        com.tencent.mm.plugin.story.h.h.geE().gQR = 3L;
        break;
      }
      if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class)).isShowStoryCheck()) {
        break;
      }
      this.GXC.Yqv = this.GXM;
      i = -com.tencent.mm.ui.ax.au(getContext()).y / 10;
      Object localObject3 = new RelativeLayout.LayoutParams(-1, com.tencent.mm.ui.ax.au(getContext()).y);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = (-com.tencent.mm.ui.ax.aB(getContext()));
      if (this.contact.field_username.equals(z.bcZ())) {}
      for (this.storyGallery = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(this, com.tencent.mm.plugin.story.api.n.a.LEA, this.roomId);; this.storyGallery = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(this, com.tencent.mm.plugin.story.api.n.a.LEB, this.roomId))
      {
        this.storyGallery.gbl();
        this.GXC.A(this.storyGallery, com.tencent.mm.ci.a.aZ(getContext(), R.f.dlB), i);
        this.storyGallery.setStoryBrowseUIListener(this);
        this.storyGallery.setDataSeed(this.contact.field_username);
        this.storyGallery.a(this.GXC);
        ((RelativeLayout)localObject1).addView(this.storyGallery, 0, (ViewGroup.LayoutParams)localObject3);
        com.tencent.mm.kernel.h.aHH();
        this.GXE = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().ii(this);
        localObject3 = new RelativeLayout.LayoutParams(com.tencent.mm.ci.a.aZ(getContext(), R.f.dlA), com.tencent.mm.ci.a.aZ(getContext(), R.f.dlA));
        ((RelativeLayout.LayoutParams)localObject3).addRule(9);
        ((RelativeLayout.LayoutParams)localObject3).addRule(12);
        ((RelativeLayout)localObject1).addView(this.GXE, 0, (ViewGroup.LayoutParams)localObject3);
        this.GXC.setMuteView(this.GXE);
        break;
      }
      i = 1;
      break label3233;
      i = 1;
      break label3261;
    }
    label4612:
    label4645:
    label5468:
    this.GXz = false;
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
    if (this.GXu != null) {
      this.GXu.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(26997);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(27005);
    if (((this.storyGallery == null) || (!this.storyGallery.onBackPressed())) && (!getSupportFragmentManager().isDestroyed())) {
      super.onBackPressed();
    }
    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(this.contact.field_username, 1501, this.mXL, this.zUF);
    AppMethodBeat.o(27005);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(26988);
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1) {
      this.lft = false;
    }
    for (;;)
    {
      if ((this.GXC != null) && (!this.GXC.isVisible)) {
        this.GXC.idf();
      }
      fqd();
      paramConfiguration = fpU();
      if (paramConfiguration != null) {
        paramConfiguration.KN(getIntent().getStringExtra("Contact_User"));
      }
      AppMethodBeat.o(26988);
      return;
      if (paramConfiguration.orientation == 2) {
        this.lft = true;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26986);
    this.GXH = com.tencent.mm.plugin.textstatus.a.t.gkZ();
    if ((this.GXH) && (((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).hasStatus(getIntent().getStringExtra("Contact_User"))))
    {
      bool = true;
      this.GXG = bool;
      bh.beI();
      as localas = com.tencent.mm.model.c.bbL().RG(Util.nullAsNil(getIntent().getStringExtra("Contact_User")));
      if (localas == null) {
        break label306;
      }
      com.tencent.mm.kernel.h.aHH();
      if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(localas.field_username)) {
        break label306;
      }
      this.GXF = true;
      label114:
      if (this.GXH) {
        this.GXF = false;
      }
      if ((this.GXF) || (this.GXG)) {
        customfixStatusbar(true);
      }
      super.onCreate(paramBundle);
      MultiProcessMMKV.getMMKV("SnsMMKV").encode("SnsMMKVSnsUI", true);
      if (getResources().getConfiguration().orientation != 2) {
        break label314;
      }
    }
    label306:
    label314:
    for (boolean bool = true;; bool = false)
    {
      this.lft = bool;
      this.zUF = System.currentTimeMillis();
      this.Cwk = findViewById(R.h.action_bar_container);
      this.GXO = this.Cwk.findViewById(R.h.action_bar_root);
      fqd();
      paramBundle = getWindow().getDecorView();
      paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x400 | 0x100);
      Log.i("MicroMsg.ContactInfoUI", "onCreate MMCore.accHasReady[%b]", new Object[] { Boolean.valueOf(bh.aHB()) });
      this.GXA = getIntent().getStringExtra("Contact_Search_Mobile");
      if (com.tencent.mm.kernel.h.aHE().aGM()) {
        break label319;
      }
      finish();
      AppMethodBeat.o(26986);
      return;
      bool = false;
      break;
      this.GXF = false;
      break label114;
    }
    label319:
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().add(this);
    bh.beI();
    com.tencent.mm.model.c.bbM().a(this);
    bh.beI();
    com.tencent.mm.model.c.bbN().a(this);
    initView();
    hideActionbarLine();
    if ((this.GXu instanceof com.tencent.mm.pluginsdk.c.b)) {
      ((com.tencent.mm.pluginsdk.c.b)this.GXu).onCreate();
    }
    com.tencent.mm.plugin.profile.d.a(getIntent(), 1, 1, this.contact.field_username);
    paramBundle = com.tencent.mm.plugin.story.h.h.LOJ;
    com.tencent.mm.plugin.story.h.h.geE().gSg = com.tencent.mm.plugin.profile.d.aO(getIntent());
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(273, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(291, this);
    AppMethodBeat.o(26986);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26989);
    MultiProcessMMKV.getMMKV("SnsMMKV").encode("SnsMMKVSnsUI", false);
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.LOJ;
    com.tencent.mm.plugin.story.h.h.geE().gSg = 0L;
    if (com.tencent.mm.kernel.h.aHE().aGM())
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().remove(this);
      bh.beI();
      com.tencent.mm.model.c.bbM().b(this);
      bh.beI();
      com.tencent.mm.model.c.bbN().b(this);
    }
    if (this.GXu == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ContactInfoUI", "onDestroy bodyWidget is null?%s", new Object[] { Boolean.valueOf(bool) });
      if (this.GXu != null) {
        this.GXu.cQX();
      }
      if ((this.GXu instanceof com.tencent.mm.pluginsdk.c.b)) {
        ((com.tencent.mm.pluginsdk.c.b)this.GXu).aEt();
      }
      if (p.JPc != null) {
        p.JPc.aO(this);
      }
      super.onDestroy();
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.b(273, this);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.b(291, this);
      if (this.storyGallery != null) {
        this.storyGallery.onDestroy();
      }
      com.tencent.mm.plugin.profile.d.a(getIntent(), 18, 1, this.contact.field_username);
      com.tencent.mm.plugin.report.service.h.IzE.a(17283, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.d.aO(getIntent())), this.contact.field_username, Boolean.valueOf(this.GXF), Boolean.valueOf(this.GXI), Integer.valueOf(this.contact.uin), Integer.valueOf(this.GXJ) });
      if (this.GXK != null) {
        this.GXK.gkI();
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
    af.bjv().remove(this);
    super.onPause();
    bh.aHJ().postAtFrontOfQueueToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(271712);
        bh.beI();
        com.tencent.mm.model.c.aHp().hxT();
        AppMethodBeat.o(271712);
      }
    });
    if (getIntent().getBooleanExtra("key_from_wesport_right_newtips", false))
    {
      com.tencent.mm.plugin.newtips.a.fiO();
      com.tencent.mm.plugin.newtips.a.i.aI(com.tencent.mm.plugin.newtips.a.d.Gwh, getActivityBrowseTimeMs());
    }
    for (;;)
    {
      fqb();
      if (this.GXC != null) {
        this.GXC.idf();
      }
      if (this.storyGallery != null) {
        this.storyGallery.onPause();
      }
      if (((this.GXu instanceof c)) || ((this.GXu instanceof ContactWidgetTabBizInfo))) {
        this.GXu.cQX();
      }
      if ((this.GXu instanceof com.tencent.mm.pluginsdk.c.b)) {
        ((com.tencent.mm.pluginsdk.c.b)this.GXu).onPause();
      }
      com.tencent.mm.pluginsdk.ui.span.l.b(this.sCG);
      if (this.GXK != null) {
        this.GXK.gkK();
      }
      AppMethodBeat.o(26993);
      return;
      if (getIntent().getBooleanExtra("key_from_wesport_plugin_newtips", false))
      {
        com.tencent.mm.plugin.newtips.a.fiO();
        com.tencent.mm.plugin.newtips.a.i.aI(com.tencent.mm.plugin.newtips.a.d.Gwf, getActivityBrowseTimeMs());
      }
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(26998);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.ContactInfoUI", paramf + " item has been clicked!");
    if (this.GXu != null) {
      this.GXu.atw(paramf);
    }
    if (paramPreference != null)
    {
      if (!paramPreference.mKey.equals("contact_info_sns")) {
        break label107;
      }
      com.tencent.mm.plugin.profile.d.a(getIntent(), 3, 1, this.contact.field_username);
    }
    for (;;)
    {
      if ((paramPreference instanceof NormalProfileHeaderPreference)) {
        fqc();
      }
      AppMethodBeat.o(26998);
      return false;
      label107:
      if (paramPreference.mKey.equals("contact_info_more")) {
        com.tencent.mm.plugin.profile.d.a(getIntent(), 6, 1, this.contact.field_username);
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
        paramArrayOfString = (NormalUserFooterPreference)this.screen.byG("contact_info_footer_normal");
        if (paramArrayOfString != null) {
          paramArrayOfString.fqz();
        }
        AppMethodBeat.o(27002);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = R.l.permission_camera_request_again_msg;; paramInt = R.l.permission_microphone_request_again_msg)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this, getString(paramInt), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new ContactInfoUI.12(this), new ContactInfoUI.13(this));
        }
        AppMethodBeat.o(27002);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        paramArrayOfString = (NormalUserFooterPreference)this.screen.byG("contact_info_footer_normal");
        if (paramArrayOfString != null) {
          paramArrayOfString.fqy();
        }
        AppMethodBeat.o(27002);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new ContactInfoUI.14(this), null);
    }
  }
  
  protected void onRestart()
  {
    AppMethodBeat.i(26992);
    super.onRestart();
    this.GXP = false;
    AppMethodBeat.o(26992);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26990);
    com.tencent.mm.modelstat.d.d(3, "ContactInfoUI" + getIdentString(), hashCode());
    af.bjv().add(this);
    super.onResume();
    View localView = ((ViewGroup)getContentView()).getFocusedChild();
    if (localView != null)
    {
      localView.clearFocus();
      Log.i("MicroMsg.ContactInfoUI", "try to clear focus. id:%s", new Object[] { Integer.valueOf(localView.getId()) });
    }
    this.GXC = ((PullDownListView)getListView());
    if (this.storyGallery != null) {
      this.storyGallery.onResume();
    }
    if (this.screen != null)
    {
      this.GXv = ((NormalProfileHeaderPreference)this.screen.byG("contact_profile_header_normal"));
      if (this.GXv != null) {
        this.GXv.b(this.GXF, this.GXO.getHeight(), this.GXG);
      }
    }
    if (((this.GXu instanceof c)) || ((this.GXu instanceof ContactWidgetTabBizInfo))) {
      this.GXu.a(this.screen, this.contact, this.GXw, this.mXL);
    }
    if ((this.GXu instanceof com.tencent.mm.pluginsdk.c.b)) {
      ((com.tencent.mm.pluginsdk.c.b)this.GXu).onResume();
    }
    com.tencent.mm.pluginsdk.ui.span.l.a(this.sCG);
    if (this.GXK != null) {
      this.GXK.gkJ();
    }
    AppMethodBeat.o(26990);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(27004);
    Log.d("MicroMsg.ContactInfoUI", "onSceneEnd errType[%s] errCode[%s] errMsg[%s] sceneType[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.getType()) });
    if ((273 == paramq.getType()) && (this.contact != null) && ((this.GXu instanceof com.tencent.mm.plugin.profile.a)) && (Util.isEqual(this.contact.field_username, ((com.tencent.mm.plugin.story.f.a.i)paramq).userName)))
    {
      int i = ((com.tencent.mm.plugin.story.f.a.i)paramq).source;
      paramString = com.tencent.mm.plugin.story.i.a.LPG;
      if (i == com.tencent.mm.plugin.story.i.a.gfF())
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
        this.GXI = bool;
        this.GXJ = ((com.tencent.mm.plugin.story.f.a.i)paramq).BAV;
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
    if (this.storyGallery != null) {
      this.storyGallery.onStart();
    }
    AppMethodBeat.o(26991);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(26994);
    super.onStop();
    if (this.storyGallery != null) {
      this.storyGallery.onStop();
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
    private WeakReference<ContactInfoUI> cNB;
    private String iSn;
    
    a(ContactInfoUI paramContactInfoUI, String paramString)
    {
      AppMethodBeat.i(26978);
      this.cNB = new WeakReference(paramContactInfoUI);
      this.iSn = paramString;
      AppMethodBeat.o(26978);
    }
    
    public final void run()
    {
      AppMethodBeat.i(26979);
      ContactInfoUI localContactInfoUI = (ContactInfoUI)this.cNB.get();
      Log.i("MicroMsg.ContactInfoUI", "onNotifyChange contact %s", new Object[] { this.iSn });
      if ((localContactInfoUI == null) || (localContactInfoUI.isFinishing()) || (localContactInfoUI.isDestroyed()))
      {
        AppMethodBeat.o(26979);
        return;
      }
      Log.i("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", new Object[] { Boolean.valueOf(ContactInfoUI.n(localContactInfoUI)), ContactInfoUI.h(localContactInfoUI).field_username, this.iSn });
      if ((ContactInfoUI.h(localContactInfoUI) != null) && (!Util.isNullOrNil(ContactInfoUI.h(localContactInfoUI).field_username)) && ((ContactInfoUI.h(localContactInfoUI).field_username.equals(this.iSn)) || (ContactInfoUI.h(localContactInfoUI).field_username.equals(as.bvW(this.iSn)))))
      {
        ContactInfoUI.a(localContactInfoUI, ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.iSn));
        if (ContactInfoUI.o(localContactInfoUI) != null)
        {
          ContactInfoUI.o(localContactInfoUI).cQX();
          ContactInfoUI.g(localContactInfoUI).removeAll();
        }
        localContactInfoUI.initView();
      }
      AppMethodBeat.o(26979);
    }
  }
  
  static final class b
    implements Runnable
  {
    private bq GXT;
    private WeakReference<ContactInfoUI> cNB;
    
    b(ContactInfoUI paramContactInfoUI, bq parambq)
    {
      AppMethodBeat.i(291449);
      this.cNB = new WeakReference(paramContactInfoUI);
      this.GXT = parambq;
      AppMethodBeat.o(291449);
    }
    
    public final void run()
    {
      AppMethodBeat.i(291450);
      ContactInfoUI localContactInfoUI = (ContactInfoUI)this.cNB.get();
      Log.i("MicroMsg.ContactInfoUI", "onNotifyFriendUserChange user: %s", new Object[] { this.GXT });
      if ((localContactInfoUI == null) || (localContactInfoUI.isFinishing()) || (localContactInfoUI.isDestroyed()))
      {
        AppMethodBeat.o(291450);
        return;
      }
      String str2 = ContactInfoUI.h(localContactInfoUI).field_username;
      if (this.GXT != null) {}
      for (String str1 = this.GXT.field_encryptUsername;; str1 = "")
      {
        Log.i("MicroMsg.ContactInfoUI", "onNotifyFriendUserChange contact.user:%s, notify.user:%s, friendUser:%s", new Object[] { str2, str1, this.GXT.field_username });
        if ((ContactInfoUI.h(localContactInfoUI) != null) && (this.GXT != null) && (!Util.isNullOrNil(ContactInfoUI.h(localContactInfoUI).field_username)) && (ContactInfoUI.h(localContactInfoUI).field_username.equals(this.GXT.field_encryptUsername)) && (!ab.QY(ContactInfoUI.h(localContactInfoUI).field_username)))
        {
          str1 = this.GXT.field_username;
          if ((!Util.isNullOrNil(str1)) && (!str1.equals(ContactInfoUI.h(localContactInfoUI).field_username))) {
            com.tencent.mm.plugin.report.service.h.IzE.el(1430, 4);
          }
          if (!Util.isNullOrNil(str1)) {
            ContactInfoUI.a(localContactInfoUI, ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(str1));
          }
          localContactInfoUI.getIntent().putExtra("Contact_User", ContactInfoUI.h(localContactInfoUI).field_username);
          Log.i("MicroMsg.ContactInfoUI", "new contact user:%s", new Object[] { ContactInfoUI.h(localContactInfoUI).field_username });
          if (ContactInfoUI.o(localContactInfoUI) != null)
          {
            ContactInfoUI.o(localContactInfoUI).cQX();
            ContactInfoUI.g(localContactInfoUI).removeAll();
          }
          localContactInfoUI.initView();
        }
        AppMethodBeat.o(291450);
        return;
      }
    }
  }
  
  static final class c
    implements Runnable
  {
    private co GXU;
    private WeakReference<ContactInfoUI> cNB;
    
    c(ContactInfoUI paramContactInfoUI, co paramco)
    {
      AppMethodBeat.i(26980);
      this.cNB = new WeakReference(paramContactInfoUI);
      this.GXU = paramco;
      AppMethodBeat.o(26980);
    }
    
    public final void run()
    {
      AppMethodBeat.i(26981);
      ContactInfoUI localContactInfoUI = (ContactInfoUI)this.cNB.get();
      Log.i("MicroMsg.ContactInfoUI", "onNotifyChange stranger %s", new Object[] { this.GXU });
      if ((localContactInfoUI == null) || (localContactInfoUI.isFinishing()) || (localContactInfoUI.isDestroyed()))
      {
        AppMethodBeat.o(26981);
        return;
      }
      Log.i("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", new Object[] { Boolean.valueOf(ContactInfoUI.n(localContactInfoUI)), ContactInfoUI.h(localContactInfoUI).field_username, this.GXU });
      if ((ContactInfoUI.h(localContactInfoUI) != null) && (this.GXU != null) && (!Util.isNullOrNil(ContactInfoUI.h(localContactInfoUI).field_username)) && (ContactInfoUI.h(localContactInfoUI).field_username.equals(this.GXU.field_encryptUsername)) && (!ab.QY(ContactInfoUI.h(localContactInfoUI).field_username)))
      {
        ContactInfoUI.h(localContactInfoUI).Ir(this.GXU.field_conRemark);
        localContactInfoUI.getIntent().putExtra("Contact_User", ContactInfoUI.h(localContactInfoUI).field_username);
        if (ContactInfoUI.o(localContactInfoUI) != null)
        {
          ContactInfoUI.o(localContactInfoUI).cQX();
          ContactInfoUI.g(localContactInfoUI).removeAll();
        }
        localContactInfoUI.initView();
      }
      AppMethodBeat.o(26981);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI
 * JD-Core Version:    0.7.0.1
 */