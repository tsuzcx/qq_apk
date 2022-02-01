package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.qi;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.findersdk.a.bv;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.h;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.protocal.protobuf.fjk;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.f.n;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsPrivacyUI
  extends MMPreference
{
  private boolean Prm;
  private boolean PuW;
  private boolean PvA;
  private boolean PvB;
  private fjk PvC;
  private int PvD;
  private long Pvw;
  private boolean Pvx;
  private boolean Pvy;
  private boolean Pvz;
  boolean lAt;
  private String ltf;
  private HashMap<Integer, Integer> pPy;
  private com.tencent.mm.ui.base.preference.f screen;
  private int status;
  private long xct;
  
  public SettingsPrivacyUI()
  {
    AppMethodBeat.i(74347);
    this.pPy = new HashMap();
    this.ltf = "";
    this.PuW = true;
    this.Prm = false;
    this.Pvx = false;
    this.Pvy = false;
    this.Pvz = false;
    this.PvA = false;
    this.PvB = true;
    this.PvC = null;
    this.lAt = false;
    this.PvD = f.n.adwG;
    AppMethodBeat.o(74347);
  }
  
  private void a(LinearLayout paramLinearLayout, int paramInt1, int paramInt2, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(74355);
    TextView localTextView = (TextView)View.inflate(getContext(), b.g.radio_btn_item, null);
    localTextView.setText(paramInt1);
    localTextView.setTag(Integer.valueOf(paramInt2));
    paramLinearLayout.addView(localTextView);
    localTextView.setOnClickListener(paramOnClickListener);
    if (paramBoolean) {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(b.h.radio_on, 0, 0, 0);
    }
    AppMethodBeat.o(74355);
  }
  
  private boolean afN(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private void evt()
  {
    AppMethodBeat.i(74358);
    Object localObject = new ffs();
    fjk localfjk = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).getStoryUserInfo();
    if (q.Qki != null) {
      localObject = q.Qki.aWV(this.ltf);
    }
    for (;;)
    {
      if (localObject == null)
      {
        Log.e("MicroMsg.SettingPrivacy", "userinfo is null");
        AppMethodBeat.o(74358);
        return;
      }
      boolean bool;
      if ((com.tencent.mm.br.c.blq("sns")) && ((z.bBf() & 0x8000) == 0))
      {
        bool = true;
        this.PuW = bool;
        localObject = new StringBuilder("isSnsOpenEntrance ").append(this.PuW).append(", install ").append(com.tencent.mm.br.c.blq("sns")).append(", flag ");
        if ((z.bBf() & 0x8000) != 0) {
          break label243;
        }
        bool = true;
        label133:
        Log.i("MicroMsg.SettingPrivacy", bool);
        if (!this.PuW) {
          break label248;
        }
        this.screen.eh("settings_story_notify", false);
        label166:
        if (this.PuW)
        {
          localObject = (CheckBoxPreference)this.screen.bAi("settings_story_notify");
          if (localObject != null)
          {
            ((Preference)localObject).adZV = false;
            if (localfjk.abKd != 0) {
              break label264;
            }
            bool = true;
            label206:
            this.PvB = bool;
            if (!this.PvB) {
              break label269;
            }
            ((CheckBoxPreference)localObject).setChecked(true);
          }
        }
      }
      for (;;)
      {
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(74358);
        return;
        bool = false;
        break;
        label243:
        bool = false;
        break label133;
        label248:
        this.screen.eh("settings_story_notify", true);
        break label166;
        label264:
        bool = false;
        break label206;
        label269:
        ((CheckBoxPreference)localObject).setChecked(false);
      }
    }
  }
  
  private boolean s(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74357);
    Log.d("MicroMsg.SettingPrivacy", "switch change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
    if (paramBoolean)
    {
      this.status |= paramInt1;
      if (!paramBoolean) {
        break label107;
      }
    }
    label107:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      this.pPy.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      AppMethodBeat.o(74357);
      return true;
      this.status &= (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  public com.tencent.mm.ui.base.preference.h createAdapter(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(74348);
    paramSharedPreferences = new com.tencent.mm.ui.base.preference.a(this, getListView(), paramSharedPreferences);
    AppMethodBeat.o(74348);
    return paramSharedPreferences;
  }
  
  public int getResourceId()
  {
    return b.k.settings_about_privacy;
  }
  
  public void initView()
  {
    boolean bool2 = true;
    AppMethodBeat.i(74356);
    setMMTitle(b.i.settings_about_privacy);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74346);
        SettingsPrivacyUI.this.hideVKB();
        SettingsPrivacyUI.this.finish();
        AppMethodBeat.o(74346);
        return true;
      }
    });
    Log.i("MicroMsg.SettingPrivacy", "init function status: " + Integer.toBinaryString(this.status) + "extStatus: " + Long.toBinaryString(this.xct) + " FinderSetting: " + Long.toBinaryString(this.Pvw));
    Object localObject1 = (CheckBoxPreference)this.screen.bAi("settings_need_verify");
    ((Preference)localObject1).adZV = false;
    ((CheckBoxPreference)localObject1).setChecked(afN(32));
    localObject1 = (String)com.tencent.mm.kernel.h.baE().ban().d(6, null);
    Object localObject2 = (CheckBoxPreference)this.screen.bAi("settings_recommend_mobilefriends_to_me");
    ((Preference)localObject2).adZV = false;
    if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
      if (!afN(256))
      {
        bool1 = true;
        ((CheckBoxPreference)localObject2).setChecked(bool1);
        label186:
        localObject1 = (CheckBoxPreference)this.screen.bAi("settings_find_google_contact");
        ((Preference)localObject1).adZV = false;
        if (afN(1048576)) {
          break label304;
        }
      }
    }
    label304:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((CheckBoxPreference)localObject1).setChecked(bool1);
      localObject2 = (String)com.tencent.mm.kernel.h.baE().ban().d(208903, null);
      if ((!Util.isOverseasUser(this)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        this.screen.e((Preference)localObject1);
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74356);
      return;
      bool1 = false;
      break;
      this.screen.e((Preference)localObject2);
      break label186;
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(74349);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    this.status = z.bAQ();
    this.xct = z.bAR();
    this.Pvw = ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderSwitchApi().ffD();
    this.ltf = z.bAM();
    this.PvC = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).getStoryUserInfo();
    boolean bool1;
    int i;
    label242:
    label380:
    boolean bool2;
    if (this.PvC.abKd == 0)
    {
      bool1 = true;
      this.PvB = bool1;
      this.PvD = getIntent().getIntExtra("enter_scene", f.n.adwG);
      Log.d("MicroMsg.SettingPrivacy", "story Notify:%s", new Object[] { Boolean.valueOf(this.PvB) });
      initView();
      com.tencent.mm.plugin.report.service.h.OAn.b(14098, new Object[] { Integer.valueOf(9) });
      if ((this.PvD == f.n.adwH) || (this.PvD == f.n.adwI))
      {
        paramBundle = new ffs();
        if (q.Qki != null) {
          paramBundle = q.Qki.aWV(this.ltf);
        }
        if (paramBundle != null)
        {
          i = paramBundle.abFF;
          int j = paramBundle.abFG;
          if ((j != 4320) || ((i & 0x1000) <= 0)) {
            break label527;
          }
          bool1 = true;
          this.Pvx = bool1;
          if ((j != 72) || ((i & 0x1000) <= 0)) {
            break label533;
          }
          bool1 = true;
          label265:
          this.Pvy = bool1;
          if ((j != 720) || ((i & 0x1000) <= 0)) {
            break label539;
          }
          bool1 = true;
          label289:
          this.PvA = bool1;
          if ((i & 0x800) <= 0) {
            break label545;
          }
          bool1 = true;
          label306:
          this.Pvz = bool1;
        }
        paramBundle = new ffs();
        if (q.Qki != null) {
          paramBundle = q.Qki.aWV(this.ltf);
        }
        if (paramBundle != null) {
          break label551;
        }
        Log.e("MicroMsg.SettingPrivacy", "userinfo is null");
      }
      boolean bool3 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).showFinderEntry();
      if ((z.bAR() & 0x0) == 0L) {
        break label812;
      }
      i = 1;
      if (i != 0) {
        break label817;
      }
      bool1 = true;
      label387:
      if ((!((d)com.tencent.mm.kernel.h.ax(d.class)).aBu()) || (((d)com.tencent.mm.kernel.h.ax(d.class)).eZD() != 2)) {
        break label823;
      }
      bool2 = true;
      label425:
      Log.i("MicroMsg.SettingPrivacy", "[isShowFinderEntrance] show:%s open:%s, isTeenModeAndNothing:%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool3) || (!bool1) || (bool2)) {
        break label829;
      }
      i = 1;
      label478:
      if (i == 0) {
        break label834;
      }
      this.screen.eh("setting_privacy_video_item", false);
    }
    for (;;)
    {
      paramBundle = new qi();
      paramBundle.ikE = 1L;
      paramBundle.bMH();
      AppMethodBeat.o(74349);
      return;
      bool1 = false;
      break;
      label527:
      bool1 = false;
      break label242;
      label533:
      bool1 = false;
      break label265;
      label539:
      bool1 = false;
      break label289;
      label545:
      bool1 = false;
      break label306;
      label551:
      i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acQp, Integer.valueOf(0))).intValue();
      if (i > ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acQq, Integer.valueOf(0))).intValue())
      {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acQq, Integer.valueOf(i));
        evt();
      }
      Object localObject = new e.a(getContext());
      ((e.a)localObject).aES(b.i.app_cancel);
      ((e.a)localObject).aEK(b.i.contact_info_feedsapp_recent_select);
      View localView = View.inflate(getContext(), b.g.mm_alert_switch, null);
      paramBundle = (LinearLayout)localView.findViewById(b.f.switcher_container);
      View.OnClickListener local2 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74345);
          Object localObject = new b();
          ((b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
          int i = 0;
          while (i < paramBundle.getChildCount())
          {
            localObject = (TextView)paramBundle.getChildAt(i);
            if (b.f.tips_tv != ((TextView)localObject).getId()) {
              ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(b.h.radio_off, 0, 0, 0);
            }
            i += 1;
          }
          ((TextView)paramAnonymousView).setCompoundDrawablesWithIntrinsicBounds(b.h.radio_on, 0, 0, 0);
          localObject = new ffs();
          if (q.Qki != null) {
            localObject = q.Qki.aWV(SettingsPrivacyUI.b(SettingsPrivacyUI.this));
          }
          if (localObject == null)
          {
            Log.e("MicroMsg.SettingPrivacy", "userinfo is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74345);
            return;
          }
          i = ((Integer)paramAnonymousView.getTag()).intValue();
          Log.i("MicroMsg.SettingPrivacy", "settings_silence_update_mode choice: %d", new Object[] { Integer.valueOf(i) });
          if (i == 0)
          {
            if (SettingsPrivacyUI.c(SettingsPrivacyUI.this) == f.n.adwH) {
              com.tencent.mm.plugin.report.service.h.OAn.b(14090, new Object[] { Integer.valueOf(4) });
            }
            SettingsPrivacyUI.a(SettingsPrivacyUI.this, false);
            SettingsPrivacyUI.b(SettingsPrivacyUI.this, true);
            SettingsPrivacyUI.c(SettingsPrivacyUI.this, false);
            SettingsPrivacyUI.d(SettingsPrivacyUI.this);
          }
          for (;;)
          {
            if (q.Qki != null) {
              q.Qki.a(SettingsPrivacyUI.b(SettingsPrivacyUI.this), SettingsPrivacyUI.e(SettingsPrivacyUI.this), SettingsPrivacyUI.f(SettingsPrivacyUI.this), SettingsPrivacyUI.g(SettingsPrivacyUI.this), SettingsPrivacyUI.h(SettingsPrivacyUI.this));
            }
            if (q.Qki == null) {
              break label631;
            }
            localObject = q.Qki.b(SettingsPrivacyUI.b(SettingsPrivacyUI.this), SettingsPrivacyUI.e(SettingsPrivacyUI.this), SettingsPrivacyUI.f(SettingsPrivacyUI.this), SettingsPrivacyUI.g(SettingsPrivacyUI.this), SettingsPrivacyUI.h(SettingsPrivacyUI.this));
            if (localObject != null) {
              break;
            }
            Log.e("MicroMsg.SettingPrivacy", "userinfo in null !");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74345);
            return;
            if (i == 1)
            {
              if (SettingsPrivacyUI.c(SettingsPrivacyUI.this) == f.n.adwH) {
                com.tencent.mm.plugin.report.service.h.OAn.b(14090, new Object[] { Integer.valueOf(5) });
              }
              SettingsPrivacyUI.a(SettingsPrivacyUI.this, true);
              SettingsPrivacyUI.b(SettingsPrivacyUI.this, false);
              SettingsPrivacyUI.c(SettingsPrivacyUI.this, false);
              SettingsPrivacyUI.d(SettingsPrivacyUI.this);
            }
            else if (i == 3)
            {
              SettingsPrivacyUI.a(SettingsPrivacyUI.this, false);
              SettingsPrivacyUI.b(SettingsPrivacyUI.this, false);
              SettingsPrivacyUI.c(SettingsPrivacyUI.this, true);
              SettingsPrivacyUI.d(SettingsPrivacyUI.this);
            }
            else
            {
              if (SettingsPrivacyUI.c(SettingsPrivacyUI.this) == f.n.adwH) {
                com.tencent.mm.plugin.report.service.h.OAn.b(14090, new Object[] { Integer.valueOf(6) });
              }
              SettingsPrivacyUI.a(SettingsPrivacyUI.this, false);
              SettingsPrivacyUI.b(SettingsPrivacyUI.this, false);
              SettingsPrivacyUI.c(SettingsPrivacyUI.this, false);
              SettingsPrivacyUI.d(SettingsPrivacyUI.this);
            }
          }
          Log.d("MicroMsg.SettingPrivacy", "dancy userinfo " + localObject.toString());
          ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(51, (com.tencent.mm.bx.a)localObject));
          label631:
          paramAnonymousView.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(74344);
              ((Dialog)SettingsPrivacyUI.2.this.Prc.getTag()).dismiss();
              SettingsPrivacyUI.i(SettingsPrivacyUI.this);
              AppMethodBeat.o(74344);
            }
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74345);
        }
      };
      a(paramBundle, b.i.contact_info_feedsapp_recent_select_half_year, 1, this.Pvx, local2);
      a(paramBundle, b.i.contact_info_feedsapp_recent_select_one_month, 3, this.PvA, local2);
      a(paramBundle, b.i.contact_info_feedsapp_recent_select_three_day, 0, this.Pvy, local2);
      i = b.i.contact_info_feedsapp_recent_select_all;
      if ((!this.Pvx) && (!this.Pvy) && (!this.PvA)) {}
      for (bool1 = true;; bool1 = false)
      {
        a(paramBundle, i, 2, bool1, local2);
        ((e.a)localObject).md(localView);
        localObject = ((e.a)localObject).jHH();
        paramBundle.setTag(localObject);
        ((com.tencent.mm.ui.widget.a.e)localObject).show();
        addDialog((Dialog)localObject);
        break;
      }
      label812:
      i = 0;
      break label380;
      label817:
      bool1 = false;
      break label387;
      label823:
      bool2 = false;
      break label425;
      label829:
      i = 0;
      break label478;
      label834:
      this.screen.eh("setting_privacy_video_item", true);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74352);
    super.onDestroy();
    AppMethodBeat.o(74352);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74351);
    super.onPause();
    com.tencent.mm.kernel.h.baE().ban().B(7, Integer.valueOf(this.status));
    com.tencent.mm.kernel.h.baE().ban().B(147457, Long.valueOf(this.xct));
    ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderSwitchApi().qG(this.Pvw);
    Iterator localIterator = this.pPy.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new cas();
      ((cas)localObject).aajJ = i;
      ((cas)localObject).NkL = j;
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(23, (com.tencent.mm.bx.a)localObject));
      Log.d("MicroMsg.SettingPrivacy", "switch  " + i + " " + j);
    }
    this.pPy.clear();
    AppMethodBeat.o(74351);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    boolean bool = false;
    AppMethodBeat.i(74353);
    paramPreference = paramPreference.mKey;
    Log.i("MicroMsg.SettingPrivacy", paramPreference + " item has been clicked!");
    getDefaultSharedPreferences();
    if (paramPreference.equals("settings_need_verify"))
    {
      bool = s(((CheckBoxPreference)paramf.bAi("settings_need_verify")).isChecked(), 32, 4);
      AppMethodBeat.o(74353);
      return bool;
    }
    if (paramPreference.equals("settings_recommend_mobilefriends_to_me"))
    {
      if (!((CheckBoxPreference)paramf.bAi("settings_recommend_mobilefriends_to_me")).isChecked()) {}
      for (bool = true;; bool = false)
      {
        bool = s(bool, 256, 7);
        AppMethodBeat.o(74353);
        return bool;
      }
    }
    if (paramPreference.equals("settings_about_blacklist"))
    {
      paramf = ai.Js(getString(b.i.group_blacklist));
      paramPreference = new Intent();
      paramPreference.putExtra("filter_type", paramf.getType());
      paramPreference.putExtra("titile", getString(b.i.settings_private_blacklist));
      paramPreference.putExtra("list_attr", 32768);
      com.tencent.mm.plugin.setting.c.pFn.h(this, paramPreference);
      AppMethodBeat.o(74353);
      return true;
    }
    if (paramPreference.equals("setting_privacy_chatting_item"))
    {
      paramf = new Intent();
      paramf.addFlags(268435456);
      paramf.putExtra("intent_status_show_bottom_tips", getString(b.i.contact_mgr_address_contact_only_chat_desc));
      paramf.setClassName(this, "com.tencent.mm.ui.contact.privacy.ContactMgrOnlyChatUI");
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74353);
      return true;
    }
    if (paramPreference.equals("setting_privacy_sns_item"))
    {
      paramf = new Intent(this, SettingsSnsPrivacyUI.class);
      paramf.putExtra("need_matte_high_light_item", getIntent().getStringExtra("need_matte_high_light_item"));
      paramf.putExtra("enter_scene", getIntent().getIntExtra("enter_scene", f.n.adwG));
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74353);
      return true;
    }
    if (paramPreference.equals("setting_privacy_video_item"))
    {
      paramf = new Intent();
      paramf.addFlags(268435456);
      paramf.putExtra("intent_status_from_privacy_to_video_setting", true);
      com.tencent.mm.br.c.b(this, "finder", ".ui.FinderManagementUI", paramf);
      AppMethodBeat.o(74353);
      return true;
    }
    if (paramPreference.equals("setting_privacy_watch_item"))
    {
      paramf = new Intent();
      paramf.putExtra("intent_status_from_privacy_to_tophistory_setting", true);
      aj.f(this, ".ui.home.TopStorySettingUI", paramf);
      AppMethodBeat.o(74353);
      return true;
    }
    if (paramPreference.equals("setting_privacy_wx_sport_item"))
    {
      paramf = new Intent();
      paramf.setClassName(this, "com.tencent.mm.ui.contact.privacy.SportBlackListUI");
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74353);
      return true;
    }
    if (paramPreference.equals("settings_find_google_contact"))
    {
      if (!((CheckBoxPreference)paramf.bAi("settings_find_google_contact")).isChecked()) {
        bool = true;
      }
      s(bool, 1048576, 29);
      AppMethodBeat.o(74353);
      return true;
    }
    if (paramPreference.equals("settings_add_me_way"))
    {
      paramf = new Intent(this, SettingsAddMeUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74353);
      return true;
    }
    if (paramPreference.equals("settings_auth_manage")) {
      if (WeChatBrands.Business.Entries.MeSetPrivacyPermissions.checkAvailable(this))
      {
        paramf = new Intent(this, SettingsManageAuthUI.class);
        paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(74353);
      return false;
      if (paramPreference.equals("settings_story_notify"))
      {
        if (!this.PvB)
        {
          bool = true;
          this.PvB = bool;
          if (!this.PvB) {
            break label1068;
          }
        }
        label1068:
        for (this.PvC.abKd = 0;; this.PvC.abKd = 1)
        {
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).updateStoryUserInfo(this.ltf, this.PvC);
          ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(71, this.PvC));
          evt();
          AppMethodBeat.o(74353);
          return true;
          bool = false;
          break;
        }
      }
      if (paramPreference.equals("settings_ad_manage"))
      {
        paramf = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zvH, "");
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", String.format(paramf, new Object[] { LocaleUtil.getCurrentLanguage(this), LocaleUtil.getCurrentCountryCode() }));
        paramPreference.putExtra("showShare", false);
        paramPreference.putExtra("show_bottom", false);
        com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74350);
    super.onResume();
    this.status = z.bAQ();
    this.xct = z.bAR();
    this.Pvw = ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderSwitchApi().ffD();
    evt();
    if (!this.lAt)
    {
      String str = getIntent().getStringExtra("need_matte_high_light_item");
      if (!Util.isNullOrNil(str))
      {
        final int i = this.screen.bAl(str);
        setSelection(i - 3);
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74343);
            View localView = ((com.tencent.mm.ui.base.preference.a)SettingsPrivacyUI.a(SettingsPrivacyUI.this)).a(i, SettingsPrivacyUI.this.getListView());
            if (localView != null) {
              com.tencent.mm.ui.j.a.d(SettingsPrivacyUI.this.getContext(), localView);
            }
            AppMethodBeat.o(74343);
          }
        }, 10L);
      }
      this.lAt = true;
    }
    AppMethodBeat.o(74350);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI
 * JD-Core Version:    0.7.0.1
 */