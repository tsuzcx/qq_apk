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
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.bj.g;
import com.tencent.mm.f.b.a.by;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.k;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.d.e;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.a.ab.b;
import com.tencent.mm.plugin.findersdk.a.ah;
import com.tencent.mm.plugin.findersdk.a.m;
import com.tencent.mm.plugin.findersdk.a.t;
import com.tencent.mm.plugin.forcenotify.f.a.a;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.c.a;
import com.tencent.mm.plugin.gamelife.c.b;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.protocal.protobuf.bfe;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.contact.w;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;

@k
public class SingleChatInfoUI
  extends MMPreference
  implements com.tencent.mm.bj.a
{
  private static boolean isDeleteCancel = false;
  private CheckBoxPreference Wev;
  final com.tencent.mm.plugin.appbrand.ac.i<Boolean> Wew;
  private com.tencent.mm.plugin.appbrand.ac.i<Boolean> Wex;
  private ab.b Wey;
  private MStorage.IOnStorageChange Wez;
  private as contact;
  private MMHandler handler;
  private e iYA;
  boolean iYB;
  private String iYF;
  private ContactListExpandPreference iYf;
  private CheckBoxPreference iYg;
  private CheckBoxPreference iYi;
  private boolean iYs;
  private int iYu;
  private boolean iYw;
  private f screen;
  private SharedPreferences sp;
  private String talker;
  
  public SingleChatInfoUI()
  {
    AppMethodBeat.i(33732);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.sp = null;
    this.Wew = new com.tencent.mm.plugin.appbrand.ac.i();
    this.Wex = new com.tencent.mm.plugin.appbrand.ac.i();
    this.iYu = -1;
    this.iYw = false;
    this.Wey = null;
    this.iYA = new e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.Wez = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(278759);
        SingleChatInfoUI.c(SingleChatInfoUI.this);
        AppMethodBeat.o(278759);
      }
    };
    this.iYB = false;
    this.iYF = "";
    AppMethodBeat.o(33732);
  }
  
  private void asz()
  {
    AppMethodBeat.i(33742);
    if ((as.aEF(this.talker)) || (as.bvQ(this.talker)))
    {
      this.screen.dz(this.iYg.mKey, true);
      AppMethodBeat.o(33742);
      return;
    }
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    this.iYs = this.contact.aeg();
    if (this.iYs)
    {
      setTitleMuteIconVisibility(0);
      if (this.iYg != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(33742);
      return;
      setTitleMuteIconVisibility(8);
      if (this.iYg != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private void b(final ProgressDialog paramProgressDialog)
  {
    AppMethodBeat.i(33741);
    bq.a(this.contact.field_username, new bq.a()
    {
      public final boolean asH()
      {
        AppMethodBeat.i(286247);
        boolean bool = SingleChatInfoUI.cgj();
        AppMethodBeat.o(286247);
        return bool;
      }
      
      public final void asI()
      {
        AppMethodBeat.i(286248);
        if (paramProgressDialog != null) {
          paramProgressDialog.dismiss();
        }
        AppMethodBeat.o(286248);
      }
    });
    this.handler.post(new SingleChatInfoUI.4(this));
    AppMethodBeat.o(33741);
  }
  
  private void hIA()
  {
    AppMethodBeat.i(33739);
    this.Wev = ((CheckBoxPreference)this.screen.byG("force_notify"));
    if ((as.bvK(this.contact.field_username)) || (z.PD(this.contact.field_username)))
    {
      this.screen.dz("force_notify", true);
      AppMethodBeat.o(33739);
      return;
    }
    long l = ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.forcenotify.a.b.class)).aHr(this.contact.field_username);
    boolean bool = ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.forcenotify.a.b.class)).aHo(this.contact.field_username);
    this.Wev.setChecked(bool);
    this.Wev.BT(bool);
    if (this.Wev.isChecked())
    {
      this.Wev.aF(getResources().getString(R.l.force_notify_on_tip, new Object[] { new SimpleDateFormat("HH:mm").format(new Date(l)) }));
      if (this.sp == null) {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      }
      this.sp.edit().putBoolean("force_notify", this.Wev.isChecked()).commit();
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(33739);
      return;
    }
    this.Wev.aF(null);
    if (this.contact.aeg()) {}
    for (int i = 0;; i = 8)
    {
      setTitleMuteIconVisibility(i);
      break;
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
    return R.o.eXM;
  }
  
  public final void h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(33743);
    if ((paramString1.equals(this.talker)) && (this.iYf != null)) {
      this.iYf.notifyChanged();
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
    setMMTitle(getString(R.l.eRt));
    this.iYf = ((ContactListExpandPreference)this.screen.byG("roominfo_contact_anchor"));
    this.iYf.a(this.screen, this.iYf.mKey);
    this.iYf.DZ(true).Ea(false);
    if ((this.contact != null) && (this.contact.field_deleteFlag == 1)) {
      this.iYf.DZ(false);
    }
    if ((!w.hVj()) && (this.contact != null) && (as.bvK(this.contact.field_username))) {
      this.iYf.DZ(false);
    }
    this.iYg = ((CheckBoxPreference)this.screen.byG("room_notify_new_msg"));
    this.iYi = ((CheckBoxPreference)this.screen.byG("room_placed_to_the_top"));
    Object localObject = this.screen;
    boolean bool;
    if (!com.tencent.mm.contact.d.rk(this.contact.field_type))
    {
      bool = true;
      ((f)localObject).dz("force_notify", bool);
      if (this.sp == null) {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      }
      if (this.contact == null) {
        break label549;
      }
      if (!as.aEF(this.talker)) {
        break label526;
      }
      bool = ((com.tencent.mm.plugin.findersdk.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.findersdk.a.n.class)).aEA(this.talker);
      label299:
      this.sp.edit().putBoolean("room_placed_to_the_top", bool).commit();
      this.iYs = this.contact.aeg();
      this.sp.edit().putBoolean("room_notify_new_msg", this.iYs).commit();
    }
    for (;;)
    {
      if (as.aEF(this.talker))
      {
        this.screen.dz("room_search_chatting_content", true);
        this.screen.dz("force_notify", true);
      }
      bh.beI();
      this.iYu = com.tencent.mm.model.c.bbO().aOX(this.talker);
      this.screen.notifyDataSetChanged();
      if (this.iYf != null)
      {
        localObject = new LinkedList();
        ((List)localObject).add(this.talker);
        this.iYf.s(this.talker, (List)localObject);
        getListView().setOnScrollListener(this.iYA);
        this.iYf.a(this.iYA);
        this.iYf.a(new SingleChatInfoUI.10(this));
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(271938);
          SingleChatInfoUI.this.finish();
          AppMethodBeat.o(271938);
          return true;
        }
      });
      AppMethodBeat.o(33738);
      return;
      bool = false;
      break;
      label526:
      bh.beI();
      bool = com.tencent.mm.model.c.bbR().bwF(this.contact.field_username);
      break label299;
      label549:
      this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      this.iYs = false;
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
    ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.forcenotify.a.b.class)).eqe().add(this.Wez);
    if (g.meT != null) {
      g.meT.a(this);
    }
    this.talker = getIntent().getStringExtra("Single_Chat_Talker");
    this.iYw = getIntent().getBooleanExtra("fromChatting", false);
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.talker);
    if (this.contact == null)
    {
      Log.e("MicroMsg.SingleChatInfoUI", "contact is null! talker:%s", new Object[] { this.talker });
      finish();
      AppMethodBeat.o(33733);
      return;
    }
    this.iYF = (getPackageName() + "_preferences");
    initView();
    ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.forcenotify.a.a.class)).C(this.contact.field_username, 3, cm.bfD() / 1000L);
    Object localObject;
    String str;
    label297:
    d.e locale;
    long l;
    if (!as.bvQ(this.talker))
    {
      this.screen.dz("room_add_blacklist", true);
      if (as.aEF(this.talker))
      {
        this.Wey = new SingleChatInfoUI.7(this);
        paramBundle = new LinkedList();
        localObject = new bfe();
        str = ((com.tencent.mm.plugin.findersdk.a.ab)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.findersdk.a.ab.class)).aED(this.talker);
        if (!as.bvP(str)) {
          break label582;
        }
        ((bfe)localObject).SFD = 2;
        ((bfe)localObject).sessionId = this.talker;
        ((bfe)localObject).fCl = str;
        paramBundle.add(localObject);
        ((com.tencent.mm.plugin.findersdk.a.ab)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.findersdk.a.ab.class)).a(paramBundle, this.Wey);
        this.screen.dz("room_placed_to_the_top", true);
        str = ((com.tencent.mm.plugin.findersdk.a.ab)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.findersdk.a.ab.class)).aED(this.talker);
        paramBundle = com.tencent.mm.plugin.finder.report.d.zUg;
        locale = com.tencent.mm.plugin.finder.report.d.dPe();
        if (!as.bvP(str)) {
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
      p.k(paramBundle, "chatName");
      p.k(localObject, "talkUserName");
      locale.zUo = l;
      locale.zUu = paramBundle;
      locale.zUq = ((String)localObject);
      locale.zUs = String.valueOf(cm.bfE());
      AppMethodBeat.o(33733);
      return;
      this.screen.dz("room_search_chatting_content", true);
      this.screen.dz("room_set_chatting_background", true);
      this.screen.dz("room_placed_to_the_top", true);
      this.screen.dz("force_notify", true);
      this.screen.dz("seperate_line_between_force_notify_and_background", true);
      this.screen.dz("seperate_line_between_background_and_clear_history", true);
      ((PluginGameLife)com.tencent.mm.kernel.h.ag(PluginGameLife.class)).initGameLifeSingleChatInfoUI(getContext(), this.talker, new c.a()
      {
        public final void ac(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(292358);
          SingleChatInfoUI.k(SingleChatInfoUI.this).value = Boolean.valueOf(paramAnonymousBoolean2);
          SingleChatInfoUI.this.Wew.value = Boolean.valueOf(paramAnonymousBoolean1);
          SingleChatInfoUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(279463);
              if ((SingleChatInfoUI.k(SingleChatInfoUI.this) != null) && (SingleChatInfoUI.k(SingleChatInfoUI.this).value != null)) {
                SingleChatInfoUI.l(SingleChatInfoUI.this).edit().putBoolean("room_add_blacklist", ((Boolean)SingleChatInfoUI.k(SingleChatInfoUI.this).value).booleanValue()).commit();
              }
              SingleChatInfoUI.d(SingleChatInfoUI.this).notifyDataSetChanged();
              AppMethodBeat.o(279463);
            }
          });
          AppMethodBeat.o(292358);
        }
      });
      break;
      ((bfe)localObject).SFD = 1;
      break label297;
      l = 2L;
      break label392;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33736);
    ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.forcenotify.a.b.class)).eqe().remove(this.Wez);
    com.tencent.mm.ui.j.a.dismiss();
    if (g.meT != null) {
      g.meT.b(this);
    }
    super.onDestroy();
    Object localObject1 = aj.Bnu;
    if (aj.a.fZ(getContext()) != null)
    {
      localObject1 = aj.Bnu;
      aj.a.fZ(getContext()).hm(0, 0);
      localObject1 = aj.Bnu;
    }
    for (localObject1 = aj.a.fZ(getContext()).ekY();; localObject1 = null)
    {
      Object localObject2 = com.tencent.mm.plugin.finder.report.d.zUg;
      d.e locale = com.tencent.mm.plugin.finder.report.d.dPe();
      by localby = new by();
      if (localObject1 != null)
      {
        String str = ((bid)localObject1).sessionId;
        localObject2 = str;
        if (str == null) {
          localObject2 = "";
        }
        localby.lr((String)localObject2);
        localObject2 = ((bid)localObject1).wmz;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localby.ls((String)localObject1);
      }
      localObject2 = localby.ggA;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localby.lr((String)localObject1);
      localObject2 = localby.goj;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localby.ls((String)localObject1);
      localby.gol = localby.z("chatSessionid", locale.zUs, true);
      localby.goh = locale.zUo;
      localby.gon = localby.z("chatName", locale.zUu, true);
      localby.goi = localby.z("talkerUsername", locale.zUq, true);
      localby.goB = locale.zUD;
      localby.gos = locale.zUy;
      localby.goC = locale.zUC;
      localby.goD = locale.zUB;
      localby.bpa();
      localObject1 = com.tencent.mm.plugin.finder.report.d.zUg;
      com.tencent.mm.plugin.finder.report.d.a(locale.TAG, (com.tencent.mm.plugin.report.a)localby);
      locale.zUo = 0L;
      locale.zUu = "";
      locale.zUq = "";
      locale.zUy = 0L;
      locale.zUB = 0L;
      locale.zUC = 0L;
      locale.zUD = 0L;
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
      if (!this.iYs)
      {
        this.iYs = bool1;
        if (!this.iYs) {
          break label164;
        }
        com.tencent.mm.model.ab.F(this.contact);
        label55:
        this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.talker);
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        this.sp.edit().putBoolean("room_notify_new_msg", this.iYs).commit();
        asz();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(33740);
      return false;
      bool1 = false;
      break;
      label164:
      com.tencent.mm.model.ab.G(this.contact);
      break label55;
      if (paramf.equals("room_placed_to_the_top"))
      {
        paramf = getSharedPreferences(this.iYF, 0);
        if (this.contact != null)
        {
          if (as.aEF(this.talker))
          {
            paramf = (com.tencent.mm.plugin.findersdk.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.findersdk.a.n.class);
            paramPreference = this.contact.field_username;
            if (!((com.tencent.mm.plugin.findersdk.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.findersdk.a.n.class)).aEA(this.talker)) {}
            for (bool1 = bool2;; bool1 = false)
            {
              paramf.by(paramPreference, bool1);
              break;
            }
          }
          bh.beI();
          if (com.tencent.mm.model.c.bbR().bwF(this.contact.field_username)) {
            com.tencent.mm.model.ab.H(this.contact.field_username, true);
          }
          for (;;)
          {
            paramf = paramf.edit();
            bh.beI();
            paramf.putBoolean("room_placed_to_the_top", com.tencent.mm.model.c.bbR().bwF(this.contact.field_username)).commit();
            break;
            com.tencent.mm.model.ab.G(this.contact.field_username, true);
          }
        }
      }
      else if (paramf.equals("force_notify"))
      {
        if (!this.Wev.isChecked())
        {
          ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.forcenotify.a.b.class)).bk(this.contact.field_username + "@wxcontact", 3);
          this.Wev.aF(null);
        }
        else
        {
          paramf = com.tencent.mm.plugin.forcenotify.f.a.BFf;
          com.tencent.mm.plugin.forcenotify.f.a.a(getContext(), 1, new a.a()
          {
            public final void ep(boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(224310);
              if (paramAnonymousBoolean)
              {
                ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.forcenotify.a.b.class)).aHn(SingleChatInfoUI.g(SingleChatInfoUI.this).field_username);
                long l = ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.forcenotify.a.b.class)).aHr(SingleChatInfoUI.g(SingleChatInfoUI.this).field_username);
                SingleChatInfoUI.h(SingleChatInfoUI.this).aF(SingleChatInfoUI.this.getResources().getString(R.l.force_notify_on_tip, new Object[] { new SimpleDateFormat("HH:mm").format(new Date(l)) }));
                AppMethodBeat.o(224310);
                return;
              }
              SingleChatInfoUI.h(SingleChatInfoUI.this).BT(false);
              AppMethodBeat.o(224310);
            }
          });
        }
      }
      else if (paramf.equals("room_set_chatting_background"))
      {
        paramf = new Intent();
        paramf.putExtra("isApplyToAll", false);
        paramf.putExtra("username", this.contact.field_username);
        com.tencent.mm.by.c.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", paramf, 2);
      }
      else if (paramf.equals("room_search_chatting_content"))
      {
        paramf = new Intent();
        paramf.putExtra("detail_username", this.talker);
        com.tencent.mm.plugin.fts.a.d.d(this, ".ui.FTSChattingConvUI", paramf);
        com.tencent.mm.plugin.report.service.h.IzE.a(14569, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      }
      else if (paramf.equals("room_clear_chatting_history"))
      {
        paramf = com.tencent.mm.plugin.finder.report.d.zUg;
        paramf = com.tencent.mm.plugin.finder.report.d.dPe();
        paramf.zUC += 1L;
        Log.i(paramf.TAG, "incClearHistoryCount:" + paramf.zUC);
        paramf = getString(R.l.eFx, new Object[] { this.contact.ays() });
        com.tencent.mm.ui.base.h.a(getContext(), paramf, "", getString(R.l.app_clear), getString(R.l.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(278719);
            SingleChatInfoUI.j(SingleChatInfoUI.this);
            AppMethodBeat.o(278719);
          }
        }, null, R.e.alert_btn_color_warn);
      }
      else if (paramf.equals("room_expose"))
      {
        paramf = com.tencent.mm.plugin.finder.report.d.zUg;
        paramf = com.tencent.mm.plugin.finder.report.d.dPe();
        paramf.zUB += 1L;
        Log.i(paramf.TAG, "incCompanionCount:" + paramf.zUB);
        paramf = new Intent();
        paramf.putExtra("showShare", false);
        if (as.bvQ(this.talker))
        {
          ((PluginGameLife)com.tencent.mm.kernel.h.ag(PluginGameLife.class)).enterExpose(getContext(), paramf, this.talker);
        }
        else
        {
          if (as.aEF(this.talker)) {
            paramf.putExtra("rawUrl", String.format(f.e.VRX, new Object[] { Integer.valueOf(61) }));
          }
          for (;;)
          {
            paramf.putExtra("k_username", this.talker);
            com.tencent.mm.by.c.b(this, "webview", ".ui.tools.WebViewUI", paramf);
            break;
            paramf.putExtra("rawUrl", String.format(f.e.VRX, new Object[] { Integer.valueOf(39) }));
          }
        }
      }
      else if (paramf.equals("chat_app_brand"))
      {
        paramf = new Intent();
        paramf.putExtra("Chat_User", this.talker);
        com.tencent.mm.by.c.f(this, ".ui.chatting.gallery.AppBrandHistoryListUI", paramf);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(219L, 25L, 1L, true);
      }
      else if (paramf.equals("room_accept_message"))
      {
        paramf = (CheckBoxPreference)this.screen.byG("room_accept_message");
        if (paramf != null)
        {
          paramPreference = ((com.tencent.mm.plugin.findersdk.a.ab)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.findersdk.a.ab.class)).aED(this.talker);
          bool1 = paramf.isChecked();
          if (as.bvP(paramPreference))
          {
            ((t)com.tencent.mm.kernel.h.ae(t.class)).z(bool1, this.talker);
            label1086:
            paramf = com.tencent.mm.plugin.finder.report.d.zUg;
            paramf = com.tencent.mm.plugin.finder.report.d.dPe();
            if (!bool1) {
              break label1130;
            }
          }
          for (;;)
          {
            paramf.zUD = l;
            break;
            ((ah)com.tencent.mm.kernel.h.ae(ah.class)).A(bool1, this.talker);
            break label1086;
            label1130:
            l = 0L;
          }
        }
      }
      else if ((paramf.equals("room_add_blacklist")) && (as.bvQ(this.talker)))
      {
        ((com.tencent.mm.plugin.gamelife.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.gamelife.c.class)).dealBlackList(getContext(), this.talker, this.Wex, this.Wew, new c.b()
        {
          public final void oa(final boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(264797);
            SingleChatInfoUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(292365);
                SingleChatInfoUI.k(SingleChatInfoUI.this).value = Boolean.valueOf(paramAnonymousBoolean);
                SingleChatInfoUI.l(SingleChatInfoUI.this).edit().putBoolean("room_add_blacklist", paramAnonymousBoolean).commit();
                SingleChatInfoUI.d(SingleChatInfoUI.this).notifyDataSetChanged();
                AppMethodBeat.o(292365);
              }
            });
            AppMethodBeat.o(264797);
          }
        });
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33734);
    asz();
    if (this.iYf != null)
    {
      localObject = new LinkedList();
      ((List)localObject).add(this.talker);
      this.iYf.s(this.talker, (List)localObject);
      if (as.aEF(this.talker))
      {
        this.iYf.DZ(false);
        this.iYf.Ea(false);
      }
      if (as.bvQ(this.talker))
      {
        this.iYf.DZ(false);
        this.iYf.Ea(false);
      }
      this.iYf.DY(true);
    }
    boolean bool2 = as.aEF(this.talker);
    Object localObject = this.screen;
    if (!bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ((f)localObject).dz("room_accept_message", bool1);
      if (bool2)
      {
        localObject = (CheckBoxPreference)this.screen.byG("room_accept_message");
        ((CheckBoxPreference)localObject).setTitle(R.l.etM);
        ((CheckBoxPreference)localObject).setChecked(((m)com.tencent.mm.kernel.h.ae(m.class)).aEw(this.talker));
        ((Preference)localObject).WsF = false;
        this.screen.notifyDataSetChanged();
      }
      hIA();
      this.screen.notifyDataSetChanged();
      super.onResume();
      if (!this.iYB)
      {
        localObject = getIntent().getStringExtra("need_matte_high_light_item");
        if (!Util.isNullOrNil((String)localObject))
        {
          final int i = this.screen.byJ((String)localObject);
          setSelection(i - 3);
          new MMHandler().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(282209);
              View localView = ((com.tencent.mm.ui.base.preference.a)SingleChatInfoUI.d(SingleChatInfoUI.this)).a(i, SingleChatInfoUI.this.getListView());
              if (localView != null) {
                com.tencent.mm.ui.j.a.c(SingleChatInfoUI.this.getContext(), localView);
              }
              AppMethodBeat.o(282209);
            }
          }, 10L);
        }
        this.iYB = true;
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
      SingleChatInfoUI.jo(true);
      AppMethodBeat.o(33731);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.SingleChatInfoUI
 * JD-Core Version:    0.7.0.1
 */