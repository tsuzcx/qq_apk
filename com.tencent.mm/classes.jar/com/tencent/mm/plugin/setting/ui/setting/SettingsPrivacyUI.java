package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.protocal.protobuf.dky;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.ui.e.i;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsPrivacyUI
  extends MMPreference
{
  private String fHO;
  boolean fPg;
  private HashMap<Integer, Integer> jdq;
  private com.tencent.mm.ui.base.preference.f screen;
  private int status;
  private boolean yWf;
  private boolean yYI;
  private boolean yYJ;
  private boolean yYK;
  private boolean yYL;
  private boolean yYM;
  private dky yYN;
  private int yYO;
  private boolean yYv;
  
  public SettingsPrivacyUI()
  {
    AppMethodBeat.i(74347);
    this.jdq = new HashMap();
    this.fHO = "";
    this.yYv = true;
    this.yWf = false;
    this.yYI = false;
    this.yYJ = false;
    this.yYK = false;
    this.yYL = false;
    this.yYM = true;
    this.yYN = null;
    this.fPg = false;
    this.yYO = e.i.Jpk;
    AppMethodBeat.o(74347);
  }
  
  private boolean Nz(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private void a(LinearLayout paramLinearLayout, int paramInt1, int paramInt2, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(74355);
    TextView localTextView = (TextView)View.inflate(getContext(), 2131495173, null);
    localTextView.setText(paramInt1);
    localTextView.setTag(Integer.valueOf(paramInt2));
    paramLinearLayout.addView(localTextView);
    localTextView.setOnClickListener(paramOnClickListener);
    if (paramBoolean) {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(2131691078, 0, 0, 0);
    }
    AppMethodBeat.o(74355);
  }
  
  private void dEy()
  {
    AppMethodBeat.i(74358);
    Object localObject = new dia();
    dky localdky = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUserInfo();
    if (o.zsw != null) {
      localObject = o.zsw.ayZ(this.fHO);
    }
    for (;;)
    {
      if (localObject == null)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SettingPrivacy", "userinfo is null");
        AppMethodBeat.o(74358);
        return;
      }
      int i = ((dia)localObject).HPm;
      int j = ((dia)localObject).HPn;
      localObject = (CheckBoxPreference)this.screen.aXe("timeline_stranger_show");
      boolean bool;
      if (localObject != null)
      {
        ((Preference)localObject).JOq = false;
        if ((i & 0x1) > 0)
        {
          bool = true;
          this.yWf = bool;
          if (this.yWf) {
            break label529;
          }
          ((CheckBoxPreference)localObject).setChecked(true);
        }
      }
      else
      {
        label132:
        localObject = (IconPreference)this.screen.aXe("timeline_recent_show_select");
        if (localObject != null)
        {
          ((Preference)localObject).JOq = false;
          if ((j != 4320) || ((i & 0x1000) <= 0)) {
            break label538;
          }
          bool = true;
          label176:
          this.yYI = bool;
          if ((j != 72) || ((i & 0x1000) <= 0)) {
            break label543;
          }
          bool = true;
          label197:
          this.yYJ = bool;
          if ((j != 720) || ((i & 0x1000) <= 0)) {
            break label548;
          }
          bool = true;
          label219:
          this.yYL = bool;
          if ((i & 0x800) <= 0) {
            break label553;
          }
          bool = true;
          label234:
          this.yYK = bool;
          if (!this.yYI) {
            break label558;
          }
          ((IconPreference)localObject).setSummary(2131757671);
          label253:
          i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ISP, Integer.valueOf(0))).intValue();
          j = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ISQ, Integer.valueOf(0))).intValue();
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingPrivacy", "willShowRecentRedCodeId  %d, currentRecentRedCodeId %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (i <= j) {
            break label605;
          }
          ((IconPreference)localObject).acU(0);
        }
        label335:
        if ((!com.tencent.mm.br.d.aJN("sns")) || ((v.aAO() & 0x8000) != 0)) {
          break label615;
        }
        bool = true;
        label355:
        this.yYv = bool;
        localObject = new StringBuilder("isSnsOpenEntrance ").append(this.yYv).append(", install ").append(com.tencent.mm.br.d.aJN("sns")).append(", flag ");
        if ((v.aAO() & 0x8000) != 0) {
          break label620;
        }
        bool = true;
        label411:
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingPrivacy", bool);
        if (!this.yYv) {
          break label625;
        }
        this.screen.cT("settings_story_notify", false);
        label446:
        if (this.yYv)
        {
          localObject = (CheckBoxPreference)this.screen.aXe("settings_story_notify");
          if (localObject != null)
          {
            ((Preference)localObject).JOq = false;
            if (localdky.HSC != 0) {
              break label642;
            }
            bool = true;
            label491:
            this.yYM = bool;
            if (!this.yYM) {
              break label647;
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
        label529:
        ((CheckBoxPreference)localObject).setChecked(false);
        break label132;
        label538:
        bool = false;
        break label176;
        label543:
        bool = false;
        break label197;
        label548:
        bool = false;
        break label219;
        label553:
        bool = false;
        break label234;
        label558:
        if (this.yYJ)
        {
          ((IconPreference)localObject).setSummary(2131757673);
          break label253;
        }
        if (this.yYL)
        {
          ((IconPreference)localObject).setSummary(2131757672);
          break label253;
        }
        ((IconPreference)localObject).setSummary(2131757670);
        break label253;
        label605:
        ((IconPreference)localObject).acU(8);
        break label335;
        label615:
        bool = false;
        break label355;
        label620:
        bool = false;
        break label411;
        label625:
        this.screen.cT("settings_story_notify", true);
        break label446;
        label642:
        bool = false;
        break label491;
        label647:
        ((CheckBoxPreference)localObject).setChecked(false);
      }
    }
  }
  
  private void dRt()
  {
    AppMethodBeat.i(74354);
    Object localObject1 = new dia();
    if (o.zsw != null) {
      localObject1 = o.zsw.ayZ(this.fHO);
    }
    if (localObject1 == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SettingPrivacy", "userinfo is null");
      AppMethodBeat.o(74354);
      return;
    }
    int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ISP, Integer.valueOf(0))).intValue();
    if (i > ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ISQ, Integer.valueOf(0))).intValue())
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ISQ, Integer.valueOf(i));
      dEy();
    }
    Object localObject2 = new d.a(getContext());
    ((d.a)localObject2).afV(2131755691);
    ((d.a)localObject2).afN(2131757669);
    View localView = View.inflate(getContext(), 2131494769, null);
    localObject1 = (LinearLayout)localView.findViewById(2131305591);
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74345);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        int i = 0;
        while (i < this.yVV.getChildCount())
        {
          localObject = (TextView)this.yVV.getChildAt(i);
          if (2131305896 != ((TextView)localObject).getId()) {
            ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2131691077, 0, 0, 0);
          }
          i += 1;
        }
        ((TextView)paramAnonymousView).setCompoundDrawablesWithIntrinsicBounds(2131691078, 0, 0, 0);
        localObject = new dia();
        if (o.zsw != null) {
          localObject = o.zsw.ayZ(SettingsPrivacyUI.b(SettingsPrivacyUI.this));
        }
        if (localObject == null)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SettingPrivacy", "userinfo is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74345);
          return;
        }
        i = ((Integer)paramAnonymousView.getTag()).intValue();
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingPrivacy", "settings_silence_update_mode choice: %d", new Object[] { Integer.valueOf(i) });
        if (i == 0)
        {
          if (SettingsPrivacyUI.c(SettingsPrivacyUI.this) == e.i.Jpl) {
            com.tencent.mm.plugin.report.service.g.yxI.f(14090, new Object[] { Integer.valueOf(4) });
          }
          SettingsPrivacyUI.a(SettingsPrivacyUI.this, false);
          SettingsPrivacyUI.b(SettingsPrivacyUI.this, true);
          SettingsPrivacyUI.c(SettingsPrivacyUI.this, false);
          SettingsPrivacyUI.d(SettingsPrivacyUI.this);
        }
        for (;;)
        {
          if (o.zsw != null) {
            o.zsw.a(SettingsPrivacyUI.b(SettingsPrivacyUI.this), SettingsPrivacyUI.e(SettingsPrivacyUI.this), SettingsPrivacyUI.f(SettingsPrivacyUI.this), SettingsPrivacyUI.g(SettingsPrivacyUI.this), SettingsPrivacyUI.h(SettingsPrivacyUI.this));
          }
          if (o.zsw == null) {
            break label628;
          }
          localObject = o.zsw.b(SettingsPrivacyUI.b(SettingsPrivacyUI.this), SettingsPrivacyUI.e(SettingsPrivacyUI.this), SettingsPrivacyUI.f(SettingsPrivacyUI.this), SettingsPrivacyUI.g(SettingsPrivacyUI.this), SettingsPrivacyUI.h(SettingsPrivacyUI.this));
          if (localObject != null) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SettingPrivacy", "userinfo in null !");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74345);
          return;
          if (i == 1)
          {
            if (SettingsPrivacyUI.c(SettingsPrivacyUI.this) == e.i.Jpl) {
              com.tencent.mm.plugin.report.service.g.yxI.f(14090, new Object[] { Integer.valueOf(5) });
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
            if (SettingsPrivacyUI.c(SettingsPrivacyUI.this) == e.i.Jpl) {
              com.tencent.mm.plugin.report.service.g.yxI.f(14090, new Object[] { Integer.valueOf(6) });
            }
            SettingsPrivacyUI.a(SettingsPrivacyUI.this, false);
            SettingsPrivacyUI.b(SettingsPrivacyUI.this, false);
            SettingsPrivacyUI.c(SettingsPrivacyUI.this, false);
            SettingsPrivacyUI.d(SettingsPrivacyUI.this);
          }
        }
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SettingPrivacy", "dancy userinfo " + localObject.toString());
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new k.a(51, (com.tencent.mm.bw.a)localObject));
        label628:
        paramAnonymousView.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74344);
            ((Dialog)SettingsPrivacyUI.2.this.yVV.getTag()).dismiss();
            SettingsPrivacyUI.i(SettingsPrivacyUI.this);
            AppMethodBeat.o(74344);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74345);
      }
    };
    a((LinearLayout)localObject1, 2131757671, 1, this.yYI, local2);
    a((LinearLayout)localObject1, 2131757672, 3, this.yYL, local2);
    a((LinearLayout)localObject1, 2131757673, 0, this.yYJ, local2);
    if ((!this.yYI) && (!this.yYJ) && (!this.yYL)) {}
    for (boolean bool = true;; bool = false)
    {
      a((LinearLayout)localObject1, 2131757670, 2, bool, local2);
      ((d.a)localObject2).hd(localView);
      localObject2 = ((d.a)localObject2).fQv();
      ((LinearLayout)localObject1).setTag(localObject2);
      ((com.tencent.mm.ui.widget.a.d)localObject2).show();
      addDialog((Dialog)localObject2);
      AppMethodBeat.o(74354);
      return;
    }
  }
  
  private boolean k(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74357);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SettingPrivacy", "switch change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
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
      this.jdq.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      AppMethodBeat.o(74357);
      return true;
      this.status &= (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  public h createAdapter(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(74348);
    paramSharedPreferences = new com.tencent.mm.ui.base.preference.a(this, getListView(), paramSharedPreferences);
    AppMethodBeat.o(74348);
    return paramSharedPreferences;
  }
  
  public int getResourceId()
  {
    return 2131951715;
  }
  
  public void initView()
  {
    boolean bool2 = false;
    AppMethodBeat.i(74356);
    setMMTitle(2131763158);
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
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.SettingPrivacy", "init function status: " + Integer.toBinaryString(this.status));
    Object localObject1 = (CheckBoxPreference)this.screen.aXe("settings_need_verify");
    ((Preference)localObject1).JOq = false;
    ((CheckBoxPreference)localObject1).setChecked(Nz(32));
    localObject1 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(6, null);
    Object localObject2 = (CheckBoxPreference)this.screen.aXe("settings_recommend_mobilefriends_to_me");
    ((Preference)localObject2).JOq = false;
    boolean bool1;
    if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
      if (!Nz(256))
      {
        bool1 = true;
        ((CheckBoxPreference)localObject2).setChecked(bool1);
      }
    }
    for (;;)
    {
      localObject1 = (CheckBoxPreference)this.screen.aXe("settings_find_google_contact");
      ((Preference)localObject1).JOq = false;
      bool1 = bool2;
      if (!Nz(1048576)) {
        bool1 = true;
      }
      ((CheckBoxPreference)localObject1).setChecked(bool1);
      localObject2 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(208903, null);
      if ((!bu.jq(this)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        this.screen.d((Preference)localObject1);
      }
      if ((!((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(335873, Boolean.TRUE)).booleanValue()) || (!o.zsy.dWb())) {
        this.screen.cT("edit_timeline_group", true);
      }
      this.screen.cT("settings_unfamiliar_contact", true);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74356);
      return;
      bool1 = false;
      break;
      this.screen.d((Preference)localObject2);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(74349);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    this.status = v.aAG();
    this.fHO = v.aAC();
    this.yYN = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUserInfo();
    if (this.yYN.HSC == 0)
    {
      bool1 = true;
      this.yYM = bool1;
      this.yYO = getIntent().getIntExtra("enter_scene", e.i.Jpk);
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SettingPrivacy", "story Notify:%s", new Object[] { Boolean.valueOf(this.yYM) });
      initView();
      com.tencent.mm.plugin.report.service.g.yxI.f(14098, new Object[] { Integer.valueOf(9) });
      if ((this.yYO == e.i.Jpl) || (this.yYO == e.i.Jpm))
      {
        paramBundle = new dia();
        if (o.zsw != null) {
          paramBundle = o.zsw.ayZ(this.fHO);
        }
        if (paramBundle != null)
        {
          int i = paramBundle.HPm;
          int j = paramBundle.HPn;
          if ((j != 4320) || ((i & 0x1000) <= 0)) {
            break label303;
          }
          bool1 = true;
          label215:
          this.yYI = bool1;
          if ((j != 72) || ((i & 0x1000) <= 0)) {
            break label309;
          }
          bool1 = true;
          label238:
          this.yYJ = bool1;
          if ((j != 720) || ((i & 0x1000) <= 0)) {
            break label315;
          }
          bool1 = true;
          label262:
          this.yYL = bool1;
          if ((i & 0x800) <= 0) {
            break label321;
          }
        }
      }
    }
    label303:
    label309:
    label315:
    label321:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.yYK = bool1;
      dRt();
      AppMethodBeat.o(74349);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label215;
      bool1 = false;
      break label238;
      bool1 = false;
      break label262;
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
    com.tencent.mm.kernel.g.ajR().ajA().set(7, Integer.valueOf(this.status));
    Iterator localIterator = this.jdq.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new auo();
      ((auo)localObject).GLx = i;
      ((auo)localObject).xsz = j;
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new k.a(23, (com.tencent.mm.bw.a)localObject));
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SettingPrivacy", "switch  " + i + " " + j);
    }
    this.jdq.clear();
    AppMethodBeat.o(74351);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(74353);
    paramPreference = paramPreference.mKey;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingPrivacy", paramPreference + " item has been clicked!");
    getDefaultSharedPreferences();
    if (paramPreference.equals("settings_need_verify"))
    {
      bool1 = k(((CheckBoxPreference)paramf.aXe("settings_need_verify")).isChecked(), 32, 4);
      AppMethodBeat.o(74353);
      return bool1;
    }
    if (paramPreference.equals("settings_recommend_mobilefriends_to_me"))
    {
      if (!((CheckBoxPreference)paramf.aXe("settings_recommend_mobilefriends_to_me")).isChecked()) {}
      for (bool1 = true;; bool1 = false)
      {
        bool1 = k(bool1, 256, 7);
        AppMethodBeat.o(74353);
        return bool1;
      }
    }
    if (paramPreference.equals("settings_about_blacklist"))
    {
      paramf = com.tencent.mm.model.ae.Bv(getString(2131760084));
      paramPreference = new Intent();
      paramPreference.putExtra("filter_type", paramf.getType());
      paramPreference.putExtra("titile", getString(2131763373));
      paramPreference.putExtra("list_attr", 32768);
      c.iUz.h(this, paramPreference);
      AppMethodBeat.o(74353);
      return true;
    }
    if (paramPreference.equals("timline_outside_permiss"))
    {
      paramf = new Intent();
      paramf.putExtra("k_sns_tag_id", 4L);
      paramf.putExtra("k_sns_from_settings_about_sns", 1);
      com.tencent.mm.br.d.b(this, "sns", ".ui.SnsBlackDetailUI", paramf);
    }
    label471:
    do
    {
      for (;;)
      {
        AppMethodBeat.o(74353);
        return false;
        if (paramPreference.equals("edit_timeline_group"))
        {
          com.tencent.mm.br.d.Q(this, "sns", ".ui.SnsTagPartlyUI");
        }
        else if (paramPreference.equals("timeline_black_permiss"))
        {
          paramf = new Intent();
          paramf.putExtra("k_sns_tag_id", 5L);
          paramf.putExtra("k_sns_from_settings_about_sns", 2);
          paramf.putExtra("k_tag_detail_sns_block_scene", 8);
          com.tencent.mm.br.d.b(this, "sns", ".ui.SnsTagDetailUI", paramf);
        }
        else if (paramPreference.equals("timeline_stranger_show"))
        {
          if (!this.yWf) {}
          for (;;)
          {
            this.yWf = bool1;
            if (o.zsw != null) {
              o.zsw.bN(this.fHO, this.yWf);
            }
            if (o.zsw == null) {
              break;
            }
            paramf = o.zsw.bO(this.fHO, this.yWf);
            o.zsw.a(this.fHO, paramf);
            if (paramf != null) {
              break label471;
            }
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SettingPrivacy", "userinfo in null !");
            AppMethodBeat.o(74353);
            return false;
            bool1 = false;
          }
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SettingPrivacy", "dancy userinfo " + paramf.toString());
          ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new k.a(51, paramf));
        }
        else
        {
          if (paramPreference.equals("settings_find_google_contact"))
          {
            bool1 = bool2;
            if (!((CheckBoxPreference)paramf.aXe("settings_find_google_contact")).isChecked()) {
              bool1 = true;
            }
            k(bool1, 1048576, 29);
            AppMethodBeat.o(74353);
            return true;
          }
          if (paramPreference.equals("settings_add_me_way"))
          {
            paramf = new Intent(this, SettingsAddMeUI.class);
            paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramf.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(74353);
            return true;
          }
          if (paramPreference.equals("timeline_recent_show_select"))
          {
            dRt();
          }
          else if (paramPreference.equals("settings_unfamiliar_contact"))
          {
            paramf = new Intent(this, UnfamiliarContactUI.class);
            paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "gotoUnfamiliarContactUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramf.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "gotoUnfamiliarContactUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            if (!paramPreference.equals("settings_auth_manage")) {
              break;
            }
            paramf = new Intent(this, SettingsManageAuthUI.class);
            paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramf.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
      }
    } while (!paramPreference.equals("settings_story_notify"));
    if (!this.yYM)
    {
      bool1 = true;
      this.yYM = bool1;
      if (!this.yYM) {
        break label1001;
      }
    }
    label1001:
    for (this.yYN.HSC = 0;; this.yYN.HSC = 1)
    {
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).updateStoryUserInfo(this.fHO, this.yYN);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new k.a(71, this.yYN));
      dEy();
      AppMethodBeat.o(74353);
      return true;
      bool1 = false;
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74350);
    super.onResume();
    this.status = v.aAG();
    dEy();
    if (!this.fPg)
    {
      String str = getIntent().getStringExtra("need_matte_high_light_item");
      if (!bu.isNullOrNil(str))
      {
        final int i = this.screen.aXg(str);
        setSelection(i - 3);
        new aq().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74343);
            View localView = ((com.tencent.mm.ui.base.preference.a)SettingsPrivacyUI.a(SettingsPrivacyUI.this)).a(i, SettingsPrivacyUI.this.getListView());
            if (localView != null) {
              com.tencent.mm.ui.h.a.c(SettingsPrivacyUI.this.getContext(), localView);
            }
            AppMethodBeat.o(74343);
          }
        }, 10L);
      }
      this.fPg = true;
    }
    AppMethodBeat.o(74350);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI
 * JD-Core Version:    0.7.0.1
 */