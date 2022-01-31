package com.tencent.mm.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@i
public class SingleChatInfoUI
  extends MMPreference
  implements com.tencent.mm.bg.a
{
  private static boolean isDeleteCancel = false;
  private ad contact;
  private ContactListExpandPreference eeU;
  private CheckBoxPreference eeV;
  private CheckBoxPreference eeX;
  private boolean efg;
  private int efj;
  private boolean efl;
  private com.tencent.mm.pluginsdk.ui.d efo;
  boolean efp;
  private String eft;
  private ak handler;
  private f screen;
  private SharedPreferences sp;
  private String talker;
  private CheckBoxPreference zfc;
  private k.a zfd;
  
  public SingleChatInfoUI()
  {
    AppMethodBeat.i(29880);
    this.handler = new ak(Looper.getMainLooper());
    this.sp = null;
    this.efj = -1;
    this.efl = false;
    this.efo = new com.tencent.mm.pluginsdk.ui.d(new SingleChatInfoUI.1(this));
    this.zfd = new SingleChatInfoUI.3(this);
    this.efp = false;
    this.eft = "";
    AppMethodBeat.o(29880);
  }
  
  private void JJ()
  {
    AppMethodBeat.i(29890);
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    this.efg = this.contact.DP();
    if (this.efg)
    {
      setTitleMuteIconVisibility(0);
      if (this.eeV != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(29890);
      return;
      setTitleMuteIconVisibility(8);
      if (this.eeV != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private void b(ProgressDialog paramProgressDialog)
  {
    AppMethodBeat.i(29889);
    bf.a(this.contact.field_username, new SingleChatInfoUI.9(this, paramProgressDialog));
    this.handler.post(new SingleChatInfoUI.2(this));
    AppMethodBeat.o(29889);
  }
  
  private void dDh()
  {
    int j = 0;
    AppMethodBeat.i(29887);
    this.zfc = ((CheckBoxPreference)this.screen.atx("force_notify"));
    if ((ad.arf(this.contact.field_username)) || (r.nB(this.contact.field_username)))
    {
      this.screen.cl("force_notify", true);
      AppMethodBeat.o(29887);
      return;
    }
    long l = ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.forcenotify.a.b.class)).Om(this.contact.field_username);
    boolean bool = ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.forcenotify.a.b.class)).On(this.contact.field_username);
    this.zfc.vxW = bool;
    this.zfc.qH(bool);
    if (this.zfc.isChecked())
    {
      this.zfc.setSummary(getResources().getString(2131300128, new Object[] { new SimpleDateFormat("HH:mm").format(new Date(l)) }));
      if (this.sp == null) {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      }
      this.sp.edit().putBoolean("force_notify", this.zfc.isChecked()).commit();
      if (!this.zfc.isChecked()) {
        break label326;
      }
    }
    label326:
    for (int i = j;; i = 8)
    {
      setTitleForceNotifyIconVisibility(i);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(29887);
      return;
      this.zfc.setSummary(null);
      if (this.contact.DP()) {}
      for (i = 0;; i = 8)
      {
        setTitleMuteIconVisibility(i);
        break;
      }
    }
  }
  
  public com.tencent.mm.ui.base.preference.h createAdapter(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(29892);
    paramSharedPreferences = new com.tencent.mm.ui.base.preference.a(this, getListView(), paramSharedPreferences);
    AppMethodBeat.o(29892);
    return paramSharedPreferences;
  }
  
  public int getResourceId()
  {
    return 2131165265;
  }
  
  protected void initView()
  {
    AppMethodBeat.i(29886);
    if (this.contact == null)
    {
      ab.e("MicroMsg.SingleChatInfoUI", "[initView] contact is null!");
      finish();
    }
    this.screen = getPreferenceScreen();
    setMMTitle(getString(2131302817));
    this.eeU = ((ContactListExpandPreference)this.screen.atx("roominfo_contact_anchor"));
    this.eeU.a(this.screen, this.eeU.mKey);
    this.eeU.pf(true).pg(false);
    if ((this.contact != null) && (this.contact.field_deleteFlag == 1)) {
      this.eeU.pf(false);
    }
    if ((!com.tencent.mm.ui.contact.t.dMi()) && (this.contact != null) && (ad.arf(this.contact.field_username))) {
      this.eeU.pf(false);
    }
    this.eeV = ((CheckBoxPreference)this.screen.atx("room_notify_new_msg"));
    this.eeX = ((CheckBoxPreference)this.screen.atx("room_placed_to_the_top"));
    Object localObject = this.screen;
    boolean bool;
    if (!com.tencent.mm.n.a.je(this.contact.field_type))
    {
      bool = true;
      ((f)localObject).cl("force_notify", bool);
      if (this.sp == null) {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      }
      if (this.contact == null) {
        break label478;
      }
      localObject = this.sp.edit();
      aw.aaz();
      ((SharedPreferences.Editor)localObject).putBoolean("room_placed_to_the_top", c.YF().arP(this.contact.field_username)).commit();
      this.efg = this.contact.DP();
      this.sp.edit().putBoolean("room_notify_new_msg", this.efg).commit();
    }
    for (;;)
    {
      aw.aaz();
      this.efj = c.YC().TB(this.talker);
      this.screen.notifyDataSetChanged();
      if (this.eeU != null)
      {
        localObject = new LinkedList();
        ((List)localObject).add(this.talker);
        this.eeU.v(this.talker, (List)localObject);
        getListView().setOnScrollListener(this.efo);
        this.eeU.a(this.efo);
        this.eeU.a(new SingleChatInfoUI.5(this));
      }
      setBackBtn(new SingleChatInfoUI.6(this));
      AppMethodBeat.o(29886);
      return;
      bool = false;
      break;
      label478:
      this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      this.efg = false;
    }
  }
  
  public final void k(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(29891);
    if ((paramString1.equals(this.talker)) && (this.eeU != null)) {
      this.eeU.notifyChanged();
    }
    AppMethodBeat.o(29891);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(29885);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(29885);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(29885);
      return;
    }
    if (paramInt2 == -1)
    {
      finish();
      AppMethodBeat.o(29885);
      return;
    }
    AppMethodBeat.o(29885);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29881);
    super.onCreate(paramBundle);
    ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.forcenotify.a.b.class)).bzI().add(this.zfd);
    if (com.tencent.mm.bg.g.fUM != null) {
      com.tencent.mm.bg.g.fUM.a(this);
    }
    this.talker = getIntent().getStringExtra("Single_Chat_Talker");
    this.efl = getIntent().getBooleanExtra("fromChatting", false);
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.talker);
    if (this.contact == null)
    {
      ab.e("MicroMsg.SingleChatInfoUI", "contact is null! talker:%s", new Object[] { this.talker });
      finish();
      AppMethodBeat.o(29881);
      return;
    }
    this.eft = (getPackageName() + "_preferences");
    initView();
    ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.forcenotify.a.a.class)).g(this.contact.field_username, 3, cb.abq() / 1000L);
    AppMethodBeat.o(29881);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29884);
    ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.forcenotify.a.b.class)).bzI().remove(this.zfd);
    com.tencent.mm.ui.h.a.dismiss();
    if (com.tencent.mm.bg.g.fUM != null) {
      com.tencent.mm.bg.g.fUM.b(this);
    }
    super.onDestroy();
    AppMethodBeat.o(29884);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29883);
    super.onPause();
    AppMethodBeat.o(29883);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    boolean bool = true;
    AppMethodBeat.i(29888);
    paramf = paramPreference.mKey;
    if (paramf.equals("room_notify_new_msg")) {
      if (!this.efg)
      {
        this.efg = bool;
        if (!this.efg) {
          break label156;
        }
        com.tencent.mm.model.t.o(this.contact);
        label48:
        this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.talker);
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        this.sp.edit().putBoolean("room_notify_new_msg", this.efg).commit();
        JJ();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(29888);
      return false;
      bool = false;
      break;
      label156:
      com.tencent.mm.model.t.p(this.contact);
      break label48;
      if (paramf.equals("room_placed_to_the_top"))
      {
        paramf = getSharedPreferences(this.eft, 0);
        if (this.contact != null)
        {
          aw.aaz();
          if (c.YF().arP(this.contact.field_username)) {
            com.tencent.mm.model.t.y(this.contact.field_username, true);
          }
          for (;;)
          {
            paramf = paramf.edit();
            aw.aaz();
            paramf.putBoolean("room_placed_to_the_top", c.YF().arP(this.contact.field_username)).commit();
            break;
            com.tencent.mm.model.t.x(this.contact.field_username, true);
          }
        }
      }
      else if (paramf.equals("force_notify"))
      {
        if (!this.zfc.isChecked())
        {
          ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.forcenotify.a.b.class)).an(this.contact.field_username + "@wxcontact", 3);
          this.zfc.setSummary(null);
        }
        else
        {
          ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.forcenotify.a.b.class)).Ol(this.contact.field_username);
          long l = ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.forcenotify.a.b.class)).Om(this.contact.field_username);
          this.zfc.setSummary(getResources().getString(2131300128, new Object[] { new SimpleDateFormat("HH:mm").format(new Date(l)) }));
        }
      }
      else if (paramf.equals("room_set_chatting_background"))
      {
        paramf = new Intent();
        paramf.putExtra("isApplyToAll", false);
        paramf.putExtra("username", this.contact.field_username);
        com.tencent.mm.bq.d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", paramf, 2);
      }
      else if (paramf.equals("room_search_chatting_content"))
      {
        paramf = new Intent();
        paramf.putExtra("detail_username", this.talker);
        com.tencent.mm.plugin.fts.a.d.c(this, ".ui.FTSChattingConvUI", paramf);
        com.tencent.mm.plugin.report.service.h.qsU.e(14569, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      }
      else if (paramf.equals("room_clear_chatting_history"))
      {
        paramf = getString(2131300036, new Object[] { this.contact.Of() });
        com.tencent.mm.ui.base.h.a(getContext(), paramf, "", getString(2131296891), getString(2131296888), new SingleChatInfoUI.10(this), null, 2131689667);
      }
      else if (paramf.equals("room_expose"))
      {
        paramf = new Intent();
        paramf.putExtra("k_username", this.talker);
        paramf.putExtra("showShare", false);
        paramf.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(39) }));
        com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
      }
      else if (paramf.equals("chat_app_brand"))
      {
        paramf = new Intent();
        paramf.putExtra("Chat_User", this.talker);
        com.tencent.mm.bq.d.f(this, ".ui.chatting.gallery.AppBrandHistoryListUI", paramf);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(219L, 25L, 1L, true);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29882);
    JJ();
    Object localObject;
    if (this.eeU != null)
    {
      localObject = new LinkedList();
      ((List)localObject).add(this.talker);
      this.eeU.v(this.talker, (List)localObject);
    }
    dDh();
    this.screen.notifyDataSetChanged();
    super.onResume();
    if (!this.efp)
    {
      localObject = getIntent().getStringExtra("need_matte_high_light_item");
      if (!ah.isNullOrNil((String)localObject))
      {
        int i = this.screen.atz((String)localObject);
        setSelection(i - 3);
        new ak().postDelayed(new SingleChatInfoUI.4(this, i), 10L);
      }
      this.efp = true;
    }
    AppMethodBeat.o(29882);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.SingleChatInfoUI
 * JD-Core Version:    0.7.0.1
 */