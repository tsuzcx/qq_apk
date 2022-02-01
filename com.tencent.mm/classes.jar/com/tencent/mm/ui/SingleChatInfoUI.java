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
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.w;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.contact.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@i
public class SingleChatInfoUI
  extends MMPreference
  implements com.tencent.mm.bi.a
{
  private static boolean isDeleteCancel = false;
  private CheckBoxPreference FSl;
  private k.a FSm;
  private af contact;
  private ContactListExpandPreference fpW;
  private CheckBoxPreference fpX;
  private CheckBoxPreference fpZ;
  private boolean fqj;
  private int fqm;
  private boolean fqo;
  private com.tencent.mm.pluginsdk.ui.d fqs;
  boolean fqt;
  private String fqx;
  private ap handler;
  private f screen;
  private SharedPreferences sp;
  private String talker;
  
  public SingleChatInfoUI()
  {
    AppMethodBeat.i(33732);
    this.handler = new ap(Looper.getMainLooper());
    this.sp = null;
    this.fqm = -1;
    this.fqo = false;
    this.fqs = new com.tencent.mm.pluginsdk.ui.d(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.FSm = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(33720);
        SingleChatInfoUI.a(SingleChatInfoUI.this);
        AppMethodBeat.o(33720);
      }
    };
    this.fqt = false;
    this.fqx = "";
    AppMethodBeat.o(33732);
  }
  
  private void Vk()
  {
    AppMethodBeat.i(33742);
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    this.fqj = this.contact.Ny();
    if (this.fqj)
    {
      setTitleMuteIconVisibility(0);
      if (this.fpX != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(33742);
      return;
      setTitleMuteIconVisibility(8);
      if (this.fpX != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private void b(final ProgressDialog paramProgressDialog)
  {
    AppMethodBeat.i(33741);
    bi.a(this.contact.field_username, new bi.a()
    {
      public final boolean Vt()
      {
        AppMethodBeat.i(33728);
        boolean bool = SingleChatInfoUI.isDeleteCancel;
        AppMethodBeat.o(33728);
        return bool;
      }
      
      public final void Vu()
      {
        AppMethodBeat.i(33729);
        if (paramProgressDialog != null) {
          paramProgressDialog.dismiss();
        }
        AppMethodBeat.o(33729);
      }
    });
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33719);
        o.azv().ov(7);
        AppMethodBeat.o(33719);
      }
    });
    AppMethodBeat.o(33741);
  }
  
  private void eRL()
  {
    int j = 0;
    AppMethodBeat.i(33739);
    this.FSl = ((CheckBoxPreference)this.screen.aKk("force_notify"));
    if ((af.aHH(this.contact.field_username)) || (com.tencent.mm.model.u.se(this.contact.field_username)))
    {
      this.screen.cE("force_notify", true);
      AppMethodBeat.o(33739);
      return;
    }
    long l = ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).aai(this.contact.field_username);
    boolean bool = ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).aaj(this.contact.field_username);
    this.FSl.lG = bool;
    this.FSl.vP(bool);
    if (this.FSl.isChecked())
    {
      this.FSl.setSummary(getResources().getString(2131759597, new Object[] { new SimpleDateFormat("HH:mm").format(new Date(l)) }));
      if (this.sp == null) {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      }
      this.sp.edit().putBoolean("force_notify", this.FSl.isChecked()).commit();
      if (!this.FSl.isChecked()) {
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
      this.FSl.setSummary(null);
      if (this.contact.Ny()) {}
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
    if ((paramString1.equals(this.talker)) && (this.fpW != null)) {
      this.fpW.notifyChanged();
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
    this.fpW = ((ContactListExpandPreference)this.screen.aKk("roominfo_contact_anchor"));
    this.fpW.a(this.screen, this.fpW.mKey);
    this.fpW.ub(true).uc(false);
    if ((this.contact != null) && (this.contact.field_deleteFlag == 1)) {
      this.fpW.ub(false);
    }
    if ((!com.tencent.mm.ui.contact.u.fbN()) && (this.contact != null) && (af.aHH(this.contact.field_username))) {
      this.fpW.ub(false);
    }
    this.fpX = ((CheckBoxPreference)this.screen.aKk("room_notify_new_msg"));
    this.fpZ = ((CheckBoxPreference)this.screen.aKk("room_placed_to_the_top"));
    Object localObject = this.screen;
    boolean bool;
    if (!com.tencent.mm.n.b.ls(this.contact.field_type))
    {
      bool = true;
      ((f)localObject).cE("force_notify", bool);
      if (this.sp == null) {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      }
      if (this.contact == null) {
        break label479;
      }
      localObject = this.sp.edit();
      az.arV();
      ((SharedPreferences.Editor)localObject).putBoolean("room_placed_to_the_top", c.apR().aIv(this.contact.field_username)).commit();
      this.fqj = this.contact.Ny();
      this.sp.edit().putBoolean("room_notify_new_msg", this.fqj).commit();
    }
    for (;;)
    {
      az.arV();
      this.fqm = c.apO().agF(this.talker);
      this.screen.notifyDataSetChanged();
      if (this.fpW != null)
      {
        localObject = new LinkedList();
        ((List)localObject).add(this.talker);
        this.fpW.B(this.talker, (List)localObject);
        getListView().setOnScrollListener(this.fqs);
        this.fpW.a(this.fqs);
        this.fpW.a(new ContactListExpandPreference.a()
        {
          public final void b(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt) {}
          
          public final void c(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
          {
            AppMethodBeat.i(204941);
            String str = SingleChatInfoUI.c(SingleChatInfoUI.this).US(paramAnonymousInt);
            paramAnonymousView = bt.nullAsNil(SingleChatInfoUI.c(SingleChatInfoUI.this).UU(paramAnonymousInt));
            paramAnonymousViewGroup = paramAnonymousView;
            if (bt.isNullOrNil(paramAnonymousView))
            {
              az.arV();
              bw localbw = c.apN().agQ(str);
              paramAnonymousViewGroup = paramAnonymousView;
              if (localbw != null)
              {
                paramAnonymousViewGroup = paramAnonymousView;
                if (!bt.isNullOrNil(localbw.field_encryptUsername)) {
                  paramAnonymousViewGroup = localbw.field_conRemark;
                }
              }
            }
            if (bt.isNullOrNil(str))
            {
              AppMethodBeat.o(204941);
              return;
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", str);
            paramAnonymousView.putExtra("Contact_RemarkName", paramAnonymousViewGroup);
            paramAnonymousView.putExtra("Contact_Nick", bt.nullAsNil(SingleChatInfoUI.c(SingleChatInfoUI.this).UT(paramAnonymousInt)));
            paramAnonymousView.putExtra("Contact_RoomMember", true);
            paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 9);
            paramAnonymousViewGroup = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(str);
            if ((paramAnonymousViewGroup != null) && ((int)paramAnonymousViewGroup.fId > 0) && (com.tencent.mm.n.b.ls(paramAnonymousViewGroup.field_type))) {
              e.a(paramAnonymousView, str);
            }
            paramAnonymousView.putExtra("Kdel_from", 0);
            com.tencent.mm.bs.d.b(SingleChatInfoUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView, 0);
            AppMethodBeat.o(204941);
          }
          
          public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView) {}
          
          public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
          {
            AppMethodBeat.i(204943);
            SingleChatInfoUI.d(SingleChatInfoUI.this);
            AppMethodBeat.o(204943);
          }
          
          public final void e(ViewGroup paramAnonymousViewGroup, View paramAnonymousView)
          {
            AppMethodBeat.i(204942);
            if (SingleChatInfoUI.c(SingleChatInfoUI.this) != null) {
              SingleChatInfoUI.c(SingleChatInfoUI.this).eyo();
            }
            AppMethodBeat.o(204942);
          }
        });
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(33725);
          SingleChatInfoUI.this.finish();
          AppMethodBeat.o(33725);
          return true;
        }
      });
      AppMethodBeat.o(33738);
      return;
      bool = false;
      break;
      label479:
      this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      this.fqj = false;
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
    ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).cuX().add(this.FSm);
    if (com.tencent.mm.bi.g.hxv != null) {
      com.tencent.mm.bi.g.hxv.a(this);
    }
    this.talker = getIntent().getStringExtra("Single_Chat_Talker");
    this.fqo = getIntent().getBooleanExtra("fromChatting", false);
    this.contact = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(this.talker);
    if (this.contact == null)
    {
      ad.e("MicroMsg.SingleChatInfoUI", "contact is null! talker:%s", new Object[] { this.talker });
      finish();
      AppMethodBeat.o(33733);
      return;
    }
    this.fqx = (getPackageName() + "_preferences");
    initView();
    ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.a.class)).h(this.contact.field_username, 3, ce.asR() / 1000L);
    AppMethodBeat.o(33733);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33736);
    ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).cuX().remove(this.FSm);
    com.tencent.mm.ui.h.a.dismiss();
    if (com.tencent.mm.bi.g.hxv != null) {
      com.tencent.mm.bi.g.hxv.b(this);
    }
    super.onDestroy();
    AppMethodBeat.o(33736);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33735);
    super.onPause();
    AppMethodBeat.o(33735);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    boolean bool = true;
    AppMethodBeat.i(33740);
    paramf = paramPreference.mKey;
    if (paramf.equals("room_notify_new_msg")) {
      if (!this.fqj)
      {
        this.fqj = bool;
        if (!this.fqj) {
          break label156;
        }
        w.s(this.contact);
        label48:
        this.contact = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(this.talker);
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        this.sp.edit().putBoolean("room_notify_new_msg", this.fqj).commit();
        Vk();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(33740);
      return false;
      bool = false;
      break;
      label156:
      w.t(this.contact);
      break label48;
      if (paramf.equals("room_placed_to_the_top"))
      {
        paramf = getSharedPreferences(this.fqx, 0);
        if (this.contact != null)
        {
          az.arV();
          if (c.apR().aIv(this.contact.field_username)) {
            w.D(this.contact.field_username, true);
          }
          for (;;)
          {
            paramf = paramf.edit();
            az.arV();
            paramf.putBoolean("room_placed_to_the_top", c.apR().aIv(this.contact.field_username)).commit();
            break;
            w.C(this.contact.field_username, true);
          }
        }
      }
      else if (paramf.equals("force_notify"))
      {
        if (!this.FSl.isChecked())
        {
          ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).aD(this.contact.field_username + "@wxcontact", 3);
          this.FSl.setSummary(null);
        }
        else
        {
          ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).aah(this.contact.field_username);
          long l = ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).aai(this.contact.field_username);
          this.FSl.setSummary(getResources().getString(2131759597, new Object[] { new SimpleDateFormat("HH:mm").format(new Date(l)) }));
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
        com.tencent.mm.plugin.fts.a.d.c(this, ".ui.FTSChattingConvUI", paramf);
        com.tencent.mm.plugin.report.service.h.vKh.f(14569, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      }
      else if (paramf.equals("room_clear_chatting_history"))
      {
        paramf = getString(2131759503, new Object[] { this.contact.ZX() });
        com.tencent.mm.ui.base.h.a(getContext(), paramf, "", getString(2131755694), getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33730);
            SingleChatInfoUI.h(SingleChatInfoUI.this);
            AppMethodBeat.o(33730);
          }
        }, null, 2131099904);
      }
      else if (paramf.equals("room_expose"))
      {
        paramf = new Intent();
        paramf.putExtra("k_username", this.talker);
        paramf.putExtra("showShare", false);
        paramf.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(39) }));
        com.tencent.mm.bs.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
      }
      else if (paramf.equals("chat_app_brand"))
      {
        paramf = new Intent();
        paramf.putExtra("Chat_User", this.talker);
        com.tencent.mm.bs.d.e(this, ".ui.chatting.gallery.AppBrandHistoryListUI", paramf);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(219L, 25L, 1L, true);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33734);
    Vk();
    Object localObject;
    if (this.fpW != null)
    {
      localObject = new LinkedList();
      ((List)localObject).add(this.talker);
      this.fpW.B(this.talker, (List)localObject);
    }
    eRL();
    this.screen.notifyDataSetChanged();
    super.onResume();
    if (!this.fqt)
    {
      localObject = getIntent().getStringExtra("need_matte_high_light_item");
      if (!bt.isNullOrNil((String)localObject))
      {
        final int i = this.screen.aKm((String)localObject);
        setSelection(i - 3);
        new ap().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(33721);
            View localView = ((com.tencent.mm.ui.base.preference.a)SingleChatInfoUI.b(SingleChatInfoUI.this)).a(i, SingleChatInfoUI.this.getListView());
            if (localView != null) {
              com.tencent.mm.ui.h.a.b(SingleChatInfoUI.this.getContext(), localView);
            }
            AppMethodBeat.o(33721);
          }
        }, 10L);
      }
      this.fqt = true;
    }
    AppMethodBeat.o(33734);
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
      SingleChatInfoUI.vH(true);
      AppMethodBeat.o(33731);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.SingleChatInfoUI
 * JD-Core Version:    0.7.0.1
 */