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
import com.tencent.mm.g.b.a.bi;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.d.e;
import com.tencent.mm.plugin.finder.view.n.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.c.a;
import com.tencent.mm.plugin.gamelife.c.b;
import com.tencent.mm.plugin.i.a.aa;
import com.tencent.mm.plugin.i.a.aa.b;
import com.tencent.mm.plugin.i.a.ag;
import com.tencent.mm.plugin.i.a.ah;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.plugin.i.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.protocal.protobuf.azi;
import com.tencent.mm.protocal.protobuf.azj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.contact.u;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;

@com.tencent.mm.kernel.i
public class SingleChatInfoUI
  extends MMPreference
  implements com.tencent.mm.bh.a
{
  private static boolean isDeleteCancel = false;
  private CheckBoxPreference OKW;
  final com.tencent.mm.plugin.appbrand.ac.i<Boolean> OKX;
  private com.tencent.mm.plugin.appbrand.ac.i<Boolean> OKY;
  private aa.b OKZ;
  private MStorage.IOnStorageChange OLa;
  private as contact;
  private ContactListExpandPreference gtU;
  private CheckBoxPreference gtV;
  private CheckBoxPreference gtX;
  private boolean guh;
  private int guj;
  private boolean gul;
  private com.tencent.mm.pluginsdk.ui.e gup;
  boolean guq;
  private String guu;
  private MMHandler handler;
  private f screen;
  private SharedPreferences sp;
  private String talker;
  
  public SingleChatInfoUI()
  {
    AppMethodBeat.i(33732);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.sp = null;
    this.OKX = new com.tencent.mm.plugin.appbrand.ac.i();
    this.OKY = new com.tencent.mm.plugin.appbrand.ac.i();
    this.guj = -1;
    this.gul = false;
    this.OKZ = null;
    this.gup = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.OLa = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(232723);
        SingleChatInfoUI.c(SingleChatInfoUI.this);
        AppMethodBeat.o(232723);
      }
    };
    this.guq = false;
    this.guu = "";
    AppMethodBeat.o(33732);
  }
  
  private void amy()
  {
    AppMethodBeat.i(33742);
    if ((as.avl(this.talker)) || (as.bju(this.talker)))
    {
      this.screen.jdMethod_do(this.gtV.mKey, true);
      AppMethodBeat.o(33742);
      return;
    }
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    this.guh = this.contact.Zx();
    if (this.guh)
    {
      setTitleMuteIconVisibility(0);
      if (this.gtV != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(33742);
      return;
      setTitleMuteIconVisibility(8);
      if (this.gtV != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private void b(final ProgressDialog paramProgressDialog)
  {
    AppMethodBeat.i(33741);
    bp.a(this.contact.field_username, new bp.a()
    {
      public final boolean amG()
      {
        AppMethodBeat.i(232730);
        boolean bool = SingleChatInfoUI.cgn();
        AppMethodBeat.o(232730);
        return bool;
      }
      
      public final void amH()
      {
        AppMethodBeat.i(232731);
        if (paramProgressDialog != null) {
          paramProgressDialog.dismiss();
        }
        AppMethodBeat.o(232731);
      }
    });
    this.handler.post(new SingleChatInfoUI.3(this));
    AppMethodBeat.o(33741);
  }
  
  private void gJD()
  {
    int j = 0;
    AppMethodBeat.i(33739);
    this.OKW = ((CheckBoxPreference)this.screen.bmg("force_notify"));
    if ((as.bjp(this.contact.field_username)) || (z.Im(this.contact.field_username)))
    {
      this.screen.jdMethod_do("force_notify", true);
      AppMethodBeat.o(33739);
      return;
    }
    long l = ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.forcenotify.a.b.class)).axB(this.contact.field_username);
    boolean bool = ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.forcenotify.a.b.class)).axC(this.contact.field_username);
    this.OKW.setChecked(bool);
    this.OKW.xZ(bool);
    if (this.OKW.isChecked())
    {
      this.OKW.setSummary(getResources().getString(2131760918, new Object[] { new SimpleDateFormat("HH:mm").format(new Date(l)) }));
      if (this.sp == null) {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      }
      this.sp.edit().putBoolean("force_notify", this.OKW.isChecked()).commit();
      if (!this.OKW.isChecked()) {
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
      this.OKW.setSummary(null);
      if (this.contact.Zx()) {}
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
    return 2132017253;
  }
  
  public final void h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(33743);
    if ((paramString1.equals(this.talker)) && (this.gtU != null)) {
      this.gtU.notifyChanged();
    }
    AppMethodBeat.o(33743);
  }
  
  protected void initView()
  {
    AppMethodBeat.i(33738);
    if (this.contact == null)
    {
      Log.e("MicroMsg.SingleChatInfoUI", "[initView] contact is null!");
      finish();
    }
    this.screen = getPreferenceScreen();
    setMMTitle(getString(2131764812));
    this.gtU = ((ContactListExpandPreference)this.screen.bmg("roominfo_contact_anchor"));
    this.gtU.a(this.screen, this.gtU.mKey);
    this.gtU.zU(true).zV(false);
    if ((this.contact != null) && (this.contact.field_deleteFlag == 1)) {
      this.gtU.zU(false);
    }
    if ((!u.gVd()) && (this.contact != null) && (as.bjp(this.contact.field_username))) {
      this.gtU.zU(false);
    }
    this.gtV = ((CheckBoxPreference)this.screen.bmg("room_notify_new_msg"));
    this.gtX = ((CheckBoxPreference)this.screen.bmg("room_placed_to_the_top"));
    Object localObject = this.screen;
    boolean bool;
    if (!com.tencent.mm.contact.c.oR(this.contact.field_type))
    {
      bool = true;
      ((f)localObject).jdMethod_do("force_notify", bool);
      if (this.sp == null) {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      }
      if (this.contact == null) {
        break label549;
      }
      if (!as.avl(this.talker)) {
        break label526;
      }
      bool = ((com.tencent.mm.plugin.i.a.n)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.n.class)).avg(this.talker);
      label299:
      this.sp.edit().putBoolean("room_placed_to_the_top", bool).commit();
      this.guh = this.contact.Zx();
      this.sp.edit().putBoolean("room_notify_new_msg", this.guh).commit();
    }
    for (;;)
    {
      if (as.avl(this.talker))
      {
        this.screen.jdMethod_do("room_search_chatting_content", true);
        this.screen.jdMethod_do("force_notify", true);
      }
      bg.aVF();
      this.guj = com.tencent.mm.model.c.aSQ().aEN(this.talker);
      this.screen.notifyDataSetChanged();
      if (this.gtU != null)
      {
        localObject = new LinkedList();
        ((List)localObject).add(this.talker);
        this.gtU.H(this.talker, (List)localObject);
        getListView().setOnScrollListener(this.gup);
        this.gtU.a(this.gup);
        this.gtU.a(new ContactListExpandPreference.a()
        {
          public final void amF()
          {
            AppMethodBeat.i(232726);
            if (SingleChatInfoUI.e(SingleChatInfoUI.this) != null) {
              SingleChatInfoUI.e(SingleChatInfoUI.this).gpE();
            }
            AppMethodBeat.o(232726);
          }
          
          public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
          {
            AppMethodBeat.i(232725);
            Object localObject3 = SingleChatInfoUI.e(SingleChatInfoUI.this).aio(paramAnonymousInt);
            Object localObject2 = Util.nullAsNil(SingleChatInfoUI.e(SingleChatInfoUI.this).aiq(paramAnonymousInt));
            Object localObject1 = localObject2;
            if (Util.isNullOrNil((String)localObject2))
            {
              bg.aVF();
              cn localcn = com.tencent.mm.model.c.aSO().aEZ((String)localObject3);
              localObject1 = localObject2;
              if (localcn != null)
              {
                localObject1 = localObject2;
                if (!Util.isNullOrNil(localcn.field_encryptUsername)) {
                  localObject1 = localcn.field_conRemark;
                }
              }
            }
            if (Util.isNullOrNil((String)localObject3))
            {
              AppMethodBeat.o(232725);
              return;
            }
            if (as.avl(SingleChatInfoUI.a(SingleChatInfoUI.this)))
            {
              localObject1 = com.tencent.mm.plugin.finder.report.d.vdp;
              localObject1 = com.tencent.mm.plugin.finder.report.d.dnH();
              ((d.e)localObject1).vdH += 1L;
              Log.i(((d.e)localObject1).TAG, "incChatInfoClickCount:" + ((d.e)localObject1).vdH);
              localObject2 = ((aa)com.tencent.mm.kernel.g.af(aa.class)).avi(SingleChatInfoUI.a(SingleChatInfoUI.this));
              if (as.bjt((String)localObject2))
              {
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra("finder_username", (String)localObject2);
                localObject2 = FinderReporterUIC.wzC;
                FinderReporterUIC.a.a(paramAnonymousViewGroup.getContext(), (Intent)localObject1, 0L, 10, false);
                ((aj)com.tencent.mm.kernel.g.ah(aj.class)).enterFinderProfileUI(paramAnonymousViewGroup.getContext(), (Intent)localObject1);
                AppMethodBeat.o(232725);
                return;
              }
              localObject1 = new Intent();
              localObject2 = ((m)com.tencent.mm.kernel.g.af(m.class)).ava((String)localObject2);
              localObject3 = com.tencent.mm.plugin.finder.view.n.wpY;
              n.a.a((ah)localObject2, (Intent)localObject1);
              localObject2 = com.tencent.mm.plugin.finder.view.n.wpY;
              n.a.a(paramAnonymousViewGroup.getContext(), (Intent)localObject1, null);
              AppMethodBeat.o(232725);
              return;
            }
            if (as.bju(SingleChatInfoUI.a(SingleChatInfoUI.this)))
            {
              ((PluginGameLife)com.tencent.mm.kernel.g.ah(PluginGameLife.class)).enterGameLifeProfileUI(SingleChatInfoUI.this.getContext(), SingleChatInfoUI.a(SingleChatInfoUI.this), com.tencent.mm.plugin.gamelife.a.xZX);
              AppMethodBeat.o(232725);
              return;
            }
            paramAnonymousViewGroup = new Intent();
            paramAnonymousViewGroup.putExtra("Contact_User", (String)localObject3);
            paramAnonymousViewGroup.putExtra("Contact_RemarkName", (String)localObject1);
            paramAnonymousViewGroup.putExtra("Contact_Nick", Util.nullAsNil(SingleChatInfoUI.e(SingleChatInfoUI.this).aip(paramAnonymousInt)));
            paramAnonymousViewGroup.putExtra("Contact_RoomMember", true);
            paramAnonymousViewGroup.putExtra("CONTACT_INFO_UI_SOURCE", 9);
            localObject1 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn((String)localObject3);
            if ((localObject1 != null) && ((int)((com.tencent.mm.contact.c)localObject1).gMZ > 0) && (com.tencent.mm.contact.c.oR(((ax)localObject1).field_type))) {
              com.tencent.mm.ui.contact.e.a(paramAnonymousViewGroup, (String)localObject3);
            }
            paramAnonymousViewGroup.putExtra("Kdel_from", 0);
            com.tencent.mm.br.c.b(SingleChatInfoUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousViewGroup, 0);
            AppMethodBeat.o(232725);
          }
          
          public final void og(int paramAnonymousInt) {}
          
          public final void oh(int paramAnonymousInt)
          {
            AppMethodBeat.i(232727);
            SingleChatInfoUI.f(SingleChatInfoUI.this);
            AppMethodBeat.o(232727);
          }
        });
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(232728);
          SingleChatInfoUI.this.finish();
          AppMethodBeat.o(232728);
          return true;
        }
      });
      AppMethodBeat.o(33738);
      return;
      bool = false;
      break;
      label526:
      bg.aVF();
      bool = com.tencent.mm.model.c.aST().bkg(this.contact.field_username);
      break label299;
      label549:
      this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      this.guh = false;
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
    ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.forcenotify.a.b.class)).dMm().add(this.OLa);
    if (com.tencent.mm.bh.g.jpy != null) {
      com.tencent.mm.bh.g.jpy.a(this);
    }
    this.talker = getIntent().getStringExtra("Single_Chat_Talker");
    this.gul = getIntent().getBooleanExtra("fromChatting", false);
    this.contact = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(this.talker);
    if (this.contact == null)
    {
      Log.e("MicroMsg.SingleChatInfoUI", "contact is null! talker:%s", new Object[] { this.talker });
      finish();
      AppMethodBeat.o(33733);
      return;
    }
    this.guu = (getPackageName() + "_preferences");
    initView();
    ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.forcenotify.a.a.class)).B(this.contact.field_username, 3, cl.aWz() / 1000L);
    Object localObject;
    String str;
    label297:
    d.e locale;
    long l;
    if (!as.bju(this.talker))
    {
      this.screen.jdMethod_do("room_add_blacklist", true);
      if (as.avl(this.talker))
      {
        this.OKZ = new aa.b()
        {
          public final void er(List<azj> paramAnonymousList)
          {
            AppMethodBeat.i(232722);
            Log.i("MicroMsg.SingleChatInfoUI", "sessionInfos size :" + paramAnonymousList.size());
            Object localObject;
            if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty()))
            {
              localObject = paramAnonymousList.iterator();
              do
              {
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                paramAnonymousList = (azj)((Iterator)localObject).next();
              } while (!paramAnonymousList.sessionId.equals(SingleChatInfoUI.a(SingleChatInfoUI.this)));
            }
            for (;;)
            {
              if (paramAnonymousList != null)
              {
                Log.i("MicroMsg.SingleChatInfoUI", "sessionId: " + paramAnonymousList.sessionId + ", sessionReject: " + paramAnonymousList.LJe);
                localObject = SingleChatInfoUI.this;
                if (paramAnonymousList.LJe != 1) {
                  break label161;
                }
              }
              label161:
              for (boolean bool = true;; bool = false)
              {
                SingleChatInfoUI.a((SingleChatInfoUI)localObject, bool);
                SingleChatInfoUI.b(SingleChatInfoUI.this);
                AppMethodBeat.o(232722);
                return;
              }
              paramAnonymousList = null;
            }
          }
        };
        paramBundle = new LinkedList();
        localObject = new azi();
        str = ((aa)com.tencent.mm.kernel.g.af(aa.class)).avi(this.talker);
        if (!as.bjt(str)) {
          break label582;
        }
        ((azi)localObject).scene = 2;
        ((azi)localObject).sessionId = this.talker;
        ((azi)localObject).dJw = str;
        paramBundle.add(localObject);
        ((aa)com.tencent.mm.kernel.g.af(aa.class)).a(paramBundle, this.OKZ);
        this.screen.jdMethod_do("room_placed_to_the_top", true);
        str = ((aa)com.tencent.mm.kernel.g.af(aa.class)).avi(this.talker);
        paramBundle = com.tencent.mm.plugin.finder.report.d.vdp;
        locale = com.tencent.mm.plugin.finder.report.d.dnH();
        if (!as.bjt(str)) {
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
      p.h(paramBundle, "chatName");
      p.h(localObject, "talkUserName");
      locale.vdx = l;
      locale.vdD = paramBundle;
      locale.vdz = ((String)localObject);
      locale.vdB = String.valueOf(cl.aWA());
      AppMethodBeat.o(33733);
      return;
      this.screen.jdMethod_do("room_search_chatting_content", true);
      this.screen.jdMethod_do("room_set_chatting_background", true);
      this.screen.jdMethod_do("room_placed_to_the_top", true);
      this.screen.jdMethod_do("force_notify", true);
      this.screen.jdMethod_do("seperate_line_between_force_notify_and_background", true);
      this.screen.jdMethod_do("seperate_line_between_background_and_clear_history", true);
      ((PluginGameLife)com.tencent.mm.kernel.g.ah(PluginGameLife.class)).initGameLifeSingleChatInfoUI(getContext(), this.talker, new c.a()
      {
        public final void U(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(232719);
          SingleChatInfoUI.j(SingleChatInfoUI.this).value = Boolean.valueOf(paramAnonymousBoolean2);
          SingleChatInfoUI.this.OKX.value = Boolean.valueOf(paramAnonymousBoolean1);
          SingleChatInfoUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(232718);
              if ((SingleChatInfoUI.j(SingleChatInfoUI.this) != null) && (SingleChatInfoUI.j(SingleChatInfoUI.this).value != null)) {
                SingleChatInfoUI.k(SingleChatInfoUI.this).edit().putBoolean("room_add_blacklist", ((Boolean)SingleChatInfoUI.j(SingleChatInfoUI.this).value).booleanValue()).commit();
              }
              SingleChatInfoUI.d(SingleChatInfoUI.this).notifyDataSetChanged();
              AppMethodBeat.o(232718);
            }
          });
          AppMethodBeat.o(232719);
        }
      });
      break;
      ((azi)localObject).scene = 1;
      break label297;
      l = 2L;
      break label392;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33736);
    ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.forcenotify.a.b.class)).dMm().remove(this.OLa);
    com.tencent.mm.ui.i.a.dismiss();
    if (com.tencent.mm.bh.g.jpy != null) {
      com.tencent.mm.bh.g.jpy.b(this);
    }
    super.onDestroy();
    Object localObject1 = FinderReporterUIC.wzC;
    if (FinderReporterUIC.a.fH(getContext()) != null)
    {
      localObject1 = FinderReporterUIC.wzC;
      FinderReporterUIC.a.fH(getContext()).gv(0, 0);
      localObject1 = FinderReporterUIC.wzC;
    }
    for (localObject1 = FinderReporterUIC.a.fH(getContext()).dIx();; localObject1 = null)
    {
      Object localObject2 = com.tencent.mm.plugin.finder.report.d.vdp;
      d.e locale = com.tencent.mm.plugin.finder.report.d.dnH();
      bi localbi = new bi();
      if (localObject1 != null)
      {
        String str = ((bbn)localObject1).sessionId;
        localObject2 = str;
        if (str == null) {
          localObject2 = "";
        }
        localbi.jh((String)localObject2);
        localObject2 = ((bbn)localObject1).sGE;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localbi.ji((String)localObject1);
      }
      localObject2 = localbi.els;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localbi.jh((String)localObject1);
      localObject2 = localbi.esd;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localbi.ji((String)localObject1);
      localbi.esf = localbi.x("chatSessionid", locale.vdB, true);
      localbi.esb = locale.vdx;
      localbi.esh = localbi.x("chatName", locale.vdD, true);
      localbi.esc = localbi.x("talkerUsername", locale.vdz, true);
      localbi.esu = locale.vdN;
      localbi.esl = locale.vdH;
      localbi.esv = locale.vdM;
      localbi.esw = locale.vdL;
      localbi.bfK();
      localObject1 = com.tencent.mm.plugin.finder.report.d.vdp;
      com.tencent.mm.plugin.finder.report.d.a(locale.TAG, (com.tencent.mm.plugin.report.a)localbi);
      locale.vdx = 0L;
      locale.vdD = "";
      locale.vdz = "";
      locale.vdH = 0L;
      locale.vdL = 0L;
      locale.vdM = 0L;
      locale.vdN = 0L;
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
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    long l = 1L;
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(33740);
    paramf = paramPreference.mKey;
    if (paramf.equals("room_notify_new_msg")) {
      if (!this.guh)
      {
        this.guh = bool1;
        if (!this.guh) {
          break label164;
        }
        ab.z(this.contact);
        label55:
        this.contact = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(this.talker);
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        this.sp.edit().putBoolean("room_notify_new_msg", this.guh).commit();
        amy();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(33740);
      return false;
      bool1 = false;
      break;
      label164:
      ab.A(this.contact);
      break label55;
      if (paramf.equals("room_placed_to_the_top"))
      {
        paramf = getSharedPreferences(this.guu, 0);
        if (this.contact != null)
        {
          if (as.avl(this.talker))
          {
            paramf = (com.tencent.mm.plugin.i.a.n)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.n.class);
            paramPreference = this.contact.field_username;
            if (!((com.tencent.mm.plugin.i.a.n)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.n.class)).avg(this.talker)) {}
            for (bool1 = bool2;; bool1 = false)
            {
              paramf.bt(paramPreference, bool1);
              break;
            }
          }
          bg.aVF();
          if (com.tencent.mm.model.c.aST().bkg(this.contact.field_username)) {
            ab.F(this.contact.field_username, true);
          }
          for (;;)
          {
            paramf = paramf.edit();
            bg.aVF();
            paramf.putBoolean("room_placed_to_the_top", com.tencent.mm.model.c.aST().bkg(this.contact.field_username)).commit();
            break;
            ab.E(this.contact.field_username, true);
          }
        }
      }
      else if (paramf.equals("force_notify"))
      {
        if (!this.OKW.isChecked())
        {
          ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.forcenotify.a.b.class)).aS(this.contact.field_username + "@wxcontact", 3);
          this.OKW.setSummary(null);
        }
        else
        {
          ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.forcenotify.a.b.class)).axA(this.contact.field_username);
          l = ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.forcenotify.a.b.class)).axB(this.contact.field_username);
          this.OKW.setSummary(getResources().getString(2131760918, new Object[] { new SimpleDateFormat("HH:mm").format(new Date(l)) }));
        }
      }
      else if (paramf.equals("room_set_chatting_background"))
      {
        paramf = new Intent();
        paramf.putExtra("isApplyToAll", false);
        paramf.putExtra("username", this.contact.field_username);
        com.tencent.mm.br.c.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", paramf, 2);
      }
      else if (paramf.equals("room_search_chatting_content"))
      {
        paramf = new Intent();
        paramf.putExtra("detail_username", this.talker);
        com.tencent.mm.plugin.fts.a.d.d(this, ".ui.FTSChattingConvUI", paramf);
        com.tencent.mm.plugin.report.service.h.CyF.a(14569, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      }
      else if (paramf.equals("room_clear_chatting_history"))
      {
        paramf = com.tencent.mm.plugin.finder.report.d.vdp;
        paramf = com.tencent.mm.plugin.finder.report.d.dnH();
        paramf.vdM += 1L;
        Log.i(paramf.TAG, "incClearHistoryCount:" + paramf.vdM);
        paramf = getString(2131760818, new Object[] { this.contact.arJ() });
        com.tencent.mm.ui.base.h.a(getContext(), paramf, "", getString(2131755764), getString(2131755761), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(232716);
            SingleChatInfoUI.i(SingleChatInfoUI.this);
            AppMethodBeat.o(232716);
          }
        }, null, 2131099922);
      }
      else if (paramf.equals("room_expose"))
      {
        paramf = com.tencent.mm.plugin.finder.report.d.vdp;
        paramf = com.tencent.mm.plugin.finder.report.d.dnH();
        paramf.vdL += 1L;
        Log.i(paramf.TAG, "incCompanionCount:" + paramf.vdL);
        paramf = new Intent();
        paramf.putExtra("showShare", false);
        if (as.bju(this.talker))
        {
          ((PluginGameLife)com.tencent.mm.kernel.g.ah(PluginGameLife.class)).enterExpose(getContext(), paramf, this.talker);
        }
        else
        {
          if (as.avl(this.talker)) {
            paramf.putExtra("rawUrl", String.format(e.e.OyU, new Object[] { Integer.valueOf(61) }));
          }
          for (;;)
          {
            paramf.putExtra("k_username", this.talker);
            com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", paramf);
            break;
            paramf.putExtra("rawUrl", String.format(e.e.OyU, new Object[] { Integer.valueOf(39) }));
          }
        }
      }
      else if (paramf.equals("chat_app_brand"))
      {
        paramf = new Intent();
        paramf.putExtra("Chat_User", this.talker);
        com.tencent.mm.br.c.f(this, ".ui.chatting.gallery.AppBrandHistoryListUI", paramf);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(219L, 25L, 1L, true);
      }
      else if (paramf.equals("room_accept_message"))
      {
        paramf = (CheckBoxPreference)this.screen.bmg("room_accept_message");
        if (paramf != null)
        {
          paramPreference = ((aa)com.tencent.mm.kernel.g.af(aa.class)).avi(this.talker);
          bool1 = paramf.isChecked();
          if (as.bjt(paramPreference))
          {
            ((q)com.tencent.mm.kernel.g.af(q.class)).v(bool1, this.talker);
            label1154:
            paramf = com.tencent.mm.plugin.finder.report.d.vdp;
            paramf = com.tencent.mm.plugin.finder.report.d.dnH();
            if (!bool1) {
              break label1198;
            }
          }
          for (;;)
          {
            paramf.vdN = l;
            break;
            ((ag)com.tencent.mm.kernel.g.af(ag.class)).w(bool1, this.talker);
            break label1154;
            label1198:
            l = 0L;
          }
        }
      }
      else if ((paramf.equals("room_add_blacklist")) && (as.bju(this.talker)))
      {
        ((com.tencent.mm.plugin.gamelife.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.gamelife.c.class)).dealBlackList(getContext(), this.talker, this.OKY, this.OKX, new c.b()
        {
          public final void mM(final boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(232721);
            SingleChatInfoUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(232720);
                SingleChatInfoUI.j(SingleChatInfoUI.this).value = Boolean.valueOf(paramAnonymousBoolean);
                SingleChatInfoUI.k(SingleChatInfoUI.this).edit().putBoolean("room_add_blacklist", paramAnonymousBoolean).commit();
                SingleChatInfoUI.d(SingleChatInfoUI.this).notifyDataSetChanged();
                AppMethodBeat.o(232720);
              }
            });
            AppMethodBeat.o(232721);
          }
        });
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33734);
    amy();
    if (this.gtU != null)
    {
      localObject = new LinkedList();
      ((List)localObject).add(this.talker);
      this.gtU.H(this.talker, (List)localObject);
      if (as.avl(this.talker))
      {
        this.gtU.zU(false);
        this.gtU.zV(false);
      }
      if (as.bju(this.talker))
      {
        this.gtU.zU(false);
        this.gtU.zV(false);
      }
      this.gtU.zT(true);
    }
    boolean bool2 = as.avl(this.talker);
    Object localObject = this.screen;
    if (!bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ((f)localObject).jdMethod_do("room_accept_message", bool1);
      if (bool2)
      {
        localObject = (CheckBoxPreference)this.screen.bmg("room_accept_message");
        ((CheckBoxPreference)localObject).setTitle(2131757225);
        ((CheckBoxPreference)localObject).setChecked(((m)com.tencent.mm.kernel.g.af(m.class)).avc(this.talker));
        ((Preference)localObject).OZw = false;
        this.screen.notifyDataSetChanged();
      }
      gJD();
      this.screen.notifyDataSetChanged();
      super.onResume();
      if (!this.guq)
      {
        localObject = getIntent().getStringExtra("need_matte_high_light_item");
        if (!Util.isNullOrNil((String)localObject))
        {
          final int i = this.screen.bmj((String)localObject);
          setSelection(i - 3);
          new MMHandler().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(232724);
              View localView = ((com.tencent.mm.ui.base.preference.a)SingleChatInfoUI.d(SingleChatInfoUI.this)).a(i, SingleChatInfoUI.this.getListView());
              if (localView != null) {
                com.tencent.mm.ui.i.a.c(SingleChatInfoUI.this.getContext(), localView);
              }
              AppMethodBeat.o(232724);
            }
          }, 10L);
        }
        this.guq = true;
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
      SingleChatInfoUI.ke(true);
      AppMethodBeat.o(33731);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.SingleChatInfoUI
 * JD-Core Version:    0.7.0.1
 */