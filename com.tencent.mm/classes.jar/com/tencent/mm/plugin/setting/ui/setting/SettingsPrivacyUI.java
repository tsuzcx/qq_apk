package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.findersdk.a.ad;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.h;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.protocal.protobuf.elj;
import com.tencent.mm.protocal.protobuf.eom;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.f.m;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsPrivacyUI
  extends MMPreference
{
  private boolean Jgu;
  private boolean JiP;
  private long Jje;
  private boolean Jjf;
  private boolean Jjg;
  private boolean Jjh;
  private boolean Jji;
  private boolean Jjj;
  private eom Jjk;
  private int Jjl;
  private String iRj;
  boolean iYB;
  private HashMap<Integer, Integer> mSR;
  private com.tencent.mm.ui.base.preference.f screen;
  private int status;
  private long tZb;
  
  public SettingsPrivacyUI()
  {
    AppMethodBeat.i(74347);
    this.mSR = new HashMap();
    this.iRj = "";
    this.JiP = true;
    this.Jgu = false;
    this.Jjf = false;
    this.Jjg = false;
    this.Jjh = false;
    this.Jji = false;
    this.Jjj = true;
    this.Jjk = null;
    this.iYB = false;
    this.Jjl = f.m.VSx;
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
  
  private boolean abt(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private void dFf()
  {
    AppMethodBeat.i(74358);
    Object localObject = new elj();
    eom localeom = ((e)com.tencent.mm.kernel.h.ag(e.class)).getStoryUserInfo();
    if (p.JPd != null) {
      localObject = p.JPd.aYN(this.iRj);
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
      if ((com.tencent.mm.by.c.blP("sns")) && ((z.bdn() & 0x8000) == 0))
      {
        bool = true;
        this.JiP = bool;
        localObject = new StringBuilder("isSnsOpenEntrance ").append(this.JiP).append(", install ").append(com.tencent.mm.by.c.blP("sns")).append(", flag ");
        if ((z.bdn() & 0x8000) != 0) {
          break label243;
        }
        bool = true;
        label133:
        Log.i("MicroMsg.SettingPrivacy", bool);
        if (!this.JiP) {
          break label248;
        }
        this.screen.dz("settings_story_notify", false);
        label166:
        if (this.JiP)
        {
          localObject = (CheckBoxPreference)this.screen.byG("settings_story_notify");
          if (localObject != null)
          {
            ((Preference)localObject).WsF = false;
            if (localeom.Ure != 0) {
              break label264;
            }
            bool = true;
            label206:
            this.Jjj = bool;
            if (!this.Jjj) {
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
        this.screen.dz("settings_story_notify", true);
        break label166;
        label264:
        bool = false;
        break label206;
        label269:
        ((CheckBoxPreference)localObject).setChecked(false);
      }
    }
  }
  
  private boolean p(boolean paramBoolean, int paramInt1, int paramInt2)
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
      this.mSR.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
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
    boolean bool2 = false;
    AppMethodBeat.i(74356);
    setMMTitle(b.i.settings_about_privacy);
    setBackBtn(new SettingsPrivacyUI.3(this));
    Log.i("MicroMsg.SettingPrivacy", "init function status: " + Integer.toBinaryString(this.status) + "extStatus: " + Long.toBinaryString(this.tZb) + " FinderSetting: " + Long.toBinaryString(this.Jje));
    Object localObject1 = (CheckBoxPreference)this.screen.byG("settings_need_verify");
    ((Preference)localObject1).WsF = false;
    ((CheckBoxPreference)localObject1).setChecked(abt(32));
    localObject1 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(6, null);
    Object localObject2 = (CheckBoxPreference)this.screen.byG("settings_recommend_mobilefriends_to_me");
    ((Preference)localObject2).WsF = false;
    boolean bool1;
    if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
      if (!abt(256))
      {
        bool1 = true;
        ((CheckBoxPreference)localObject2).setChecked(bool1);
      }
    }
    for (;;)
    {
      localObject1 = (CheckBoxPreference)this.screen.byG("settings_find_google_contact");
      ((Preference)localObject1).WsF = false;
      bool1 = bool2;
      if (!abt(1048576)) {
        bool1 = true;
      }
      ((CheckBoxPreference)localObject1).setChecked(bool1);
      localObject2 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(208903, null);
      if ((!Util.isOverseasUser(this)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        this.screen.d((Preference)localObject1);
      }
      localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wcb, "");
      localObject2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wcc, "");
      String str = (String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, "");
      if ((Util.isNullOrNil((String)localObject1)) || (((String)localObject2).toLowerCase().contains(str.toLowerCase()))) {
        this.screen.dz("settings_ad_manage", true);
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74356);
      return;
      bool1 = false;
      break;
      this.screen.d((Preference)localObject2);
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(74349);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    this.status = z.bdd();
    this.tZb = z.bde();
    this.Jje = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderSwitchApi().edM();
    this.iRj = z.bcZ();
    this.Jjk = ((e)com.tencent.mm.kernel.h.ag(e.class)).getStoryUserInfo();
    boolean bool1;
    label242:
    label380:
    boolean bool2;
    if (this.Jjk.Ure == 0)
    {
      bool1 = true;
      this.Jjj = bool1;
      this.Jjl = getIntent().getIntExtra("enter_scene", f.m.VSx);
      Log.d("MicroMsg.SettingPrivacy", "story Notify:%s", new Object[] { Boolean.valueOf(this.Jjj) });
      initView();
      com.tencent.mm.plugin.report.service.h.IzE.a(14098, new Object[] { Integer.valueOf(9) });
      if ((this.Jjl == f.m.VSy) || (this.Jjl == f.m.VSz))
      {
        paramBundle = new elj();
        if (p.JPd != null) {
          paramBundle = p.JPd.aYN(this.iRj);
        }
        if (paramBundle != null)
        {
          i = paramBundle.Unw;
          int j = paramBundle.Unx;
          if ((j != 4320) || ((i & 0x1000) <= 0)) {
            break label509;
          }
          bool1 = true;
          this.Jjf = bool1;
          if ((j != 72) || ((i & 0x1000) <= 0)) {
            break label515;
          }
          bool1 = true;
          label265:
          this.Jjg = bool1;
          if ((j != 720) || ((i & 0x1000) <= 0)) {
            break label521;
          }
          bool1 = true;
          label289:
          this.Jji = bool1;
          if ((i & 0x800) <= 0) {
            break label527;
          }
          bool1 = true;
          label306:
          this.Jjh = bool1;
        }
        paramBundle = new elj();
        if (p.JPd != null) {
          paramBundle = p.JPd.aYN(this.iRj);
        }
        if (paramBundle != null) {
          break label533;
        }
        Log.e("MicroMsg.SettingPrivacy", "userinfo is null");
      }
      boolean bool3 = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).showFinderEntry();
      if ((z.bde() & 0x0) == 0L) {
        break label794;
      }
      i = 1;
      if (i != 0) {
        break label799;
      }
      bool1 = true;
      label387:
      if ((!((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM()) || (((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).dYS() != 2)) {
        break label805;
      }
      bool2 = true;
      label425:
      Log.i("MicroMsg.SettingPrivacy", "[isShowFinderEntrance] show:%s open:%s, isTeenModeAndNothing:%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool3) || (!bool1) || (bool2)) {
        break label811;
      }
    }
    label515:
    label521:
    label527:
    label533:
    label794:
    label799:
    label805:
    label811:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label816;
      }
      this.screen.dz("setting_privacy_video_item", false);
      AppMethodBeat.o(74349);
      return;
      bool1 = false;
      break;
      label509:
      bool1 = false;
      break label242;
      bool1 = false;
      break label265;
      bool1 = false;
      break label289;
      bool1 = false;
      break label306;
      i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VoT, Integer.valueOf(0))).intValue();
      if (i > ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VoU, Integer.valueOf(0))).intValue())
      {
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VoU, Integer.valueOf(i));
        dFf();
      }
      Object localObject = new d.a(getContext());
      ((d.a)localObject).ayk(b.i.app_cancel);
      ((d.a)localObject).ayc(b.i.contact_info_feedsapp_recent_select);
      View localView = View.inflate(getContext(), b.g.mm_alert_switch, null);
      paramBundle = (LinearLayout)localView.findViewById(b.f.switcher_container);
      View.OnClickListener local2 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74345);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
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
          localObject = new elj();
          if (p.JPd != null) {
            localObject = p.JPd.aYN(SettingsPrivacyUI.b(SettingsPrivacyUI.this));
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
            if (SettingsPrivacyUI.c(SettingsPrivacyUI.this) == f.m.VSy) {
              com.tencent.mm.plugin.report.service.h.IzE.a(14090, new Object[] { Integer.valueOf(4) });
            }
            SettingsPrivacyUI.a(SettingsPrivacyUI.this, false);
            SettingsPrivacyUI.b(SettingsPrivacyUI.this, true);
            SettingsPrivacyUI.c(SettingsPrivacyUI.this, false);
            SettingsPrivacyUI.d(SettingsPrivacyUI.this);
          }
          for (;;)
          {
            if (p.JPd != null) {
              p.JPd.a(SettingsPrivacyUI.b(SettingsPrivacyUI.this), SettingsPrivacyUI.e(SettingsPrivacyUI.this), SettingsPrivacyUI.f(SettingsPrivacyUI.this), SettingsPrivacyUI.g(SettingsPrivacyUI.this), SettingsPrivacyUI.h(SettingsPrivacyUI.this));
            }
            if (p.JPd == null) {
              break label631;
            }
            localObject = p.JPd.b(SettingsPrivacyUI.b(SettingsPrivacyUI.this), SettingsPrivacyUI.e(SettingsPrivacyUI.this), SettingsPrivacyUI.f(SettingsPrivacyUI.this), SettingsPrivacyUI.g(SettingsPrivacyUI.this), SettingsPrivacyUI.h(SettingsPrivacyUI.this));
            if (localObject != null) {
              break;
            }
            Log.e("MicroMsg.SettingPrivacy", "userinfo in null !");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74345);
            return;
            if (i == 1)
            {
              if (SettingsPrivacyUI.c(SettingsPrivacyUI.this) == f.m.VSy) {
                com.tencent.mm.plugin.report.service.h.IzE.a(14090, new Object[] { Integer.valueOf(5) });
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
              if (SettingsPrivacyUI.c(SettingsPrivacyUI.this) == f.m.VSy) {
                com.tencent.mm.plugin.report.service.h.IzE.a(14090, new Object[] { Integer.valueOf(6) });
              }
              SettingsPrivacyUI.a(SettingsPrivacyUI.this, false);
              SettingsPrivacyUI.b(SettingsPrivacyUI.this, false);
              SettingsPrivacyUI.c(SettingsPrivacyUI.this, false);
              SettingsPrivacyUI.d(SettingsPrivacyUI.this);
            }
          }
          Log.d("MicroMsg.SettingPrivacy", "dancy userinfo " + localObject.toString());
          ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(51, (com.tencent.mm.cd.a)localObject));
          label631:
          paramAnonymousView.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(74344);
              ((Dialog)SettingsPrivacyUI.2.this.Jgk.getTag()).dismiss();
              SettingsPrivacyUI.i(SettingsPrivacyUI.this);
              AppMethodBeat.o(74344);
            }
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74345);
        }
      };
      a(paramBundle, b.i.contact_info_feedsapp_recent_select_half_year, 1, this.Jjf, local2);
      a(paramBundle, b.i.contact_info_feedsapp_recent_select_one_month, 3, this.Jji, local2);
      a(paramBundle, b.i.contact_info_feedsapp_recent_select_three_day, 0, this.Jjg, local2);
      i = b.i.contact_info_feedsapp_recent_select_all;
      if ((!this.Jjf) && (!this.Jjg) && (!this.Jji)) {}
      for (bool1 = true;; bool1 = false)
      {
        a(paramBundle, i, 2, bool1, local2);
        ((d.a)localObject).iI(localView);
        localObject = ((d.a)localObject).icu();
        paramBundle.setTag(localObject);
        ((d)localObject).show();
        addDialog((Dialog)localObject);
        break;
      }
      i = 0;
      break label380;
      bool1 = false;
      break label387;
      bool2 = false;
      break label425;
    }
    label816:
    this.screen.dz("setting_privacy_video_item", true);
    AppMethodBeat.o(74349);
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
    com.tencent.mm.kernel.h.aHG().aHp().i(7, Integer.valueOf(this.status));
    com.tencent.mm.kernel.h.aHG().aHp().i(147457, Long.valueOf(this.tZb));
    ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderSwitchApi().Nd(this.Jje);
    Iterator localIterator = this.mSR.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new bmy();
      ((bmy)localObject).SXP = i;
      ((bmy)localObject).HmX = j;
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(23, (com.tencent.mm.cd.a)localObject));
      Log.d("MicroMsg.SettingPrivacy", "switch  " + i + " " + j);
    }
    this.mSR.clear();
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
      bool = p(((CheckBoxPreference)paramf.byG("settings_need_verify")).isChecked(), 32, 4);
      AppMethodBeat.o(74353);
      return bool;
    }
    if (paramPreference.equals("settings_recommend_mobilefriends_to_me"))
    {
      if (!((CheckBoxPreference)paramf.byG("settings_recommend_mobilefriends_to_me")).isChecked()) {}
      for (bool = true;; bool = false)
      {
        bool = p(bool, 256, 7);
        AppMethodBeat.o(74353);
        return bool;
      }
    }
    if (paramPreference.equals("settings_about_blacklist"))
    {
      paramf = com.tencent.mm.model.ai.Rt(getString(b.i.group_blacklist));
      paramPreference = new Intent();
      paramPreference.putExtra("filter_type", paramf.getType());
      paramPreference.putExtra("titile", getString(b.i.settings_private_blacklist));
      paramPreference.putExtra("list_attr", 32768);
      com.tencent.mm.plugin.setting.c.mIG.h(this, paramPreference);
      AppMethodBeat.o(74353);
      return true;
    }
    if (paramPreference.equals("setting_privacy_chatting_item"))
    {
      paramf = new Intent();
      paramf.addFlags(268435456);
      paramf.putExtra("intent_status_show_bottom_tips", getString(b.i.contact_mgr_address_contact_only_chat_desc));
      paramf.setClassName(this, "com.tencent.mm.ui.contact.privacy.ContactMgrOnlyChatUI");
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74353);
      return true;
    }
    if (paramPreference.equals("setting_privacy_sns_item"))
    {
      paramf = new Intent(this, SettingsSnsPrivacyUI.class);
      paramf.putExtra("need_matte_high_light_item", getIntent().getStringExtra("need_matte_high_light_item"));
      paramf.putExtra("enter_scene", getIntent().getIntExtra("enter_scene", f.m.VSx));
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74353);
      return true;
    }
    if (paramPreference.equals("setting_privacy_video_item"))
    {
      paramf = new Intent();
      paramf.addFlags(268435456);
      paramf.putExtra("intent_status_from_privacy_to_video_setting", true);
      com.tencent.mm.by.c.b(this, "finder", ".ui.FinderManagementUI", paramf);
      AppMethodBeat.o(74353);
      return true;
    }
    if (paramPreference.equals("setting_privacy_watch_item"))
    {
      paramf = new Intent();
      paramf.putExtra("intent_status_from_privacy_to_tophistory_setting", true);
      com.tencent.mm.plugin.websearch.api.ai.e(this, ".ui.home.TopStorySettingUI", paramf);
      AppMethodBeat.o(74353);
      return true;
    }
    if (paramPreference.equals("setting_privacy_wx_sport_item"))
    {
      paramf = new Intent();
      paramf.setClassName(this, "com.tencent.mm.ui.contact.privacy.SportBlackListUI");
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74353);
      return true;
    }
    if (paramPreference.equals("settings_find_google_contact"))
    {
      if (!((CheckBoxPreference)paramf.byG("settings_find_google_contact")).isChecked()) {
        bool = true;
      }
      p(bool, 1048576, 29);
      AppMethodBeat.o(74353);
      return true;
    }
    if (paramPreference.equals("settings_add_me_way"))
    {
      paramf = new Intent(this, SettingsAddMeUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74353);
      return true;
    }
    if (paramPreference.equals("settings_auth_manage")) {
      if (WeChatBrands.Business.Entries.MeSetPrivacyPermissions.checkAvailable(this))
      {
        paramf = new Intent(this, SettingsManageAuthUI.class);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(74353);
      return false;
      if (paramPreference.equals("settings_story_notify"))
      {
        if (!this.Jjj)
        {
          bool = true;
          this.Jjj = bool;
          if (!this.Jjj) {
            break label1068;
          }
        }
        label1068:
        for (this.Jjk.Ure = 0;; this.Jjk.Ure = 1)
        {
          ((e)com.tencent.mm.kernel.h.ag(e.class)).updateStoryUserInfo(this.iRj, this.Jjk);
          ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(71, this.Jjk));
          dFf();
          AppMethodBeat.o(74353);
          return true;
          bool = false;
          break;
        }
      }
      if (paramPreference.equals("settings_ad_manage"))
      {
        paramf = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wcb, "");
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", String.format(paramf, new Object[] { LocaleUtil.getCurrentLanguage(this), LocaleUtil.getCurrentCountryCode() }));
        paramPreference.putExtra("showShare", false);
        paramPreference.putExtra("show_bottom", false);
        com.tencent.mm.by.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74350);
    super.onResume();
    this.status = z.bdd();
    this.tZb = z.bde();
    this.Jje = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderSwitchApi().edM();
    dFf();
    if (!this.iYB)
    {
      String str = getIntent().getStringExtra("need_matte_high_light_item");
      if (!Util.isNullOrNil(str))
      {
        final int i = this.screen.byJ(str);
        setSelection(i - 3);
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74343);
            View localView = ((com.tencent.mm.ui.base.preference.a)SettingsPrivacyUI.a(SettingsPrivacyUI.this)).a(i, SettingsPrivacyUI.this.getListView());
            if (localView != null) {
              com.tencent.mm.ui.j.a.c(SettingsPrivacyUI.this.getContext(), localView);
            }
            AppMethodBeat.o(74343);
          }
        }, 10L);
      }
      this.iYB = true;
    }
    AppMethodBeat.o(74350);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI
 * JD-Core Version:    0.7.0.1
 */