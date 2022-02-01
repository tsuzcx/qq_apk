package com.tencent.mm.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ah;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.finder.report.b.e;
import com.tencent.mm.plugin.finder.view.k;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.c.a;
import com.tencent.mm.plugin.gamelife.c.b;
import com.tencent.mm.plugin.i.a.p.b;
import com.tencent.mm.plugin.i.a.r;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.protocal.protobuf.apu;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.kernel.i
public class SingleChatInfoUI
  extends MMPreference
  implements com.tencent.mm.bi.a
{
  private static boolean isDeleteCancel = false;
  private CheckBoxPreference JfG;
  final com.tencent.mm.plugin.appbrand.z.i<Boolean> JfH;
  private com.tencent.mm.plugin.appbrand.z.i<Boolean> JfI;
  private p.b JfJ;
  private com.tencent.mm.sdk.e.k.a JfK;
  private am contact;
  private ContactListExpandPreference fMC;
  private CheckBoxPreference fMD;
  private CheckBoxPreference fMF;
  private boolean fMP;
  private int fMR;
  private boolean fMT;
  private com.tencent.mm.pluginsdk.ui.e fMX;
  boolean fMY;
  private String fNc;
  private ap handler;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  private String talker;
  
  public SingleChatInfoUI()
  {
    AppMethodBeat.i(33732);
    this.handler = new ap(Looper.getMainLooper());
    this.sp = null;
    this.JfH = new com.tencent.mm.plugin.appbrand.z.i();
    this.JfI = new com.tencent.mm.plugin.appbrand.z.i();
    this.fMR = -1;
    this.fMT = false;
    this.JfJ = null;
    this.fMX = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.JfK = new com.tencent.mm.sdk.e.k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(193748);
        SingleChatInfoUI.c(SingleChatInfoUI.this);
        AppMethodBeat.o(193748);
      }
    };
    this.fMY = false;
    this.fNc = "";
    AppMethodBeat.o(33732);
  }
  
  private void YC()
  {
    AppMethodBeat.i(33742);
    if ((am.ail(this.talker)) || (am.aSV(this.talker)))
    {
      this.screen.cP(this.fMD.mKey, true);
      AppMethodBeat.o(33742);
      return;
    }
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    this.fMP = this.contact.Pf();
    if (this.fMP)
    {
      setTitleMuteIconVisibility(0);
      if (this.fMD != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(33742);
      return;
      setTitleMuteIconVisibility(8);
      if (this.fMD != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private void b(final ProgressDialog paramProgressDialog)
  {
    AppMethodBeat.i(33741);
    bj.a(this.contact.field_username, new bj.a()
    {
      public final boolean YK()
      {
        AppMethodBeat.i(193755);
        boolean bool = SingleChatInfoUI.bIw();
        AppMethodBeat.o(193755);
        return bool;
      }
      
      public final void YL()
      {
        AppMethodBeat.i(193756);
        if (paramProgressDialog != null) {
          paramProgressDialog.dismiss();
        }
        AppMethodBeat.o(193756);
      }
    });
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193742);
        com.tencent.mm.modelmulti.p.aJx().pM(7);
        AppMethodBeat.o(193742);
      }
    });
    AppMethodBeat.o(33741);
  }
  
  private void fxI()
  {
    int j = 0;
    AppMethodBeat.i(33739);
    this.JfG = ((CheckBoxPreference)this.screen.aVD("force_notify"));
    if ((am.aSQ(this.contact.field_username)) || (com.tencent.mm.model.u.za(this.contact.field_username)))
    {
      this.screen.cP("force_notify", true);
      AppMethodBeat.o(33739);
      return;
    }
    long l = ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).ajy(this.contact.field_username);
    boolean bool = ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).ajz(this.contact.field_username);
    this.JfG.oB = bool;
    this.JfG.xE(bool);
    if (this.JfG.isChecked())
    {
      this.JfG.setSummary(getResources().getString(2131759597, new Object[] { new SimpleDateFormat("HH:mm").format(new Date(l)) }));
      if (this.sp == null) {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      }
      this.sp.edit().putBoolean("force_notify", this.JfG.isChecked()).commit();
      if (!this.JfG.isChecked()) {
        break label327;
      }
    }
    label327:
    for (int i = j;; i = 8)
    {
      setTitleForceNotifyIconVisibility(i);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(33739);
      return;
      this.JfG.setSummary(null);
      if (this.contact.Pf()) {}
      for (i = 0;; i = 8)
      {
        setTitleMuteIconVisibility(i);
        break;
      }
    }
  }
  
  public com.tencent.mm.ui.base.preference.h createAdapter(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(33744);
    paramSharedPreferences = new com.tencent.mm.ui.base.preference.a(this, getListView(), paramSharedPreferences);
    AppMethodBeat.o(33744);
    return paramSharedPreferences;
  }
  
  public int getResourceId()
  {
    return 2131951708;
  }
  
  public final void h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(33743);
    if ((paramString1.equals(this.talker)) && (this.fMC != null)) {
      this.fMC.notifyChanged();
    }
    AppMethodBeat.o(33743);
  }
  
  protected void initView()
  {
    AppMethodBeat.i(33738);
    if (this.contact == null)
    {
      ad.e("MicroMsg.SingleChatInfoUI", "[initView] contact is null!");
      finish();
    }
    this.screen = getPreferenceScreen();
    setMMTitle(getString(2131762729));
    this.fMC = ((ContactListExpandPreference)this.screen.aVD("roominfo_contact_anchor"));
    this.fMC.a(this.screen, this.fMC.mKey);
    this.fMC.vO(true).vP(false);
    if ((this.contact != null) && (this.contact.field_deleteFlag == 1)) {
      this.fMC.vO(false);
    }
    if ((!com.tencent.mm.ui.contact.u.fIr()) && (this.contact != null) && (am.aSQ(this.contact.field_username))) {
      this.fMC.vO(false);
    }
    this.fMD = ((CheckBoxPreference)this.screen.aVD("room_notify_new_msg"));
    this.fMF = ((CheckBoxPreference)this.screen.aVD("room_placed_to_the_top"));
    Object localObject = this.screen;
    boolean bool;
    if (!com.tencent.mm.o.b.lM(this.contact.field_type))
    {
      bool = true;
      ((com.tencent.mm.ui.base.preference.f)localObject).cP("force_notify", bool);
      if (this.sp == null) {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      }
      if (this.contact == null) {
        break label549;
      }
      if (!am.ail(this.talker)) {
        break label526;
      }
      bool = ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).aig(this.talker);
      label299:
      this.sp.edit().putBoolean("room_placed_to_the_top", bool).commit();
      this.fMP = this.contact.Pf();
      this.sp.edit().putBoolean("room_notify_new_msg", this.fMP).commit();
    }
    for (;;)
    {
      if (am.ail(this.talker))
      {
        this.screen.cP("room_search_chatting_content", true);
        this.screen.cP("force_notify", true);
      }
      ba.aBQ();
      this.fMR = com.tencent.mm.model.c.azs().aqn(this.talker);
      this.screen.notifyDataSetChanged();
      if (this.fMC != null)
      {
        localObject = new LinkedList();
        ((List)localObject).add(this.talker);
        this.fMC.A(this.talker, (List)localObject);
        getListView().setOnScrollListener(this.fMX);
        this.fMC.a(this.fMX);
        this.fMC.a(new ContactListExpandPreference.a()
        {
          public final void YJ()
          {
            AppMethodBeat.i(193751);
            if (SingleChatInfoUI.e(SingleChatInfoUI.this) != null) {
              SingleChatInfoUI.e(SingleChatInfoUI.this).fcH();
            }
            AppMethodBeat.o(193751);
          }
          
          public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
          {
            AppMethodBeat.i(193750);
            Object localObject3 = SingleChatInfoUI.e(SingleChatInfoUI.this).YX(paramAnonymousInt);
            Object localObject2 = bt.nullAsNil(SingleChatInfoUI.e(SingleChatInfoUI.this).YZ(paramAnonymousInt));
            Object localObject1 = localObject2;
            if (bt.isNullOrNil((String)localObject2))
            {
              ba.aBQ();
              com.tencent.mm.storage.cf localcf = com.tencent.mm.model.c.azq().aqz((String)localObject3);
              localObject1 = localObject2;
              if (localcf != null)
              {
                localObject1 = localObject2;
                if (!bt.isNullOrNil(localcf.field_encryptUsername)) {
                  localObject1 = localcf.field_conRemark;
                }
              }
            }
            if (bt.isNullOrNil((String)localObject3))
            {
              AppMethodBeat.o(193750);
              return;
            }
            if (am.ail(SingleChatInfoUI.a(SingleChatInfoUI.this)))
            {
              localObject1 = com.tencent.mm.plugin.finder.report.b.snk;
              localObject1 = com.tencent.mm.plugin.finder.report.b.cDl();
              ((b.e)localObject1).snD += 1L;
              ad.i(((b.e)localObject1).TAG, "incChatInfoClickCount:" + ((b.e)localObject1).snD);
              localObject2 = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).aii(SingleChatInfoUI.a(SingleChatInfoUI.this));
              if (am.aSU((String)localObject2))
              {
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra("finder_username", (String)localObject2);
                localObject2 = FinderReporterUIC.tcM;
                FinderReporterUIC.a.a(paramAnonymousViewGroup.getContext(), (Intent)localObject1, 0L, 10, false);
                ((t)com.tencent.mm.kernel.g.ad(t.class)).enterFinderProfileUI(paramAnonymousViewGroup.getContext(), (Intent)localObject1);
                AppMethodBeat.o(193750);
                return;
              }
              localObject1 = new Intent();
              localObject2 = ((com.tencent.mm.plugin.i.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.f.class)).ahZ((String)localObject2);
              localObject3 = k.sWA;
              com.tencent.mm.plugin.finder.view.k.a.a((r)localObject2, (Intent)localObject1);
              localObject2 = k.sWA;
              com.tencent.mm.plugin.finder.view.k.a.X(paramAnonymousViewGroup.getContext(), (Intent)localObject1);
              AppMethodBeat.o(193750);
              return;
            }
            if (am.aSV(SingleChatInfoUI.a(SingleChatInfoUI.this)))
            {
              ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).enterGameLifeProfileUI(SingleChatInfoUI.this.getContext(), SingleChatInfoUI.a(SingleChatInfoUI.this), com.tencent.mm.plugin.gamelife.a.uwm);
              AppMethodBeat.o(193750);
              return;
            }
            paramAnonymousViewGroup = new Intent();
            paramAnonymousViewGroup.putExtra("Contact_User", (String)localObject3);
            paramAnonymousViewGroup.putExtra("Contact_RemarkName", (String)localObject1);
            paramAnonymousViewGroup.putExtra("Contact_Nick", bt.nullAsNil(SingleChatInfoUI.e(SingleChatInfoUI.this).YY(paramAnonymousInt)));
            paramAnonymousViewGroup.putExtra("Contact_RoomMember", true);
            paramAnonymousViewGroup.putExtra("CONTACT_INFO_UI_SOURCE", 9);
            localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf((String)localObject3);
            if ((localObject1 != null) && ((int)((com.tencent.mm.o.b)localObject1).gfj > 0) && (com.tencent.mm.o.b.lM(((aw)localObject1).field_type))) {
              com.tencent.mm.ui.contact.e.a(paramAnonymousViewGroup, (String)localObject3);
            }
            paramAnonymousViewGroup.putExtra("Kdel_from", 0);
            com.tencent.mm.bs.d.b(SingleChatInfoUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousViewGroup, 0);
            AppMethodBeat.o(193750);
          }
          
          public final void lc(int paramAnonymousInt) {}
          
          public final void ld(int paramAnonymousInt)
          {
            AppMethodBeat.i(193752);
            SingleChatInfoUI.f(SingleChatInfoUI.this);
            AppMethodBeat.o(193752);
          }
        });
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(193753);
          SingleChatInfoUI.this.finish();
          AppMethodBeat.o(193753);
          return true;
        }
      });
      AppMethodBeat.o(33738);
      return;
      bool = false;
      break;
      label526:
      ba.aBQ();
      bool = com.tencent.mm.model.c.azv().aTH(this.contact.field_username);
      break label299;
      label549:
      this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      this.fMP = false;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(33737);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(33737);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(33737);
      return;
    }
    if (paramInt2 == -1)
    {
      finish();
      AppMethodBeat.o(33737);
      return;
    }
    AppMethodBeat.o(33737);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33733);
    super.onCreate(paramBundle);
    ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).cQy().add(this.JfK);
    if (com.tencent.mm.bi.g.irs != null) {
      com.tencent.mm.bi.g.irs.a(this);
    }
    this.talker = getIntent().getStringExtra("Single_Chat_Talker");
    this.fMT = getIntent().getBooleanExtra("fromChatting", false);
    this.contact = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.talker);
    if (this.contact == null)
    {
      ad.e("MicroMsg.SingleChatInfoUI", "contact is null! talker:%s", new Object[] { this.talker });
      finish();
      AppMethodBeat.o(33733);
      return;
    }
    this.fNc = (getPackageName() + "_preferences");
    initView();
    ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.a.class)).D(this.contact.field_username, 3, com.tencent.mm.model.cf.aCL() / 1000L);
    Object localObject;
    String str;
    label297:
    b.e locale;
    long l;
    if (!am.aSV(this.talker))
    {
      this.screen.cP("room_add_blacklist", true);
      if (am.ail(this.talker))
      {
        this.JfJ = new SingleChatInfoUI.6(this);
        paramBundle = new LinkedList();
        localObject = new apu();
        str = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).aii(this.talker);
        if (!am.aSU(str)) {
          break label582;
        }
        ((apu)localObject).scene = 2;
        ((apu)localObject).sessionId = this.talker;
        ((apu)localObject).drf = str;
        paramBundle.add(localObject);
        ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).a(paramBundle, this.JfJ);
        this.screen.cP("room_placed_to_the_top", true);
        str = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).aii(this.talker);
        paramBundle = com.tencent.mm.plugin.finder.report.b.snk;
        locale = com.tencent.mm.plugin.finder.report.b.cDl();
        if (!am.aSU(str)) {
          break label591;
        }
        l = 1L;
        label392:
        if (this.talker != null) {
          break label598;
        }
      }
    }
    label582:
    label591:
    label598:
    for (paramBundle = "";; paramBundle = this.talker)
    {
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      d.g.b.p.h(paramBundle, "chatName");
      d.g.b.p.h(localObject, "talkUserName");
      locale.snt = l;
      locale.snz = paramBundle;
      locale.snv = ((String)localObject);
      locale.snx = String.valueOf(com.tencent.mm.model.cf.aCM());
      AppMethodBeat.o(33733);
      return;
      this.screen.cP("room_search_chatting_content", true);
      this.screen.cP("room_set_chatting_background", true);
      this.screen.cP("room_placed_to_the_top", true);
      this.screen.cP("force_notify", true);
      this.screen.cP("seperate_line_between_force_notify_and_background", true);
      this.screen.cP("seperate_line_between_background_and_clear_history", true);
      ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).initGameLifeSingleChatInfoUI(getContext(), this.talker, new c.a()
      {
        public final void S(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(193744);
          SingleChatInfoUI.j(SingleChatInfoUI.this).value = Boolean.valueOf(paramAnonymousBoolean2);
          SingleChatInfoUI.this.JfH.value = Boolean.valueOf(paramAnonymousBoolean1);
          SingleChatInfoUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(193743);
              if ((SingleChatInfoUI.j(SingleChatInfoUI.this) != null) && (SingleChatInfoUI.j(SingleChatInfoUI.this).value != null)) {
                SingleChatInfoUI.k(SingleChatInfoUI.this).edit().putBoolean("room_add_blacklist", ((Boolean)SingleChatInfoUI.j(SingleChatInfoUI.this).value).booleanValue()).commit();
              }
              SingleChatInfoUI.d(SingleChatInfoUI.this).notifyDataSetChanged();
              AppMethodBeat.o(193743);
            }
          });
          AppMethodBeat.o(193744);
        }
      });
      break;
      ((apu)localObject).scene = 1;
      break label297;
      l = 2L;
      break label392;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33736);
    ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).cQy().remove(this.JfK);
    com.tencent.mm.ui.h.a.dismiss();
    if (com.tencent.mm.bi.g.irs != null) {
      com.tencent.mm.bi.g.irs.b(this);
    }
    super.onDestroy();
    Object localObject1 = FinderReporterUIC.tcM;
    if (FinderReporterUIC.a.eY(getContext()) != null)
    {
      localObject1 = FinderReporterUIC.tcM;
      FinderReporterUIC.a.eY(getContext()).fZ(0, 0);
      localObject1 = FinderReporterUIC.tcM;
    }
    for (localObject1 = FinderReporterUIC.a.eY(getContext()).cOu();; localObject1 = null)
    {
      Object localObject2 = com.tencent.mm.plugin.finder.report.b.snk;
      b.e locale = com.tencent.mm.plugin.finder.report.b.cDl();
      ah localah = new ah();
      if (localObject1 != null)
      {
        String str = ((aqy)localObject1).sessionId;
        localObject2 = str;
        if (str == null) {
          localObject2 = "";
        }
        localah.hg((String)localObject2);
        localObject2 = ((aqy)localObject1).qXj;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localah.hh((String)localObject1);
      }
      localObject2 = localah.dQt;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localah.hg((String)localObject1);
      localObject2 = localah.dVi;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localah.hh((String)localObject1);
      localah.dVk = localah.t("chatSessionid", locale.snx, true);
      localah.dVg = locale.snt;
      localah.dVm = localah.t("chatName", locale.snz, true);
      localah.dVh = localah.t("talkerUsername", locale.snv, true);
      localah.dVz = locale.snK;
      localah.dVq = locale.snD;
      localah.dVA = locale.snJ;
      localah.dVB = locale.snI;
      localah.aLk();
      localObject1 = com.tencent.mm.plugin.finder.report.b.snk;
      com.tencent.mm.plugin.finder.report.b.a(locale.TAG, (com.tencent.mm.plugin.report.a)localah);
      locale.snt = 0L;
      locale.snz = "";
      locale.snv = "";
      locale.snD = 0L;
      locale.snI = 0L;
      locale.snJ = 0L;
      locale.snK = 0L;
      AppMethodBeat.o(33736);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33735);
    super.onPause();
    AppMethodBeat.o(33735);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    long l = 1L;
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(33740);
    paramf = paramPreference.mKey;
    if (paramf.equals("room_notify_new_msg")) {
      if (!this.fMP)
      {
        this.fMP = bool1;
        if (!this.fMP) {
          break label164;
        }
        w.s(this.contact);
        label55:
        this.contact = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.talker);
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        this.sp.edit().putBoolean("room_notify_new_msg", this.fMP).commit();
        YC();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(33740);
      return false;
      bool1 = false;
      break;
      label164:
      w.t(this.contact);
      break label55;
      if (paramf.equals("room_placed_to_the_top"))
      {
        paramf = getSharedPreferences(this.fNc, 0);
        if (this.contact != null)
        {
          if (am.ail(this.talker))
          {
            paramf = (com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class);
            paramPreference = this.contact.field_username;
            if (!((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).aig(this.talker)) {}
            for (bool1 = bool2;; bool1 = false)
            {
              paramf.be(paramPreference, bool1);
              break;
            }
          }
          ba.aBQ();
          if (com.tencent.mm.model.c.azv().aTH(this.contact.field_username)) {
            w.E(this.contact.field_username, true);
          }
          for (;;)
          {
            paramf = paramf.edit();
            ba.aBQ();
            paramf.putBoolean("room_placed_to_the_top", com.tencent.mm.model.c.azv().aTH(this.contact.field_username)).commit();
            break;
            w.D(this.contact.field_username, true);
          }
        }
      }
      else if (paramf.equals("force_notify"))
      {
        if (!this.JfG.isChecked())
        {
          ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).aJ(this.contact.field_username + "@wxcontact", 3);
          this.JfG.setSummary(null);
        }
        else
        {
          ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).ajx(this.contact.field_username);
          l = ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).ajy(this.contact.field_username);
          this.JfG.setSummary(getResources().getString(2131759597, new Object[] { new SimpleDateFormat("HH:mm").format(new Date(l)) }));
        }
      }
      else if (paramf.equals("room_set_chatting_background"))
      {
        paramf = new Intent();
        paramf.putExtra("isApplyToAll", false);
        paramf.putExtra("username", this.contact.field_username);
        com.tencent.mm.bs.d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", paramf, 2);
      }
      else if (paramf.equals("room_search_chatting_content"))
      {
        paramf = new Intent();
        paramf.putExtra("detail_username", this.talker);
        com.tencent.mm.plugin.fts.a.d.d(this, ".ui.FTSChattingConvUI", paramf);
        com.tencent.mm.plugin.report.service.g.yhR.f(14569, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      }
      else if (paramf.equals("room_clear_chatting_history"))
      {
        paramf = com.tencent.mm.plugin.finder.report.b.snk;
        paramf = com.tencent.mm.plugin.finder.report.b.cDl();
        paramf.snJ += 1L;
        ad.i(paramf.TAG, "incClearHistoryCount:" + paramf.snJ);
        paramf = getString(2131759503, new Object[] { this.contact.adv() });
        com.tencent.mm.ui.base.h.a(getContext(), paramf, "", getString(2131755694), getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(193741);
            SingleChatInfoUI.i(SingleChatInfoUI.this);
            AppMethodBeat.o(193741);
          }
        }, null, 2131099904);
      }
      else if (paramf.equals("room_expose"))
      {
        paramf = com.tencent.mm.plugin.finder.report.b.snk;
        paramf = com.tencent.mm.plugin.finder.report.b.cDl();
        paramf.snI += 1L;
        ad.i(paramf.TAG, "incCompanionCount:" + paramf.snI);
        paramf = new Intent();
        paramf.putExtra("showShare", false);
        if (am.aSV(this.talker))
        {
          ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).enterExpose(getContext(), paramf, this.talker);
        }
        else
        {
          if (am.ail(this.talker)) {
            paramf.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(61) }));
          }
          for (;;)
          {
            paramf.putExtra("k_username", this.talker);
            com.tencent.mm.bs.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
            break;
            paramf.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(39) }));
          }
        }
      }
      else if (paramf.equals("chat_app_brand"))
      {
        paramf = new Intent();
        paramf.putExtra("Chat_User", this.talker);
        com.tencent.mm.bs.d.f(this, ".ui.chatting.gallery.AppBrandHistoryListUI", paramf);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(219L, 25L, 1L, true);
      }
      else if (paramf.equals("room_accept_message"))
      {
        paramf = (CheckBoxPreference)this.screen.aVD("room_accept_message");
        if (paramf != null)
        {
          paramPreference = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).aii(this.talker);
          bool1 = paramf.isChecked();
          if (am.aSU(paramPreference))
          {
            ((com.tencent.mm.plugin.i.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.i.class)).u(bool1, this.talker);
            label1154:
            paramf = com.tencent.mm.plugin.finder.report.b.snk;
            paramf = com.tencent.mm.plugin.finder.report.b.cDl();
            if (!bool1) {
              break label1198;
            }
          }
          for (;;)
          {
            paramf.snK = l;
            break;
            ((com.tencent.mm.plugin.i.a.q)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.q.class)).v(bool1, this.talker);
            break label1154;
            label1198:
            l = 0L;
          }
        }
      }
      else if ((paramf.equals("room_add_blacklist")) && (am.aSV(this.talker)))
      {
        ((com.tencent.mm.plugin.gamelife.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.gamelife.c.class)).dealBlackList(getContext(), this.talker, this.JfI, this.JfH, new c.b()
        {
          public final void mZ(final boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(193746);
            SingleChatInfoUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(193745);
                SingleChatInfoUI.j(SingleChatInfoUI.this).value = Boolean.valueOf(paramAnonymousBoolean);
                SingleChatInfoUI.k(SingleChatInfoUI.this).edit().putBoolean("room_add_blacklist", paramAnonymousBoolean).commit();
                SingleChatInfoUI.d(SingleChatInfoUI.this).notifyDataSetChanged();
                AppMethodBeat.o(193745);
              }
            });
            AppMethodBeat.o(193746);
          }
        });
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33734);
    YC();
    if (this.fMC != null)
    {
      localObject = new LinkedList();
      ((List)localObject).add(this.talker);
      this.fMC.A(this.talker, (List)localObject);
      if (am.ail(this.talker))
      {
        this.fMC.vO(false);
        this.fMC.vP(false);
      }
      if (am.aSV(this.talker))
      {
        this.fMC.vO(false);
        this.fMC.vP(false);
      }
      this.fMC.vN(true);
    }
    boolean bool2 = am.ail(this.talker);
    Object localObject = this.screen;
    if (!bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ((com.tencent.mm.ui.base.preference.f)localObject).cP("room_accept_message", bool1);
      if (bool2)
      {
        localObject = (CheckBoxPreference)this.screen.aVD("room_accept_message");
        ((CheckBoxPreference)localObject).setTitle(2131763206);
        ((CheckBoxPreference)localObject).oB = ((com.tencent.mm.plugin.i.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.f.class)).aib(this.talker);
        ((Preference)localObject).JtB = false;
        this.screen.notifyDataSetChanged();
      }
      fxI();
      this.screen.notifyDataSetChanged();
      super.onResume();
      if (!this.fMY)
      {
        localObject = getIntent().getStringExtra("need_matte_high_light_item");
        if (!bt.isNullOrNil((String)localObject))
        {
          final int i = this.screen.aVF((String)localObject);
          setSelection(i - 3);
          new ap().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(193749);
              View localView = ((com.tencent.mm.ui.base.preference.a)SingleChatInfoUI.d(SingleChatInfoUI.this)).a(i, SingleChatInfoUI.this.getListView());
              if (localView != null) {
                com.tencent.mm.ui.h.a.c(SingleChatInfoUI.this.getContext(), localView);
              }
              AppMethodBeat.o(193749);
            }
          }, 10L);
        }
        this.fMY = true;
      }
      AppMethodBeat.o(33734);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    implements DialogInterface.OnCancelListener
  {
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(33731);
      SingleChatInfoUI.jh(true);
      AppMethodBeat.o(33731);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.SingleChatInfoUI
 * JD-Core Version:    0.7.0.1
 */