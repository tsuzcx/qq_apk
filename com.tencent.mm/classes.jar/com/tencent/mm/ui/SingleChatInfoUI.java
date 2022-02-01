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
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.a;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.finder.report.b.e;
import com.tencent.mm.plugin.finder.view.l.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.c.a;
import com.tencent.mm.plugin.gamelife.c.b;
import com.tencent.mm.plugin.i.a.p.b;
import com.tencent.mm.plugin.i.a.q;
import com.tencent.mm.plugin.i.a.r;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.protocal.protobuf.aqh;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.cg;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.contact.u;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.kernel.i
public class SingleChatInfoUI
  extends MMPreference
  implements com.tencent.mm.bh.a
{
  private static boolean isDeleteCancel = false;
  private CheckBoxPreference JAr;
  final com.tencent.mm.plugin.appbrand.y.i<Boolean> JAs;
  private com.tencent.mm.plugin.appbrand.y.i<Boolean> JAt;
  private p.b JAu;
  private k.a JAv;
  private an contact;
  private ContactListExpandPreference fOK;
  private CheckBoxPreference fOL;
  private CheckBoxPreference fON;
  private boolean fOX;
  private int fOZ;
  private boolean fPb;
  private com.tencent.mm.pluginsdk.ui.e fPf;
  boolean fPg;
  private String fPk;
  private aq handler;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  private String talker;
  
  public SingleChatInfoUI()
  {
    AppMethodBeat.i(33732);
    this.handler = new aq(Looper.getMainLooper());
    this.sp = null;
    this.JAs = new com.tencent.mm.plugin.appbrand.y.i();
    this.JAt = new com.tencent.mm.plugin.appbrand.y.i();
    this.fOZ = -1;
    this.fPb = false;
    this.JAu = null;
    this.fPf = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.JAv = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(187039);
        SingleChatInfoUI.c(SingleChatInfoUI.this);
        AppMethodBeat.o(187039);
      }
    };
    this.fPg = false;
    this.fPk = "";
    AppMethodBeat.o(33732);
  }
  
  private void YL()
  {
    AppMethodBeat.i(33742);
    if ((an.aji(this.talker)) || (an.aUv(this.talker)))
    {
      this.screen.cT(this.fOL.mKey, true);
      AppMethodBeat.o(33742);
      return;
    }
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    this.fOX = this.contact.Pd();
    if (this.fOX)
    {
      setTitleMuteIconVisibility(0);
      if (this.fOL != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(33742);
      return;
      setTitleMuteIconVisibility(8);
      if (this.fOL != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private void b(final ProgressDialog paramProgressDialog)
  {
    AppMethodBeat.i(33741);
    bl.a(this.contact.field_username, new bl.a()
    {
      public final boolean YT()
      {
        AppMethodBeat.i(187046);
        boolean bool = SingleChatInfoUI.bJu();
        AppMethodBeat.o(187046);
        return bool;
      }
      
      public final void YU()
      {
        AppMethodBeat.i(187047);
        if (paramProgressDialog != null) {
          paramProgressDialog.dismiss();
        }
        AppMethodBeat.o(187047);
      }
    });
    this.handler.post(new SingleChatInfoUI.3(this));
    AppMethodBeat.o(33741);
  }
  
  private void fBK()
  {
    int j = 0;
    AppMethodBeat.i(33739);
    this.JAr = ((CheckBoxPreference)this.screen.aXe("force_notify"));
    if ((an.aUq(this.contact.field_username)) || (v.zK(this.contact.field_username)))
    {
      this.screen.cT("force_notify", true);
      AppMethodBeat.o(33739);
      return;
    }
    long l = ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).akw(this.contact.field_username);
    boolean bool = ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).akx(this.contact.field_username);
    this.JAr.setChecked(bool);
    this.JAr.uo(bool);
    if (this.JAr.isChecked())
    {
      this.JAr.setSummary(getResources().getString(2131759597, new Object[] { new SimpleDateFormat("HH:mm").format(new Date(l)) }));
      if (this.sp == null) {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      }
      this.sp.edit().putBoolean("force_notify", this.JAr.isChecked()).commit();
      if (!this.JAr.isChecked()) {
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
      this.JAr.setSummary(null);
      if (this.contact.Pd()) {}
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
    if ((paramString1.equals(this.talker)) && (this.fOK != null)) {
      this.fOK.notifyChanged();
    }
    AppMethodBeat.o(33743);
  }
  
  protected void initView()
  {
    AppMethodBeat.i(33738);
    if (this.contact == null)
    {
      ae.e("MicroMsg.SingleChatInfoUI", "[initView] contact is null!");
      finish();
    }
    this.screen = getPreferenceScreen();
    setMMTitle(getString(2131762729));
    this.fOK = ((ContactListExpandPreference)this.screen.aXe("roominfo_contact_anchor"));
    this.fOK.a(this.screen, this.fOK.mKey);
    this.fOK.vW(true).vX(false);
    if ((this.contact != null) && (this.contact.field_deleteFlag == 1)) {
      this.fOK.vW(false);
    }
    if ((!u.fMJ()) && (this.contact != null) && (an.aUq(this.contact.field_username))) {
      this.fOK.vW(false);
    }
    this.fOL = ((CheckBoxPreference)this.screen.aXe("room_notify_new_msg"));
    this.fON = ((CheckBoxPreference)this.screen.aXe("room_placed_to_the_top"));
    Object localObject = this.screen;
    boolean bool;
    if (!com.tencent.mm.contact.c.lO(this.contact.field_type))
    {
      bool = true;
      ((com.tencent.mm.ui.base.preference.f)localObject).cT("force_notify", bool);
      if (this.sp == null) {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      }
      if (this.contact == null) {
        break label549;
      }
      if (!an.aji(this.talker)) {
        break label526;
      }
      bool = ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).ajd(this.talker);
      label299:
      this.sp.edit().putBoolean("room_placed_to_the_top", bool).commit();
      this.fOX = this.contact.Pd();
      this.sp.edit().putBoolean("room_notify_new_msg", this.fOX).commit();
    }
    for (;;)
    {
      if (an.aji(this.talker))
      {
        this.screen.cT("room_search_chatting_content", true);
        this.screen.cT("force_notify", true);
      }
      bc.aCg();
      this.fOZ = com.tencent.mm.model.c.azI().ars(this.talker);
      this.screen.notifyDataSetChanged();
      if (this.fOK != null)
      {
        localObject = new LinkedList();
        ((List)localObject).add(this.talker);
        this.fOK.B(this.talker, (List)localObject);
        getListView().setOnScrollListener(this.fPf);
        this.fOK.a(this.fPf);
        this.fOK.a(new ContactListExpandPreference.a()
        {
          public final void YS()
          {
            AppMethodBeat.i(187042);
            if (SingleChatInfoUI.e(SingleChatInfoUI.this) != null) {
              SingleChatInfoUI.e(SingleChatInfoUI.this).fgv();
            }
            AppMethodBeat.o(187042);
          }
          
          public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
          {
            AppMethodBeat.i(187041);
            Object localObject3 = SingleChatInfoUI.e(SingleChatInfoUI.this).ZD(paramAnonymousInt);
            Object localObject2 = bu.nullAsNil(SingleChatInfoUI.e(SingleChatInfoUI.this).ZF(paramAnonymousInt));
            Object localObject1 = localObject2;
            if (bu.isNullOrNil((String)localObject2))
            {
              bc.aCg();
              cg localcg = com.tencent.mm.model.c.azG().arE((String)localObject3);
              localObject1 = localObject2;
              if (localcg != null)
              {
                localObject1 = localObject2;
                if (!bu.isNullOrNil(localcg.field_encryptUsername)) {
                  localObject1 = localcg.field_conRemark;
                }
              }
            }
            if (bu.isNullOrNil((String)localObject3))
            {
              AppMethodBeat.o(187041);
              return;
            }
            if (an.aji(SingleChatInfoUI.a(SingleChatInfoUI.this)))
            {
              localObject1 = com.tencent.mm.plugin.finder.report.b.sxb;
              localObject1 = com.tencent.mm.plugin.finder.report.b.cFd();
              ((b.e)localObject1).sxu += 1L;
              ae.i(((b.e)localObject1).TAG, "incChatInfoClickCount:" + ((b.e)localObject1).sxu);
              localObject2 = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).ajf(SingleChatInfoUI.a(SingleChatInfoUI.this));
              if (an.aUu((String)localObject2))
              {
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra("finder_username", (String)localObject2);
                localObject2 = FinderReporterUIC.tnG;
                FinderReporterUIC.a.a(paramAnonymousViewGroup.getContext(), (Intent)localObject1, 0L, 10, false);
                ((t)com.tencent.mm.kernel.g.ad(t.class)).enterFinderProfileUI(paramAnonymousViewGroup.getContext(), (Intent)localObject1);
                AppMethodBeat.o(187041);
                return;
              }
              localObject1 = new Intent();
              localObject2 = ((com.tencent.mm.plugin.i.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.f.class)).aiX((String)localObject2);
              localObject3 = com.tencent.mm.plugin.finder.view.l.thN;
              l.a.a((r)localObject2, (Intent)localObject1);
              localObject2 = com.tencent.mm.plugin.finder.view.l.thN;
              l.a.X(paramAnonymousViewGroup.getContext(), (Intent)localObject1);
              AppMethodBeat.o(187041);
              return;
            }
            if (an.aUv(SingleChatInfoUI.a(SingleChatInfoUI.this)))
            {
              ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).enterGameLifeProfileUI(SingleChatInfoUI.this.getContext(), SingleChatInfoUI.a(SingleChatInfoUI.this), com.tencent.mm.plugin.gamelife.a.uHL);
              AppMethodBeat.o(187041);
              return;
            }
            paramAnonymousViewGroup = new Intent();
            paramAnonymousViewGroup.putExtra("Contact_User", (String)localObject3);
            paramAnonymousViewGroup.putExtra("Contact_RemarkName", (String)localObject1);
            paramAnonymousViewGroup.putExtra("Contact_Nick", bu.nullAsNil(SingleChatInfoUI.e(SingleChatInfoUI.this).ZE(paramAnonymousInt)));
            paramAnonymousViewGroup.putExtra("Contact_RoomMember", true);
            paramAnonymousViewGroup.putExtra("CONTACT_INFO_UI_SOURCE", 9);
            localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH((String)localObject3);
            if ((localObject1 != null) && ((int)((com.tencent.mm.contact.c)localObject1).ght > 0) && (com.tencent.mm.contact.c.lO(((aw)localObject1).field_type))) {
              com.tencent.mm.ui.contact.e.a(paramAnonymousViewGroup, (String)localObject3);
            }
            paramAnonymousViewGroup.putExtra("Kdel_from", 0);
            com.tencent.mm.br.d.b(SingleChatInfoUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousViewGroup, 0);
            AppMethodBeat.o(187041);
          }
          
          public final void le(int paramAnonymousInt) {}
          
          public final void lf(int paramAnonymousInt)
          {
            AppMethodBeat.i(187043);
            SingleChatInfoUI.f(SingleChatInfoUI.this);
            AppMethodBeat.o(187043);
          }
        });
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(187044);
          SingleChatInfoUI.this.finish();
          AppMethodBeat.o(187044);
          return true;
        }
      });
      AppMethodBeat.o(33738);
      return;
      bool = false;
      break;
      label526:
      bc.aCg();
      bool = com.tencent.mm.model.c.azL().aVi(this.contact.field_username);
      break label299;
      label549:
      this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      this.fOX = false;
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
    ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).cTd().add(this.JAv);
    if (com.tencent.mm.bh.g.ium != null) {
      com.tencent.mm.bh.g.ium.a(this);
    }
    this.talker = getIntent().getStringExtra("Single_Chat_Talker");
    this.fPb = getIntent().getBooleanExtra("fromChatting", false);
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(this.talker);
    if (this.contact == null)
    {
      ae.e("MicroMsg.SingleChatInfoUI", "contact is null! talker:%s", new Object[] { this.talker });
      finish();
      AppMethodBeat.o(33733);
      return;
    }
    this.fPk = (getPackageName() + "_preferences");
    initView();
    ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.a.class)).C(this.contact.field_username, 3, ch.aDb() / 1000L);
    Object localObject;
    String str;
    label297:
    b.e locale;
    long l;
    if (!an.aUv(this.talker))
    {
      this.screen.cT("room_add_blacklist", true);
      if (an.aji(this.talker))
      {
        this.JAu = new SingleChatInfoUI.6(this);
        paramBundle = new LinkedList();
        localObject = new aqh();
        str = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).ajf(this.talker);
        if (!an.aUu(str)) {
          break label582;
        }
        ((aqh)localObject).scene = 2;
        ((aqh)localObject).sessionId = this.talker;
        ((aqh)localObject).dsk = str;
        paramBundle.add(localObject);
        ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).a(paramBundle, this.JAu);
        this.screen.cT("room_placed_to_the_top", true);
        str = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).ajf(this.talker);
        paramBundle = com.tencent.mm.plugin.finder.report.b.sxb;
        locale = com.tencent.mm.plugin.finder.report.b.cFd();
        if (!an.aUu(str)) {
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
      locale.sxk = l;
      locale.sxq = paramBundle;
      locale.sxm = ((String)localObject);
      locale.sxo = String.valueOf(ch.aDc());
      AppMethodBeat.o(33733);
      return;
      this.screen.cT("room_search_chatting_content", true);
      this.screen.cT("room_set_chatting_background", true);
      this.screen.cT("room_placed_to_the_top", true);
      this.screen.cT("force_notify", true);
      this.screen.cT("seperate_line_between_force_notify_and_background", true);
      this.screen.cT("seperate_line_between_background_and_clear_history", true);
      ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).initGameLifeSingleChatInfoUI(getContext(), this.talker, new c.a()
      {
        public final void R(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(187035);
          SingleChatInfoUI.j(SingleChatInfoUI.this).value = Boolean.valueOf(paramAnonymousBoolean2);
          SingleChatInfoUI.this.JAs.value = Boolean.valueOf(paramAnonymousBoolean1);
          SingleChatInfoUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187034);
              if ((SingleChatInfoUI.j(SingleChatInfoUI.this) != null) && (SingleChatInfoUI.j(SingleChatInfoUI.this).value != null)) {
                SingleChatInfoUI.k(SingleChatInfoUI.this).edit().putBoolean("room_add_blacklist", ((Boolean)SingleChatInfoUI.j(SingleChatInfoUI.this).value).booleanValue()).commit();
              }
              SingleChatInfoUI.d(SingleChatInfoUI.this).notifyDataSetChanged();
              AppMethodBeat.o(187034);
            }
          });
          AppMethodBeat.o(187035);
        }
      });
      break;
      ((aqh)localObject).scene = 1;
      break label297;
      l = 2L;
      break label392;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33736);
    ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).cTd().remove(this.JAv);
    com.tencent.mm.ui.h.a.dismiss();
    if (com.tencent.mm.bh.g.ium != null) {
      com.tencent.mm.bh.g.ium.b(this);
    }
    super.onDestroy();
    Object localObject1 = FinderReporterUIC.tnG;
    if (FinderReporterUIC.a.fc(getContext()) != null)
    {
      localObject1 = FinderReporterUIC.tnG;
      FinderReporterUIC.a.fc(getContext()).fZ(0, 0);
      localObject1 = FinderReporterUIC.tnG;
    }
    for (localObject1 = FinderReporterUIC.a.fc(getContext()).cQZ();; localObject1 = null)
    {
      Object localObject2 = com.tencent.mm.plugin.finder.report.b.sxb;
      b.e locale = com.tencent.mm.plugin.finder.report.b.cFd();
      ah localah = new ah();
      if (localObject1 != null)
      {
        String str = ((arn)localObject1).sessionId;
        localObject2 = str;
        if (str == null) {
          localObject2 = "";
        }
        localah.hm((String)localObject2);
        localObject2 = ((arn)localObject1).rfo;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localah.hn((String)localObject1);
      }
      localObject2 = localah.dRJ;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localah.hm((String)localObject1);
      localObject2 = localah.dWy;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localah.hn((String)localObject1);
      localah.dWA = localah.t("chatSessionid", locale.sxo, true);
      localah.dWw = locale.sxk;
      localah.dWC = localah.t("chatName", locale.sxq, true);
      localah.dWx = localah.t("talkerUsername", locale.sxm, true);
      localah.dWP = locale.sxB;
      localah.dWG = locale.sxu;
      localah.dWQ = locale.sxA;
      localah.dWR = locale.sxz;
      localah.aLH();
      localObject1 = com.tencent.mm.plugin.finder.report.b.sxb;
      com.tencent.mm.plugin.finder.report.b.a(locale.TAG, (com.tencent.mm.plugin.report.a)localah);
      locale.sxk = 0L;
      locale.sxq = "";
      locale.sxm = "";
      locale.sxu = 0L;
      locale.sxz = 0L;
      locale.sxA = 0L;
      locale.sxB = 0L;
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
      if (!this.fOX)
      {
        this.fOX = bool1;
        if (!this.fOX) {
          break label164;
        }
        x.z(this.contact);
        label55:
        this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(this.talker);
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        this.sp.edit().putBoolean("room_notify_new_msg", this.fOX).commit();
        YL();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(33740);
      return false;
      bool1 = false;
      break;
      label164:
      x.A(this.contact);
      break label55;
      if (paramf.equals("room_placed_to_the_top"))
      {
        paramf = getSharedPreferences(this.fPk, 0);
        if (this.contact != null)
        {
          if (an.aji(this.talker))
          {
            paramf = (com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class);
            paramPreference = this.contact.field_username;
            if (!((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).ajd(this.talker)) {}
            for (bool1 = bool2;; bool1 = false)
            {
              paramf.bh(paramPreference, bool1);
              break;
            }
          }
          bc.aCg();
          if (com.tencent.mm.model.c.azL().aVi(this.contact.field_username)) {
            x.E(this.contact.field_username, true);
          }
          for (;;)
          {
            paramf = paramf.edit();
            bc.aCg();
            paramf.putBoolean("room_placed_to_the_top", com.tencent.mm.model.c.azL().aVi(this.contact.field_username)).commit();
            break;
            x.D(this.contact.field_username, true);
          }
        }
      }
      else if (paramf.equals("force_notify"))
      {
        if (!this.JAr.isChecked())
        {
          ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).aM(this.contact.field_username + "@wxcontact", 3);
          this.JAr.setSummary(null);
        }
        else
        {
          ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).akv(this.contact.field_username);
          l = ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).akw(this.contact.field_username);
          this.JAr.setSummary(getResources().getString(2131759597, new Object[] { new SimpleDateFormat("HH:mm").format(new Date(l)) }));
        }
      }
      else if (paramf.equals("room_set_chatting_background"))
      {
        paramf = new Intent();
        paramf.putExtra("isApplyToAll", false);
        paramf.putExtra("username", this.contact.field_username);
        com.tencent.mm.br.d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", paramf, 2);
      }
      else if (paramf.equals("room_search_chatting_content"))
      {
        paramf = new Intent();
        paramf.putExtra("detail_username", this.talker);
        com.tencent.mm.plugin.fts.a.d.d(this, ".ui.FTSChattingConvUI", paramf);
        com.tencent.mm.plugin.report.service.g.yxI.f(14569, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      }
      else if (paramf.equals("room_clear_chatting_history"))
      {
        paramf = com.tencent.mm.plugin.finder.report.b.sxb;
        paramf = com.tencent.mm.plugin.finder.report.b.cFd();
        paramf.sxA += 1L;
        ae.i(paramf.TAG, "incClearHistoryCount:" + paramf.sxA);
        paramf = getString(2131759503, new Object[] { this.contact.adG() });
        com.tencent.mm.ui.base.h.a(getContext(), paramf, "", getString(2131755694), getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(187032);
            SingleChatInfoUI.i(SingleChatInfoUI.this);
            AppMethodBeat.o(187032);
          }
        }, null, 2131099904);
      }
      else if (paramf.equals("room_expose"))
      {
        paramf = com.tencent.mm.plugin.finder.report.b.sxb;
        paramf = com.tencent.mm.plugin.finder.report.b.cFd();
        paramf.sxz += 1L;
        ae.i(paramf.TAG, "incCompanionCount:" + paramf.sxz);
        paramf = new Intent();
        paramf.putExtra("showShare", false);
        if (an.aUv(this.talker))
        {
          ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).enterExpose(getContext(), paramf, this.talker);
        }
        else
        {
          if (an.aji(this.talker)) {
            paramf.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(61) }));
          }
          for (;;)
          {
            paramf.putExtra("k_username", this.talker);
            com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
            break;
            paramf.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(39) }));
          }
        }
      }
      else if (paramf.equals("chat_app_brand"))
      {
        paramf = new Intent();
        paramf.putExtra("Chat_User", this.talker);
        com.tencent.mm.br.d.f(this, ".ui.chatting.gallery.AppBrandHistoryListUI", paramf);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(219L, 25L, 1L, true);
      }
      else if (paramf.equals("room_accept_message"))
      {
        paramf = (CheckBoxPreference)this.screen.aXe("room_accept_message");
        if (paramf != null)
        {
          paramPreference = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).ajf(this.talker);
          bool1 = paramf.isChecked();
          if (an.aUu(paramPreference))
          {
            ((com.tencent.mm.plugin.i.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.i.class)).v(bool1, this.talker);
            label1154:
            paramf = com.tencent.mm.plugin.finder.report.b.sxb;
            paramf = com.tencent.mm.plugin.finder.report.b.cFd();
            if (!bool1) {
              break label1198;
            }
          }
          for (;;)
          {
            paramf.sxB = l;
            break;
            ((q)com.tencent.mm.kernel.g.ab(q.class)).w(bool1, this.talker);
            break label1154;
            label1198:
            l = 0L;
          }
        }
      }
      else if ((paramf.equals("room_add_blacklist")) && (an.aUv(this.talker)))
      {
        ((com.tencent.mm.plugin.gamelife.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.gamelife.c.class)).dealBlackList(getContext(), this.talker, this.JAt, this.JAs, new c.b()
        {
          public final void nd(final boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(187037);
            SingleChatInfoUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(187036);
                SingleChatInfoUI.j(SingleChatInfoUI.this).value = Boolean.valueOf(paramAnonymousBoolean);
                SingleChatInfoUI.k(SingleChatInfoUI.this).edit().putBoolean("room_add_blacklist", paramAnonymousBoolean).commit();
                SingleChatInfoUI.d(SingleChatInfoUI.this).notifyDataSetChanged();
                AppMethodBeat.o(187036);
              }
            });
            AppMethodBeat.o(187037);
          }
        });
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33734);
    YL();
    if (this.fOK != null)
    {
      localObject = new LinkedList();
      ((List)localObject).add(this.talker);
      this.fOK.B(this.talker, (List)localObject);
      if (an.aji(this.talker))
      {
        this.fOK.vW(false);
        this.fOK.vX(false);
      }
      if (an.aUv(this.talker))
      {
        this.fOK.vW(false);
        this.fOK.vX(false);
      }
      this.fOK.vV(true);
    }
    boolean bool2 = an.aji(this.talker);
    Object localObject = this.screen;
    if (!bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ((com.tencent.mm.ui.base.preference.f)localObject).cT("room_accept_message", bool1);
      if (bool2)
      {
        localObject = (CheckBoxPreference)this.screen.aXe("room_accept_message");
        ((CheckBoxPreference)localObject).setTitle(2131763206);
        ((CheckBoxPreference)localObject).setChecked(((com.tencent.mm.plugin.i.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.f.class)).aiZ(this.talker));
        ((Preference)localObject).JOq = false;
        this.screen.notifyDataSetChanged();
      }
      fBK();
      this.screen.notifyDataSetChanged();
      super.onResume();
      if (!this.fPg)
      {
        localObject = getIntent().getStringExtra("need_matte_high_light_item");
        if (!bu.isNullOrNil((String)localObject))
        {
          final int i = this.screen.aXg((String)localObject);
          setSelection(i - 3);
          new aq().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187040);
              View localView = ((com.tencent.mm.ui.base.preference.a)SingleChatInfoUI.d(SingleChatInfoUI.this)).a(i, SingleChatInfoUI.this.getListView());
              if (localView != null) {
                com.tencent.mm.ui.h.a.c(SingleChatInfoUI.this.getContext(), localView);
              }
              AppMethodBeat.o(187040);
            }
          }, 10L);
        }
        this.fPg = true;
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
      SingleChatInfoUI.jf(true);
      AppMethodBeat.o(33731);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.SingleChatInfoUI
 * JD-Core Version:    0.7.0.1
 */