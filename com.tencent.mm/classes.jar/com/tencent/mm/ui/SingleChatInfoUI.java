package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.Context;
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
import com.tencent.mm.R.e;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.cx;
import com.tencent.mm.bc.g;
import com.tencent.mm.chatroom.ui.a.i;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.a;
import com.tencent.mm.modelmulti.u;
import com.tencent.mm.modelmulti.v;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.finder.report.f.e;
import com.tencent.mm.plugin.finder.view.w.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bb;
import com.tencent.mm.plugin.findersdk.a.bp;
import com.tencent.mm.plugin.findersdk.a.bp.b;
import com.tencent.mm.plugin.findersdk.a.cd;
import com.tencent.mm.plugin.findersdk.a.ch;
import com.tencent.mm.plugin.findersdk.a.y;
import com.tencent.mm.plugin.forcenotify.e.a.a;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.c.a;
import com.tencent.mm.plugin.textstatus.a.r;
import com.tencent.mm.plugin.textstatus.a.r.b;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.protocal.protobuf.bqh;
import com.tencent.mm.protocal.protobuf.bqi;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cr;
import com.tencent.mm.ui.a.m;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.s;

@com.tencent.mm.kernel.k
public class SingleChatInfoUI
  extends MMPreference
  implements com.tencent.mm.bc.a
{
  private static boolean isDeleteCancel = false;
  private CheckBoxPreference adJZ;
  final com.tencent.mm.plugin.appbrand.af.k<Boolean> adKa;
  private com.tencent.mm.plugin.appbrand.af.k<Boolean> adKb;
  private bp.b adKc;
  private com.tencent.mm.pluginsdk.ui.e adKd;
  private r.b adKe;
  private MStorage.IOnStorageChange adKf;
  private au contact;
  private MMHandler handler;
  private CheckBoxPreference lAb;
  private boolean lAj;
  private int lAl;
  private boolean lAn;
  boolean lAt;
  private String lAv;
  private ContactListExpandPreference lzX;
  private CheckBoxPreference lzY;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  private String talker;
  
  public SingleChatInfoUI()
  {
    AppMethodBeat.i(33732);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.sp = null;
    this.adKa = new com.tencent.mm.plugin.appbrand.af.k();
    this.adKb = new com.tencent.mm.plugin.appbrand.af.k();
    this.lAl = -1;
    this.lAn = false;
    this.adKc = null;
    this.adKd = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.adKe = null;
    this.adKf = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(249250);
        SingleChatInfoUI.d(SingleChatInfoUI.this);
        AppMethodBeat.o(249250);
      }
    };
    this.lAt = false;
    this.lAv = "";
    AppMethodBeat.o(33732);
  }
  
  private void Lu(boolean paramBoolean)
  {
    boolean bool1 = true;
    AppMethodBeat.i(249292);
    boolean bool2 = au.aAy(this.talker);
    boolean bool3 = au.bwY(this.talker);
    int i;
    Object localObject;
    if ((bool2) || (bool3))
    {
      i = 1;
      localObject = this.screen;
      if (i != 0) {
        break label124;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.ui.base.preference.f)localObject).eh("room_accept_message", bool1);
      if ((bool2) || (bool3))
      {
        localObject = (CheckBoxPreference)this.screen.bAi("room_accept_message");
        ((CheckBoxPreference)localObject).setTitle(R.l.gwk);
        ((CheckBoxPreference)localObject).setChecked(paramBoolean);
        ((Preference)localObject).adZV = false;
        this.screen.notifyDataSetChanged();
      }
      AppMethodBeat.o(249292);
      return;
      i = 0;
      break;
      label124:
      bool1 = false;
    }
  }
  
  private void a(final ProgressDialog paramProgressDialog)
  {
    AppMethodBeat.i(33741);
    br.a(this.contact.field_username, new br.a()
    {
      public final boolean aMJ()
      {
        AppMethodBeat.i(249128);
        boolean bool = SingleChatInfoUI.jkL();
        AppMethodBeat.o(249128);
        return bool;
      }
      
      public final void aMK()
      {
        AppMethodBeat.i(249131);
        if (paramProgressDialog != null) {
          paramProgressDialog.dismiss();
        }
        AppMethodBeat.o(249131);
      }
    });
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(249113);
        u.bKY().wG(7);
        AppMethodBeat.o(249113);
      }
    });
    AppMethodBeat.o(33741);
  }
  
  private void aMp()
  {
    AppMethodBeat.i(33742);
    if ((au.aAy(this.talker)) || (au.bwW(this.talker)) || (au.bwY(this.talker)))
    {
      this.screen.eh(this.lzY.mKey, true);
      AppMethodBeat.o(33742);
      return;
    }
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    this.lAj = this.contact.aGe();
    if (this.lAj) {}
    for (String str = getResources().getString(a.i.conversation_mute);; str = "")
    {
      com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
      ((m)com.tencent.mm.ui.component.k.d(getContext()).q(m.class)).setValue("is_mute", str);
      if (this.lAj)
      {
        setTitleMuteIconVisibility(0);
        if (this.lzY != null) {
          this.sp.edit().putBoolean("room_notify_new_msg", true).commit();
        }
      }
      for (;;)
      {
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(33742);
        return;
        setTitleMuteIconVisibility(8);
        if (this.lzY != null) {
          this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
        }
      }
    }
  }
  
  private void jkK()
  {
    AppMethodBeat.i(33739);
    this.adJZ = ((CheckBoxPreference)this.screen.bAi("force_notify"));
    if ((au.bwO(this.contact.field_username)) || (com.tencent.mm.model.z.Iy(this.contact.field_username)) || (au.bwQ(this.contact.field_username)))
    {
      this.screen.eh("force_notify", true);
      AppMethodBeat.o(33739);
      return;
    }
    long l = ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.forcenotify.a.b.class)).aDO(this.contact.field_username);
    boolean bool = ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.forcenotify.a.b.class)).aDL(this.contact.field_username);
    this.adJZ.setChecked(bool);
    this.adJZ.Hy(bool);
    if (this.adJZ.isChecked())
    {
      this.adJZ.aS(getResources().getString(R.l.force_notify_on_tip, new Object[] { new SimpleDateFormat("HH:mm").format(new Date(l)) }));
      if (this.sp == null) {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      }
      this.sp.edit().putBoolean("force_notify", this.adJZ.isChecked()).commit();
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(33739);
      return;
    }
    this.adJZ.aS(null);
    if (this.contact.aGe()) {}
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
    return R.o.hbn;
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
    setMMTitle(getString(R.l.gTZ));
    this.lzX = ((ContactListExpandPreference)this.screen.bAi("roominfo_contact_anchor"));
    this.lzX.a(this.screen, this.lzX.mKey);
    this.lzX.JJ(true).JK(false);
    if ((this.contact != null) && (this.contact.field_deleteFlag == 1)) {
      this.lzX.JJ(false);
    }
    if ((!com.tencent.mm.ui.contact.w.jyX()) && (this.contact != null) && (au.bwO(this.contact.field_username))) {
      this.lzX.JJ(false);
    }
    this.lzY = ((CheckBoxPreference)this.screen.bAi("room_notify_new_msg"));
    this.lAb = ((CheckBoxPreference)this.screen.bAi("room_placed_to_the_top"));
    Object localObject = this.screen;
    boolean bool;
    if (!com.tencent.mm.contact.d.rs(this.contact.field_type))
    {
      bool = true;
      ((com.tencent.mm.ui.base.preference.f)localObject).eh("force_notify", bool);
      if (this.sp == null) {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      }
      if (this.contact == null) {
        break label604;
      }
      if (!au.aAy(this.talker)) {
        break label581;
      }
      bool = ((com.tencent.mm.plugin.findersdk.a.z)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.findersdk.a.z.class)).aAt(this.talker);
      label301:
      this.sp.edit().putBoolean("room_placed_to_the_top", bool).commit();
      this.lAj = this.contact.aGe();
      this.sp.edit().putBoolean("room_notify_new_msg", this.lAj).commit();
    }
    for (;;)
    {
      if (au.aAy(this.talker))
      {
        this.screen.eh("room_search_chatting_content", true);
        this.screen.eh("force_notify", true);
      }
      if (au.bwY(this.talker))
      {
        this.screen.eh("room_search_chatting_content", true);
        this.screen.eh("force_notify", true);
        this.screen.eh("room_set_chatting_background", true);
      }
      bh.bCz();
      this.lAl = com.tencent.mm.model.c.bzD().aLX(this.talker);
      this.screen.notifyDataSetChanged();
      if (this.lzX != null)
      {
        localObject = new LinkedList();
        ((List)localObject).add(this.talker);
        this.lzX.y(this.talker, (List)localObject);
        getListView().setOnScrollListener(this.adKd);
        this.lzX.a(this.adKd);
        this.lzX.a(new ContactListExpandPreference.a()
        {
          public final void aMI()
          {
            AppMethodBeat.i(249268);
            if (SingleChatInfoUI.f(SingleChatInfoUI.this) != null) {
              SingleChatInfoUI.f(SingleChatInfoUI.this).iLt();
            }
            AppMethodBeat.o(249268);
          }
          
          public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
          {
            AppMethodBeat.i(249263);
            Object localObject3 = SingleChatInfoUI.f(SingleChatInfoUI.this).awu(paramAnonymousInt);
            Object localObject2 = Util.nullAsNil(SingleChatInfoUI.f(SingleChatInfoUI.this).aww(paramAnonymousInt));
            Object localObject1 = localObject2;
            if (Util.isNullOrNil((String)localObject2))
            {
              bh.bCz();
              cr localcr = com.tencent.mm.model.c.bzB().aMi((String)localObject3);
              localObject1 = localObject2;
              if (localcr != null)
              {
                localObject1 = localObject2;
                if (!Util.isNullOrNil(localcr.field_encryptUsername)) {
                  localObject1 = localcr.field_conRemark;
                }
              }
            }
            if (Util.isNullOrNil((String)localObject3))
            {
              AppMethodBeat.o(249263);
              return;
            }
            if (SingleChatInfoUI.bzR(SingleChatInfoUI.b(SingleChatInfoUI.this)))
            {
              localObject1 = com.tencent.mm.plugin.finder.report.f.FnM;
              localObject1 = com.tencent.mm.plugin.finder.report.f.eMk();
              ((f.e)localObject1).Fok += 1L;
              Log.i(((f.e)localObject1).TAG, s.X("incChatInfoClickCount:", Long.valueOf(((f.e)localObject1).Fok)));
              localObject2 = ((bp)com.tencent.mm.kernel.h.ax(bp.class)).aAw(SingleChatInfoUI.b(SingleChatInfoUI.this));
              if (au.bwV((String)localObject2))
              {
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra("finder_username", (String)localObject2);
                localObject2 = as.GSQ;
                as.a.a(paramAnonymousViewGroup.getContext(), (Intent)localObject1, 0L, null, 0, 10, false);
                ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).enterFinderProfileUI(paramAnonymousViewGroup.getContext(), (Intent)localObject1);
                AppMethodBeat.o(249263);
                return;
              }
              if (au.bwT((String)localObject2))
              {
                localObject1 = new Intent();
                localObject2 = ((y)com.tencent.mm.kernel.h.ax(y.class)).aAm((String)localObject2);
                localObject3 = com.tencent.mm.plugin.finder.view.w.GEc;
                w.a.a((ch)localObject2, (Intent)localObject1);
                ((Intent)localObject1).putExtra("IsPoster", true);
                localObject2 = com.tencent.mm.plugin.finder.view.w.GEc;
                w.a.a(paramAnonymousViewGroup.getContext(), (Intent)localObject1, 2, null);
                AppMethodBeat.o(249263);
                return;
              }
              Log.i("MicroMsg.SingleChatInfoUI", "talkerName :".concat(String.valueOf(localObject2)));
              AppMethodBeat.o(249263);
              return;
            }
            if (SingleChatInfoUI.bzS(SingleChatInfoUI.b(SingleChatInfoUI.this)))
            {
              localObject1 = new Intent(SingleChatInfoUI.this, ProfileHdHeadImg.class);
              ((Intent)localObject1).putExtra("username", SingleChatInfoUI.b(SingleChatInfoUI.this));
              ((r)com.tencent.mm.kernel.h.ax(r.class)).dh(SingleChatInfoUI.b(SingleChatInfoUI.this), 154);
              paramAnonymousViewGroup = SingleChatInfoUI.this;
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousViewGroup, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/SingleChatInfoUI$6", "onItemNormalClick", "(Landroid/view/ViewGroup;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousViewGroup.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousViewGroup, "com/tencent/mm/ui/SingleChatInfoUI$6", "onItemNormalClick", "(Landroid/view/ViewGroup;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(249263);
              return;
            }
            if (au.bwW(SingleChatInfoUI.b(SingleChatInfoUI.this)))
            {
              ((PluginGameLife)com.tencent.mm.kernel.h.az(PluginGameLife.class)).enterGameLifeProfileUI(SingleChatInfoUI.this.getContext(), SingleChatInfoUI.b(SingleChatInfoUI.this), com.tencent.mm.plugin.gamelife.a.IYV);
              AppMethodBeat.o(249263);
              return;
            }
            if (au.bwQ((String)localObject3)) {
              com.tencent.mm.openim.d.a.bm((String)localObject3, 10);
            }
            paramAnonymousViewGroup = new Intent();
            paramAnonymousViewGroup.putExtra("Contact_User", (String)localObject3);
            paramAnonymousViewGroup.putExtra("Contact_RemarkName", (String)localObject1);
            paramAnonymousViewGroup.putExtra("Contact_Nick", Util.nullAsNil(SingleChatInfoUI.f(SingleChatInfoUI.this).awv(paramAnonymousInt)));
            paramAnonymousViewGroup.putExtra("Contact_RoomMember", true);
            paramAnonymousViewGroup.putExtra("CONTACT_INFO_UI_SOURCE", 9);
            localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE((String)localObject3);
            if ((localObject1 != null) && ((int)((com.tencent.mm.contact.d)localObject1).maN > 0) && (com.tencent.mm.contact.d.rs(((az)localObject1).field_type))) {
              com.tencent.mm.ui.contact.e.a(paramAnonymousViewGroup, (String)localObject3);
            }
            paramAnonymousViewGroup.putExtra("Kdel_from", 0);
            com.tencent.mm.br.c.b(SingleChatInfoUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousViewGroup, 0);
            AppMethodBeat.o(249263);
          }
          
          public final void qw(int paramAnonymousInt) {}
          
          public final void qx(int paramAnonymousInt)
          {
            AppMethodBeat.i(249272);
            SingleChatInfoUI.g(SingleChatInfoUI.this);
            AppMethodBeat.o(249272);
          }
        });
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(249256);
          SingleChatInfoUI.this.finish();
          AppMethodBeat.o(249256);
          return true;
        }
      });
      AppMethodBeat.o(33738);
      return;
      bool = false;
      break;
      label581:
      bh.bCz();
      bool = com.tencent.mm.model.c.bzG().bxV(this.contact.field_username);
      break label301;
      label604:
      this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      this.lAj = false;
    }
  }
  
  public final void m(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(33743);
    if ((paramString1.equals(this.talker)) && (this.lzX != null)) {
      this.lzX.notifyChanged();
    }
    AppMethodBeat.o(33743);
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
    ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.forcenotify.a.b.class)).fwy().add(this.adKf);
    if (g.oXL != null) {
      g.oXL.a(this);
    }
    this.talker = getIntent().getStringExtra("Single_Chat_Talker");
    this.lAn = getIntent().getBooleanExtra("fromChatting", false);
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.talker);
    if (this.contact == null)
    {
      Log.e("MicroMsg.SingleChatInfoUI", "contact is null! talker:%s", new Object[] { this.talker });
      finish();
      AppMethodBeat.o(33733);
      return;
    }
    this.lAv = (getPackageName() + "_preferences");
    initView();
    ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.forcenotify.a.a.class)).D(this.contact.field_username, 3, com.tencent.mm.model.cn.bDv() / 1000L);
    label329:
    Object localObject1;
    String str;
    Object localObject2;
    label436:
    long l;
    if (!au.bwW(this.talker))
    {
      this.screen.eh("room_add_blacklist", true);
      if ((this.contact == null) || (!au.bwQ(this.contact.field_username))) {
        break label782;
      }
      this.screen.eh("room_placed_to_the_top", true);
      this.screen.eh("force_notify", true);
      this.screen.eh("seperate_line_between_force_notify_and_background", true);
      this.screen.eh("room_set_chatting_background", true);
      this.screen.eh("room_notify_new_msg", false);
      this.screen.eh("close_chat", false);
      if (au.aAy(this.talker))
      {
        this.screen.eh("room_placed_to_the_top", true);
        this.adKc = new bp.b()
        {
          public final void onDone(List<bqi> paramAnonymousList)
          {
            AppMethodBeat.i(249286);
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
                paramAnonymousList = (bqi)((Iterator)localObject).next();
              } while (!paramAnonymousList.sessionId.equals(SingleChatInfoUI.b(SingleChatInfoUI.this)));
            }
            for (;;)
            {
              if (paramAnonymousList != null)
              {
                Log.i("MicroMsg.SingleChatInfoUI", "sessionId: " + paramAnonymousList.sessionId + ", sessionReject: " + paramAnonymousList.ZYl);
                localObject = SingleChatInfoUI.this;
                if (paramAnonymousList.ZYl != 1) {
                  break label161;
                }
              }
              label161:
              for (boolean bool = true;; bool = false)
              {
                SingleChatInfoUI.a((SingleChatInfoUI)localObject, bool);
                SingleChatInfoUI.c(SingleChatInfoUI.this);
                AppMethodBeat.o(249286);
                return;
              }
              paramAnonymousList = null;
            }
          }
        };
        paramBundle = new LinkedList();
        localObject1 = new bqh();
        str = ((bp)com.tencent.mm.kernel.h.ax(bp.class)).aAw(this.talker);
        localObject2 = ((bp)com.tencent.mm.kernel.h.ax(bp.class)).aAx(this.talker);
        if (!au.bwV((String)localObject2)) {
          break label799;
        }
        ((bqh)localObject1).ZLh = 1;
        ((bqh)localObject1).sessionId = this.talker;
        ((bqh)localObject1).hHa = str;
        paramBundle.add(localObject1);
        ((bp)com.tencent.mm.kernel.h.ax(bp.class)).a(paramBundle, this.adKc);
        str = ((bp)com.tencent.mm.kernel.h.ax(bp.class)).aAw(this.talker);
        paramBundle = com.tencent.mm.plugin.finder.report.f.FnM;
        localObject2 = com.tencent.mm.plugin.finder.report.f.eMk();
        if (!au.bwV(str)) {
          break label825;
        }
        l = 1L;
        label517:
        if (this.talker != null) {
          break label832;
        }
      }
    }
    label782:
    label799:
    label825:
    label832:
    for (paramBundle = "";; paramBundle = this.talker)
    {
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      s.u(paramBundle, "chatName");
      s.u(localObject1, "talkUserName");
      ((f.e)localObject2).Foa = l;
      ((f.e)localObject2).Fog = paramBundle;
      ((f.e)localObject2).Foc = ((String)localObject1);
      ((f.e)localObject2).Foe = String.valueOf(com.tencent.mm.model.cn.bDw());
      if (au.bwY(this.talker))
      {
        this.screen.eh("room_placed_to_the_top", true);
        this.adKe = new r.b()
        {
          public final void onDone(boolean paramAnonymousBoolean, List<com.tencent.mm.plugin.textstatus.proto.h> paramAnonymousList)
          {
            AppMethodBeat.i(249278);
            if (paramAnonymousList != null) {}
            for (Object localObject = Integer.valueOf(paramAnonymousList.size());; localObject = "null")
            {
              Log.i("MicroMsg.SingleChatInfoUI", "tsessionInfos result:%s size:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), localObject });
              if (paramAnonymousList != null)
              {
                paramAnonymousList = paramAnonymousList.iterator();
                while (paramAnonymousList.hasNext())
                {
                  localObject = (com.tencent.mm.plugin.textstatus.proto.h)paramAnonymousList.next();
                  if ((localObject != null) && (((com.tencent.mm.plugin.textstatus.proto.h)localObject).ret == 0))
                  {
                    Log.i("MicroMsg.SingleChatInfoUI", "rspInfo" + ((com.tencent.mm.plugin.textstatus.proto.h)localObject).ret + ",block:" + ((com.tencent.mm.plugin.textstatus.proto.h)localObject).ToL);
                    SingleChatInfoUI.a(SingleChatInfoUI.this, ((com.tencent.mm.plugin.textstatus.proto.h)localObject).ToL);
                  }
                }
              }
              SingleChatInfoUI.a(SingleChatInfoUI.this);
              AppMethodBeat.o(249278);
              return;
            }
          }
        };
        paramBundle = new LinkedList();
        paramBundle.add(this.talker);
        ((r)com.tencent.mm.kernel.h.ax(r.class)).a(paramBundle, this.adKe, this);
      }
      AppMethodBeat.o(33733);
      return;
      this.screen.eh("room_search_chatting_content", true);
      this.screen.eh("room_set_chatting_background", true);
      this.screen.eh("room_placed_to_the_top", true);
      this.screen.eh("force_notify", true);
      this.screen.eh("seperate_line_between_force_notify_and_background", true);
      this.screen.eh("seperate_line_between_background_and_clear_history", true);
      ((PluginGameLife)com.tencent.mm.kernel.h.az(PluginGameLife.class)).initGameLifeSingleChatInfoUI(getContext(), this.talker, new c.a()
      {
        public final void au(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(249119);
          SingleChatInfoUI.l(SingleChatInfoUI.this).value = Boolean.valueOf(paramAnonymousBoolean2);
          SingleChatInfoUI.this.adKa.value = Boolean.valueOf(paramAnonymousBoolean1);
          SingleChatInfoUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(249056);
              if ((SingleChatInfoUI.l(SingleChatInfoUI.this) != null) && (SingleChatInfoUI.l(SingleChatInfoUI.this).value != null)) {
                SingleChatInfoUI.m(SingleChatInfoUI.this).edit().putBoolean("room_add_blacklist", ((Boolean)SingleChatInfoUI.l(SingleChatInfoUI.this).value).booleanValue()).commit();
              }
              SingleChatInfoUI.e(SingleChatInfoUI.this).notifyDataSetChanged();
              AppMethodBeat.o(249056);
            }
          });
          AppMethodBeat.o(249119);
        }
      });
      break;
      this.screen.eh("close_chat", true);
      break label329;
      if (au.bwU((String)localObject2))
      {
        ((bqh)localObject1).ZLh = 3;
        break label436;
      }
      ((bqh)localObject1).ZLh = 2;
      break label436;
      l = 2L;
      break label517;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33736);
    ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.forcenotify.a.b.class)).fwy().remove(this.adKf);
    com.tencent.mm.ui.j.a.dismiss();
    if (g.oXL != null) {
      g.oXL.b(this);
    }
    super.onDestroy();
    Object localObject1 = as.GSQ;
    if (as.a.hu(getContext()) != null)
    {
      localObject1 = as.GSQ;
      as.a.hu(getContext()).iI(0, 0);
      localObject1 = as.GSQ;
    }
    for (localObject1 = as.a.hu(getContext()).fou();; localObject1 = null)
    {
      Object localObject2 = com.tencent.mm.plugin.finder.report.f.FnM;
      f.e locale = com.tencent.mm.plugin.finder.report.f.eMk();
      cx localcx = new cx();
      if (localObject1 != null)
      {
        String str = ((bui)localObject1).sessionId;
        localObject2 = str;
        if (str == null) {
          localObject2 = "";
        }
        localcx.mO((String)localObject2);
        localObject2 = ((bui)localObject1).zIB;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localcx.mP((String)localObject1);
      }
      localObject2 = localcx.inx;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localcx.mO((String)localObject1);
      localObject2 = localcx.ixK;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localcx.mP((String)localObject1);
      localcx.ixM = localcx.F("chatSessionid", locale.Foe, true);
      localcx.ixI = locale.Foa;
      localcx.ixO = localcx.F("chatName", locale.Fog, true);
      localcx.ixJ = localcx.F("talkerUsername", locale.Foc, true);
      localcx.iyb = locale.Fon;
      localcx.ixS = locale.Fok;
      localcx.iyc = locale.Fom;
      localcx.iyd = locale.Fol;
      localcx.bMH();
      localObject1 = com.tencent.mm.plugin.finder.report.f.FnM;
      com.tencent.mm.plugin.finder.report.f.a(locale.TAG, (com.tencent.mm.plugin.report.a)localcx);
      locale.Foa = 0L;
      locale.Fog = "";
      locale.Foc = "";
      locale.Fok = 0L;
      locale.Fol = 0L;
      locale.Fom = 0L;
      locale.Fon = 0L;
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
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    boolean bool = true;
    AppMethodBeat.i(33740);
    paramf = paramPreference.mKey;
    if (paramf.equals("room_notify_new_msg")) {
      if (!this.lAj)
      {
        this.lAj = bool;
        if (!this.lAj) {
          break label159;
        }
        ab.G(this.contact);
        label49:
        this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.talker);
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        this.sp.edit().putBoolean("room_notify_new_msg", this.lAj).commit();
        aMp();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(33740);
      return false;
      bool = false;
      break;
      label159:
      ab.H(this.contact);
      break label49;
      if (paramf.equals("room_placed_to_the_top"))
      {
        paramf = getSharedPreferences(this.lAv, 0);
        if (this.contact != null) {
          if (au.aAy(this.talker))
          {
            com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.findersdk.a.z.class);
            ((com.tencent.mm.plugin.findersdk.a.z)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.findersdk.a.z.class)).aAt(this.talker);
          }
          else
          {
            bh.bCz();
            if (com.tencent.mm.model.c.bzG().bxV(this.contact.field_username)) {
              ab.L(this.contact.field_username, true);
            }
            for (;;)
            {
              paramf = paramf.edit();
              bh.bCz();
              paramf.putBoolean("room_placed_to_the_top", com.tencent.mm.model.c.bzG().bxV(this.contact.field_username)).commit();
              break;
              ab.K(this.contact.field_username, true);
            }
          }
        }
      }
      else if (paramf.equals("force_notify"))
      {
        if (!this.adJZ.isChecked())
        {
          ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.forcenotify.a.b.class)).bB(this.contact.field_username + "@wxcontact", 3);
          this.adJZ.aS(null);
        }
        else
        {
          paramf = com.tencent.mm.plugin.forcenotify.e.a.HpI;
          com.tencent.mm.plugin.forcenotify.e.a.a(getContext(), 1, new a.a()
          {
            public final void onResult(boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(249247);
              if (paramAnonymousBoolean)
              {
                ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.forcenotify.a.b.class)).aDK(SingleChatInfoUI.h(SingleChatInfoUI.this).field_username);
                long l = ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.forcenotify.a.b.class)).aDO(SingleChatInfoUI.h(SingleChatInfoUI.this).field_username);
                SingleChatInfoUI.i(SingleChatInfoUI.this).aS(SingleChatInfoUI.this.getResources().getString(R.l.force_notify_on_tip, new Object[] { new SimpleDateFormat("HH:mm").format(new Date(l)) }));
                AppMethodBeat.o(249247);
                return;
              }
              SingleChatInfoUI.i(SingleChatInfoUI.this).Hy(false);
              AppMethodBeat.o(249247);
            }
          });
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
        com.tencent.mm.plugin.report.service.h.OAn.b(14569, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      }
      else if (paramf.equals("room_clear_chatting_history"))
      {
        paramf = com.tencent.mm.plugin.finder.report.f.FnM;
        paramf = com.tencent.mm.plugin.finder.report.f.eMk();
        paramf.Fom += 1L;
        Log.i(paramf.TAG, s.X("incClearHistoryCount:", Long.valueOf(paramf.Fom)));
        if (au.bwY(this.talker)) {
          ((r)com.tencent.mm.kernel.h.ax(r.class)).dh(this.talker, 157);
        }
        paramf = getString(R.l.gIr, new Object[] { this.contact.aSV() });
        com.tencent.mm.ui.base.k.a(getContext(), paramf, "", getString(R.l.app_clear), getString(R.l.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(249130);
            if (SingleChatInfoUI.bzS(SingleChatInfoUI.b(SingleChatInfoUI.this))) {
              ((r)com.tencent.mm.kernel.h.ax(r.class)).dh(SingleChatInfoUI.b(SingleChatInfoUI.this), 158);
            }
            SingleChatInfoUI.k(SingleChatInfoUI.this);
            ac.aY(SingleChatInfoUI.b(SingleChatInfoUI.this), 16);
            AppMethodBeat.o(249130);
          }
        }, null, R.e.alert_btn_color_warn);
      }
      else if (paramf.equals("room_expose"))
      {
        paramf = com.tencent.mm.plugin.finder.report.f.FnM;
        paramf = com.tencent.mm.plugin.finder.report.f.eMk();
        paramf.Fol += 1L;
        Log.i(paramf.TAG, s.X("incCompanionCount:", Long.valueOf(paramf.Fol)));
        paramf = new Intent();
        paramf.putExtra("showShare", false);
        if (au.bwW(this.talker))
        {
          ((PluginGameLife)com.tencent.mm.kernel.h.az(PluginGameLife.class)).enterExpose(getContext(), paramf, this.talker);
        }
        else
        {
          if (au.aAy(this.talker)) {
            paramf.putExtra("rawUrl", String.format(f.f.adwf, new Object[] { Integer.valueOf(61) }));
          }
          for (;;)
          {
            paramf.putExtra("k_username", this.talker);
            com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", paramf);
            break;
            if (au.bwY(this.talker))
            {
              ((r)com.tencent.mm.kernel.h.ax(r.class)).dh(this.talker, 159);
              paramf.putExtra("rawUrl", String.format(f.f.adwf, new Object[] { Integer.valueOf(76) }));
            }
            else
            {
              paramf.putExtra("rawUrl", String.format(f.f.adwf, new Object[] { Integer.valueOf(39) }));
            }
          }
        }
      }
      else if (paramf.equals("chat_app_brand"))
      {
        paramf = new Intent();
        paramf.putExtra("Chat_User", this.talker);
        com.tencent.mm.br.c.g(this, ".ui.chatting.gallery.AppBrandHistoryListUI", paramf);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(219L, 25L, 1L, true);
      }
      else if (paramf.equals("room_accept_message"))
      {
        paramf = (CheckBoxPreference)this.screen.bAi("room_accept_message");
        if (paramf != null)
        {
          bool = paramf.isChecked();
          if (au.bwY(this.talker))
          {
            ((r)com.tencent.mm.kernel.h.ax(r.class)).d(this, bool, this.talker);
          }
          else
          {
            paramf = ((bp)com.tencent.mm.kernel.h.ax(bp.class)).aAw(this.talker);
            paramPreference = ((bp)com.tencent.mm.kernel.h.ax(bp.class)).aAx(this.talker);
            if ((au.bwV(paramf)) && (!au.bwV(paramPreference)))
            {
              ((bb)com.tencent.mm.kernel.h.ax(bb.class)).N(bool, this.talker);
              label1182:
              paramf = com.tencent.mm.plugin.finder.report.f.FnM;
              paramf = com.tencent.mm.plugin.finder.report.f.eMk();
              if (!bool) {
                break label1228;
              }
            }
            label1228:
            for (long l = 1L;; l = 0L)
            {
              paramf.Fon = l;
              break;
              ((cd)com.tencent.mm.kernel.h.ax(cd.class)).O(bool, this.talker);
              break label1182;
            }
          }
        }
      }
      else if (paramf.equals("room_add_blacklist"))
      {
        if (au.bwW(this.talker)) {
          ((com.tencent.mm.plugin.gamelife.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.gamelife.c.class)).dealBlackList(getContext(), this.talker, this.adKb, this.adKa, new com.tencent.mm.plugin.gamelife.c.b()
          {
            public final void onDone(final boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(249118);
              SingleChatInfoUI.this.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(249476);
                  SingleChatInfoUI.l(SingleChatInfoUI.this).value = Boolean.valueOf(paramAnonymousBoolean);
                  SingleChatInfoUI.m(SingleChatInfoUI.this).edit().putBoolean("room_add_blacklist", paramAnonymousBoolean).commit();
                  SingleChatInfoUI.e(SingleChatInfoUI.this).notifyDataSetChanged();
                  AppMethodBeat.o(249476);
                }
              });
              AppMethodBeat.o(249118);
            }
          });
        }
      }
      else if (paramf.equals("close_chat"))
      {
        paramf = getContext();
        if (paramf != null)
        {
          com.tencent.mm.openim.d.a.bm(this.talker, 8);
          com.tencent.mm.ui.base.k.a(paramf, paramf.getResources().getString(R.l.gRb), "", paramf.getString(R.l.gQZ), paramf.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(249121);
              com.tencent.mm.openim.d.a.bm(SingleChatInfoUI.b(SingleChatInfoUI.this), 9);
              SingleChatInfoUI.a(SingleChatInfoUI.this, paramf, SingleChatInfoUI.b(SingleChatInfoUI.this));
              AppMethodBeat.o(249121);
            }
          }, null, R.e.alert_btn_color_warn);
        }
      }
    }
  }
  
  public void onResume()
  {
    boolean bool1 = false;
    AppMethodBeat.i(33734);
    aMp();
    Object localObject;
    if (this.lzX != null)
    {
      localObject = new LinkedList();
      ((List)localObject).add(this.talker);
      this.lzX.y(this.talker, (List)localObject);
      if (au.aAy(this.talker))
      {
        this.lzX.JJ(false);
        this.lzX.JK(false);
      }
      if (au.bwY(this.talker))
      {
        this.lzX.JJ(false);
        this.lzX.JK(false);
      }
      if (au.bwW(this.talker))
      {
        this.lzX.JJ(false);
        this.lzX.JK(false);
      }
      this.lzX.JI(true);
      if (au.bwQ(this.talker))
      {
        this.lzX.JJ(false);
        this.lzX.JK(false);
        this.lzX.JI(false);
      }
    }
    boolean bool2 = au.aAy(this.talker);
    boolean bool3 = au.bwY(this.talker);
    if ((bool2) || (bool3)) {}
    for (final int i = 1;; i = 0)
    {
      localObject = this.screen;
      if (i == 0) {
        bool1 = true;
      }
      ((com.tencent.mm.ui.base.preference.f)localObject).eh("room_accept_message", bool1);
      if (bool2) {
        Lu(((y)com.tencent.mm.kernel.h.ax(y.class)).aAp(this.talker));
      }
      if (bool3) {
        Lu(((r)com.tencent.mm.kernel.h.ax(r.class)).aAp(this.talker));
      }
      jkK();
      this.screen.notifyDataSetChanged();
      super.onResume();
      if (!this.lAt)
      {
        localObject = getIntent().getStringExtra("need_matte_high_light_item");
        if (!Util.isNullOrNil((String)localObject))
        {
          i = this.screen.bAl((String)localObject);
          setSelection(i - 3);
          new MMHandler().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(249253);
              View localView = ((com.tencent.mm.ui.base.preference.a)SingleChatInfoUI.e(SingleChatInfoUI.this)).a(i, SingleChatInfoUI.this.getListView());
              if (localView != null) {
                com.tencent.mm.ui.j.a.d(SingleChatInfoUI.this.getContext(), localView);
              }
              AppMethodBeat.o(249253);
            }
          }, 10L);
        }
        this.lAt = true;
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(249370);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(m.class);
    AppMethodBeat.o(249370);
  }
  
  static final class a
    implements DialogInterface.OnCancelListener
  {
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(33731);
      SingleChatInfoUI.Lv(true);
      AppMethodBeat.o(33731);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.SingleChatInfoUI
 * JD-Core Version:    0.7.0.1
 */