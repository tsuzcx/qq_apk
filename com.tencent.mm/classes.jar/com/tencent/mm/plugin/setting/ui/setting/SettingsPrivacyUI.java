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
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.i.a.ac;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.plugin.i.a.af.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.plugin.textstatus.a.p;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.protocal.protobuf.eel;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.e.k;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsPrivacyUI
  extends MMPreference
{
  private boolean DaT;
  private boolean DdA;
  private boolean DdB;
  private boolean DdC;
  private boolean DdD;
  private eel DdE;
  private int DdF;
  private final String DdG;
  private final String DdH;
  private boolean Ddl;
  private long Ddy;
  private boolean Ddz;
  private String gna;
  boolean guq;
  private HashMap<Integer, Integer> kbt;
  private long qAb;
  private com.tencent.mm.ui.base.preference.f screen;
  private int status;
  
  public SettingsPrivacyUI()
  {
    AppMethodBeat.i(74347);
    this.kbt = new HashMap();
    this.gna = "";
    this.Ddl = true;
    this.DaT = false;
    this.Ddz = false;
    this.DdA = false;
    this.DdB = false;
    this.DdC = false;
    this.DdD = true;
    this.DdE = null;
    this.guq = false;
    this.DdF = e.k.Ozj;
    this.DdG = "timeline_live_list_show";
    this.DdH = "profile_finder_like_show";
    AppMethodBeat.o(74347);
  }
  
  private boolean UM(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private void a(LinearLayout paramLinearLayout, int paramInt1, int paramInt2, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(74355);
    TextView localTextView = (TextView)View.inflate(getContext(), 2131496016, null);
    localTextView.setText(paramInt1);
    localTextView.setTag(Integer.valueOf(paramInt2));
    paramLinearLayout.addView(localTextView);
    localTextView.setOnClickListener(paramOnClickListener);
    if (paramBoolean) {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(2131691380, 0, 0, 0);
    }
    AppMethodBeat.o(74355);
  }
  
  private void a(CheckBoxPreference paramCheckBoxPreference, boolean paramBoolean)
  {
    AppMethodBeat.i(256594);
    if (paramBoolean)
    {
      if (!((aj)g.ah(aj.class)).getFinderSwitchApi().dCr()) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramCheckBoxPreference.setChecked(paramBoolean);
        this.screen.jdMethod_do("profile_finder_like_show", false);
        AppMethodBeat.o(256594);
        return;
      }
    }
    this.screen.jdMethod_do("profile_finder_like_show", true);
    AppMethodBeat.o(256594);
  }
  
  private void dmp()
  {
    AppMethodBeat.i(74358);
    Object localObject = new ebj();
    eel localeel = ((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryUserInfo();
    if (o.DCN != null) {
      localObject = o.DCN.aNV(this.gna);
    }
    for (;;)
    {
      if (localObject == null)
      {
        Log.e("MicroMsg.SettingPrivacy", "userinfo is null");
        AppMethodBeat.o(74358);
        return;
      }
      int i = ((ebj)localObject).Nbc;
      int j = ((ebj)localObject).Nbd;
      localObject = (CheckBoxPreference)this.screen.bmg("timeline_stranger_show");
      boolean bool;
      if (localObject != null)
      {
        ((Preference)localObject).OZw = false;
        if ((i & 0x1) > 0)
        {
          bool = true;
          this.DaT = bool;
          if (this.DaT) {
            break label532;
          }
          ((CheckBoxPreference)localObject).setChecked(true);
        }
      }
      else
      {
        label132:
        localObject = (IconPreference)this.screen.bmg("timeline_recent_show_select");
        if (localObject != null)
        {
          ((Preference)localObject).OZw = false;
          if ((j != 4320) || ((i & 0x1000) <= 0)) {
            break label541;
          }
          bool = true;
          label176:
          this.Ddz = bool;
          if ((j != 72) || ((i & 0x1000) <= 0)) {
            break label546;
          }
          bool = true;
          label197:
          this.DdA = bool;
          if ((j != 720) || ((i & 0x1000) <= 0)) {
            break label551;
          }
          bool = true;
          label219:
          this.DdC = bool;
          if ((i & 0x800) <= 0) {
            break label556;
          }
          bool = true;
          label234:
          this.DdB = bool;
          if (!this.Ddz) {
            break label561;
          }
          ((IconPreference)localObject).setSummary(2131757899);
          label253:
          i = ((Integer)g.aAh().azQ().get(ar.a.OaR, Integer.valueOf(0))).intValue();
          j = ((Integer)g.aAh().azQ().get(ar.a.OaS, Integer.valueOf(0))).intValue();
          Log.i("MicroMsg.SettingPrivacy", "willShowRecentRedCodeId  %d, currentRecentRedCodeId %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (i <= j) {
            break label608;
          }
          ((IconPreference)localObject).alF(0);
        }
        label336:
        if ((!com.tencent.mm.br.c.aZU("sns")) || ((z.aUl() & 0x8000) != 0)) {
          break label618;
        }
        bool = true;
        label357:
        this.Ddl = bool;
        localObject = new StringBuilder("isSnsOpenEntrance ").append(this.Ddl).append(", install ").append(com.tencent.mm.br.c.aZU("sns")).append(", flag ");
        if ((z.aUl() & 0x8000) != 0) {
          break label623;
        }
        bool = true;
        label414:
        Log.i("MicroMsg.SettingPrivacy", bool);
        if (!this.Ddl) {
          break label628;
        }
        this.screen.jdMethod_do("settings_story_notify", false);
        label449:
        if (this.Ddl)
        {
          localObject = (CheckBoxPreference)this.screen.bmg("settings_story_notify");
          if (localObject != null)
          {
            ((Preference)localObject).OZw = false;
            if (localeel.NeF != 0) {
              break label645;
            }
            bool = true;
            label494:
            this.DdD = bool;
            if (!this.DdD) {
              break label650;
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
        label532:
        ((CheckBoxPreference)localObject).setChecked(false);
        break label132;
        label541:
        bool = false;
        break label176;
        label546:
        bool = false;
        break label197;
        label551:
        bool = false;
        break label219;
        label556:
        bool = false;
        break label234;
        label561:
        if (this.DdA)
        {
          ((IconPreference)localObject).setSummary(2131757901);
          break label253;
        }
        if (this.DdC)
        {
          ((IconPreference)localObject).setSummary(2131757900);
          break label253;
        }
        ((IconPreference)localObject).setSummary(2131757898);
        break label253;
        label608:
        ((IconPreference)localObject).alF(8);
        break label336;
        label618:
        bool = false;
        break label357;
        label623:
        bool = false;
        break label414;
        label628:
        this.screen.jdMethod_do("settings_story_notify", true);
        break label449;
        label645:
        bool = false;
        break label494;
        label650:
        ((CheckBoxPreference)localObject).setChecked(false);
      }
    }
  }
  
  private void eTu()
  {
    AppMethodBeat.i(74354);
    Object localObject1 = new ebj();
    if (o.DCN != null) {
      localObject1 = o.DCN.aNV(this.gna);
    }
    if (localObject1 == null)
    {
      Log.e("MicroMsg.SettingPrivacy", "userinfo is null");
      AppMethodBeat.o(74354);
      return;
    }
    int i = ((Integer)g.aAh().azQ().get(ar.a.OaR, Integer.valueOf(0))).intValue();
    if (i > ((Integer)g.aAh().azQ().get(ar.a.OaS, Integer.valueOf(0))).intValue())
    {
      g.aAh().azQ().set(ar.a.OaS, Integer.valueOf(i));
      dmp();
    }
    Object localObject2 = new d.a(getContext());
    ((d.a)localObject2).aoW(2131755761);
    ((d.a)localObject2).aoO(2131757897);
    View localView = View.inflate(getContext(), 2131495503, null);
    localObject1 = (LinearLayout)localView.findViewById(2131308813);
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74345);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        int i = 0;
        while (i < this.DaJ.getChildCount())
        {
          localObject = (TextView)this.DaJ.getChildAt(i);
          if (2131309187 != ((TextView)localObject).getId()) {
            ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2131691379, 0, 0, 0);
          }
          i += 1;
        }
        ((TextView)paramAnonymousView).setCompoundDrawablesWithIntrinsicBounds(2131691380, 0, 0, 0);
        localObject = new ebj();
        if (o.DCN != null) {
          localObject = o.DCN.aNV(SettingsPrivacyUI.b(SettingsPrivacyUI.this));
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
          if (SettingsPrivacyUI.c(SettingsPrivacyUI.this) == e.k.Ozk) {
            com.tencent.mm.plugin.report.service.h.CyF.a(14090, new Object[] { Integer.valueOf(4) });
          }
          SettingsPrivacyUI.a(SettingsPrivacyUI.this, false);
          SettingsPrivacyUI.b(SettingsPrivacyUI.this, true);
          SettingsPrivacyUI.c(SettingsPrivacyUI.this, false);
          SettingsPrivacyUI.d(SettingsPrivacyUI.this);
        }
        for (;;)
        {
          if (o.DCN != null) {
            o.DCN.a(SettingsPrivacyUI.b(SettingsPrivacyUI.this), SettingsPrivacyUI.e(SettingsPrivacyUI.this), SettingsPrivacyUI.f(SettingsPrivacyUI.this), SettingsPrivacyUI.g(SettingsPrivacyUI.this), SettingsPrivacyUI.h(SettingsPrivacyUI.this));
          }
          if (o.DCN == null) {
            break label628;
          }
          localObject = o.DCN.b(SettingsPrivacyUI.b(SettingsPrivacyUI.this), SettingsPrivacyUI.e(SettingsPrivacyUI.this), SettingsPrivacyUI.f(SettingsPrivacyUI.this), SettingsPrivacyUI.g(SettingsPrivacyUI.this), SettingsPrivacyUI.h(SettingsPrivacyUI.this));
          if (localObject != null) {
            break;
          }
          Log.e("MicroMsg.SettingPrivacy", "userinfo in null !");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74345);
          return;
          if (i == 1)
          {
            if (SettingsPrivacyUI.c(SettingsPrivacyUI.this) == e.k.Ozk) {
              com.tencent.mm.plugin.report.service.h.CyF.a(14090, new Object[] { Integer.valueOf(5) });
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
            if (SettingsPrivacyUI.c(SettingsPrivacyUI.this) == e.k.Ozk) {
              com.tencent.mm.plugin.report.service.h.CyF.a(14090, new Object[] { Integer.valueOf(6) });
            }
            SettingsPrivacyUI.a(SettingsPrivacyUI.this, false);
            SettingsPrivacyUI.b(SettingsPrivacyUI.this, false);
            SettingsPrivacyUI.c(SettingsPrivacyUI.this, false);
            SettingsPrivacyUI.d(SettingsPrivacyUI.this);
          }
        }
        Log.d("MicroMsg.SettingPrivacy", "dancy userinfo " + localObject.toString());
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(51, (com.tencent.mm.bw.a)localObject));
        label628:
        paramAnonymousView.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74344);
            ((Dialog)SettingsPrivacyUI.2.this.DaJ.getTag()).dismiss();
            SettingsPrivacyUI.i(SettingsPrivacyUI.this);
            AppMethodBeat.o(74344);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74345);
      }
    };
    a((LinearLayout)localObject1, 2131757899, 1, this.Ddz, local2);
    a((LinearLayout)localObject1, 2131757900, 3, this.DdC, local2);
    a((LinearLayout)localObject1, 2131757901, 0, this.DdA, local2);
    if ((!this.Ddz) && (!this.DdA) && (!this.DdC)) {}
    for (boolean bool = true;; bool = false)
    {
      a((LinearLayout)localObject1, 2131757898, 2, bool, local2);
      ((d.a)localObject2).hs(localView);
      localObject2 = ((d.a)localObject2).hbn();
      ((LinearLayout)localObject1).setTag(localObject2);
      ((d)localObject2).show();
      addDialog((Dialog)localObject2);
      AppMethodBeat.o(74354);
      return;
    }
  }
  
  private boolean l(boolean paramBoolean, int paramInt1, int paramInt2)
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
      this.kbt.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
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
    return 2132017260;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74356);
    setMMTitle(2131765326);
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
    Log.i("MicroMsg.SettingPrivacy", "init function status: " + Integer.toBinaryString(this.status) + "extStatus: " + Long.toBinaryString(this.qAb) + " FinderSetting: " + Long.toBinaryString(this.Ddy));
    Object localObject1 = (CheckBoxPreference)this.screen.bmg("settings_need_verify");
    ((Preference)localObject1).OZw = false;
    ((CheckBoxPreference)localObject1).setChecked(UM(32));
    localObject1 = (String)g.aAh().azQ().get(6, null);
    Object localObject2 = (CheckBoxPreference)this.screen.bmg("settings_recommend_mobilefriends_to_me");
    ((Preference)localObject2).OZw = false;
    boolean bool1;
    label190:
    label225:
    int i;
    label358:
    boolean bool2;
    if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
      if (!UM(256))
      {
        bool1 = true;
        ((CheckBoxPreference)localObject2).setChecked(bool1);
        localObject1 = (CheckBoxPreference)this.screen.bmg("settings_find_google_contact");
        ((Preference)localObject1).OZw = false;
        if (UM(1048576)) {
          break label725;
        }
        bool1 = true;
        ((CheckBoxPreference)localObject1).setChecked(bool1);
        localObject2 = (String)g.aAh().azQ().get(208903, null);
        if ((!Util.isOverseasUser(this)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
          this.screen.e((Preference)localObject1);
        }
        if (p.fvC())
        {
          localObject1 = (PreferenceTitleCategory)this.screen.bmg("settings_add_friends_timeline_tip");
          if (localObject1 != null) {
            ((PreferenceTitleCategory)localObject1).setTitle(2131766028);
          }
        }
        localObject1 = (CheckBoxPreference)this.screen.bmg("timeline_live_list_show");
        ((Preference)localObject1).OZw = false;
        if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRI, 1) != 1) {
          break label730;
        }
        i = 1;
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
          i = 1;
        }
        int j = i;
        if (i != 0)
        {
          if ((!((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt()) || (((ad)g.af(ad.class)).dxY())) {
            break label735;
          }
          bool1 = true;
          label420:
          boolean bool3 = ((aj)g.ah(aj.class)).showFinderEntry();
          if (((Integer)g.aAh().azQ().get(ar.a.OmP, Integer.valueOf(0))).intValue() != 1) {
            break label740;
          }
          bool2 = true;
          label464:
          if ((!bool3) || (bool1) || (!bool2)) {
            break label746;
          }
          i = 1;
          label480:
          Log.i("MicroMsg.SettingPrivacy", "timeline_live_list_show " + bool1 + "," + bool3 + "," + bool2);
          j = i;
        }
        if (j == 0) {
          break label761;
        }
        if ((this.qAb & 0x0) == 0L) {
          break label751;
        }
        i = 1;
        label545:
        if (i != 0) {
          break label756;
        }
        bool1 = true;
        label551:
        ((CheckBoxPreference)localObject1).setChecked(bool1);
        this.screen.jdMethod_do("timeline_live_list_show", false);
      }
    }
    for (;;)
    {
      localObject1 = (CheckBoxPreference)this.screen.bmg("profile_finder_like_show");
      ((Preference)localObject1).OZw = false;
      a((CheckBoxPreference)localObject1, ((aj)g.ah(aj.class)).getFinderSwitchApi().a(new af.a() {}));
      if ((!((Boolean)g.aAh().azQ().get(335873, Boolean.TRUE)).booleanValue()) || (!o.DCP.eZm())) {
        this.screen.jdMethod_do("edit_timeline_group", true);
      }
      this.screen.jdMethod_do("settings_unfamiliar_contact", true);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74356);
      return;
      bool1 = false;
      break;
      this.screen.e((Preference)localObject2);
      break label190;
      label725:
      bool1 = false;
      break label225;
      label730:
      i = 0;
      break label358;
      label735:
      bool1 = false;
      break label420;
      label740:
      bool2 = false;
      break label464;
      label746:
      i = 0;
      break label480;
      label751:
      i = 0;
      break label545;
      label756:
      bool1 = false;
      break label551;
      label761:
      this.screen.jdMethod_do("timeline_live_list_show", true);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(74349);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    this.status = z.aUc();
    this.qAb = z.aUd();
    this.Ddy = ((aj)g.ah(aj.class)).getFinderSwitchApi().dCq();
    this.gna = z.aTY();
    this.DdE = ((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryUserInfo();
    if (this.DdE.NeF == 0)
    {
      bool1 = true;
      this.DdD = bool1;
      this.DdF = getIntent().getIntExtra("enter_scene", e.k.Ozj);
      Log.d("MicroMsg.SettingPrivacy", "story Notify:%s", new Object[] { Boolean.valueOf(this.DdD) });
      initView();
      com.tencent.mm.plugin.report.service.h.CyF.a(14098, new Object[] { Integer.valueOf(9) });
      if ((this.DdF == e.k.Ozk) || (this.DdF == e.k.Ozl))
      {
        paramBundle = new ebj();
        if (o.DCN != null) {
          paramBundle = o.DCN.aNV(this.gna);
        }
        if (paramBundle != null)
        {
          int i = paramBundle.Nbc;
          int j = paramBundle.Nbd;
          if ((j != 4320) || ((i & 0x1000) <= 0)) {
            break label332;
          }
          bool1 = true;
          label244:
          this.Ddz = bool1;
          if ((j != 72) || ((i & 0x1000) <= 0)) {
            break label338;
          }
          bool1 = true;
          label267:
          this.DdA = bool1;
          if ((j != 720) || ((i & 0x1000) <= 0)) {
            break label344;
          }
          bool1 = true;
          label291:
          this.DdC = bool1;
          if ((i & 0x800) <= 0) {
            break label350;
          }
        }
      }
    }
    label332:
    label338:
    label344:
    label350:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.DdB = bool1;
      eTu();
      AppMethodBeat.o(74349);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label244;
      bool1 = false;
      break label267;
      bool1 = false;
      break label291;
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
    g.aAh().azQ().set(7, Integer.valueOf(this.status));
    g.aAh().azQ().set(147457, Long.valueOf(this.qAb));
    ((aj)g.ah(aj.class)).getFinderSwitchApi().Gf(this.Ddy);
    Iterator localIterator = this.kbt.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new bfx();
      ((bfx)localObject).LPB = i;
      ((bfx)localObject).BsD = j;
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(23, (com.tencent.mm.bw.a)localObject));
      Log.d("MicroMsg.SettingPrivacy", "switch  " + i + " " + j);
    }
    this.kbt.clear();
    AppMethodBeat.o(74351);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int i = 2;
    boolean bool1 = false;
    boolean bool2 = true;
    AppMethodBeat.i(74353);
    paramPreference = paramPreference.mKey;
    Log.i("MicroMsg.SettingPrivacy", paramPreference + " item has been clicked!");
    getDefaultSharedPreferences();
    if (paramPreference.equals("settings_need_verify"))
    {
      bool1 = l(((CheckBoxPreference)paramf.bmg("settings_need_verify")).isChecked(), 32, 4);
      AppMethodBeat.o(74353);
      return bool1;
    }
    if (paramPreference.equals("settings_recommend_mobilefriends_to_me"))
    {
      if (!((CheckBoxPreference)paramf.bmg("settings_recommend_mobilefriends_to_me")).isChecked()) {}
      for (bool1 = true;; bool1 = false)
      {
        bool1 = l(bool1, 256, 7);
        AppMethodBeat.o(74353);
        return bool1;
      }
    }
    if (paramPreference.equals("settings_about_blacklist"))
    {
      paramf = ai.Kb(getString(2131761463));
      paramPreference = new Intent();
      paramPreference.putExtra("filter_type", paramf.getType());
      paramPreference.putExtra("titile", getString(2131765555));
      paramPreference.putExtra("list_attr", 32768);
      com.tencent.mm.plugin.setting.c.jRt.h(this, paramPreference);
      AppMethodBeat.o(74353);
      return true;
    }
    if (paramPreference.equals("timline_outside_permiss"))
    {
      paramf = new Intent();
      paramf.putExtra("k_sns_tag_id", 4L);
      paramf.putExtra("k_sns_from_settings_about_sns", 1);
      com.tencent.mm.br.c.b(this, "sns", ".ui.SnsBlackDetailUI", paramf);
    }
    label490:
    int j;
    label1032:
    label1202:
    do
    {
      for (;;)
      {
        AppMethodBeat.o(74353);
        return false;
        if (paramPreference.equals("edit_timeline_group"))
        {
          com.tencent.mm.br.c.V(this, "sns", ".ui.SnsTagPartlyUI");
        }
        else if (paramPreference.equals("timeline_black_permiss"))
        {
          paramf = new Intent();
          paramf.putExtra("k_sns_tag_id", 5L);
          paramf.putExtra("k_sns_from_settings_about_sns", 2);
          paramf.putExtra("k_tag_detail_sns_block_scene", 8);
          com.tencent.mm.br.c.b(this, "sns", ".ui.SnsTagDetailUI", paramf);
        }
        else if (paramPreference.equals("timeline_stranger_show"))
        {
          if (!this.DaT) {}
          for (bool1 = bool2;; bool1 = false)
          {
            this.DaT = bool1;
            if (o.DCN != null) {
              o.DCN.cf(this.gna, this.DaT);
            }
            if (o.DCN == null) {
              break;
            }
            paramf = o.DCN.cg(this.gna, this.DaT);
            o.DCN.a(this.gna, paramf);
            if (paramf != null) {
              break label490;
            }
            Log.e("MicroMsg.SettingPrivacy", "userinfo in null !");
            AppMethodBeat.o(74353);
            return false;
          }
          Log.d("MicroMsg.SettingPrivacy", "dancy userinfo " + paramf.toString());
          ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(51, paramf));
        }
        else
        {
          if (paramPreference.equals("settings_find_google_contact"))
          {
            if (!((CheckBoxPreference)paramf.bmg("settings_find_google_contact")).isChecked()) {
              bool1 = true;
            }
            l(bool1, 1048576, 29);
            AppMethodBeat.o(74353);
            return true;
          }
          if (paramPreference.equals("settings_add_me_way"))
          {
            paramf = new Intent(this, SettingsAddMeUI.class);
            paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramf.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(74353);
            return true;
          }
          if (paramPreference.equals("timeline_recent_show_select"))
          {
            eTu();
          }
          else if (paramPreference.equals("settings_unfamiliar_contact"))
          {
            paramf = new Intent(this, UnfamiliarContactUI.class);
            paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "gotoUnfamiliarContactUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramf.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "gotoUnfamiliarContactUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            if (!paramPreference.equals("settings_auth_manage")) {
              break;
            }
            if (WeChatBrands.Business.Entries.MeSetPrivacyPermissions.checkAvailable(this))
            {
              paramf = new Intent(this, SettingsManageAuthUI.class);
              paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
              com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramf.pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
        }
      }
      if (paramPreference.equals("settings_story_notify"))
      {
        if (!this.DdD)
        {
          bool1 = true;
          this.DdD = bool1;
          if (!this.DdD) {
            break label1032;
          }
        }
        for (this.DdE.NeF = 0;; this.DdE.NeF = 1)
        {
          ((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).updateStoryUserInfo(this.gna, this.DdE);
          ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(71, this.DdE));
          dmp();
          AppMethodBeat.o(74353);
          return true;
          bool1 = false;
          break;
        }
      }
      if (paramPreference.equals("timeline_live_list_show"))
      {
        bool1 = ((CheckBoxPreference)paramf.bmg("timeline_live_list_show")).isChecked();
        long l = System.currentTimeMillis();
        if (bool1)
        {
          j = 1;
          paramf = String.format("%s,%s", new Object[] { Long.valueOf(l), Integer.valueOf(j) });
          com.tencent.mm.plugin.report.service.h.CyF.kvStat(21529, paramf);
          Log.i("MicroMsg.SettingPrivacy", "switch ext change : open = " + bool1 + " item value = 17592186044416 functionId = 60");
          if (!bool1) {
            break label1202;
          }
        }
        for (this.qAb &= 0xFFFFFFFF;; this.qAb |= 0x0)
        {
          if (bool1) {
            i = 1;
          }
          this.kbt.put(Integer.valueOf(60), Integer.valueOf(i));
          AppMethodBeat.o(74353);
          return true;
          j = 2;
          break;
        }
      }
    } while (!paramPreference.equals("profile_finder_like_show"));
    bool1 = ((CheckBoxPreference)paramf.bmg("profile_finder_like_show")).isChecked();
    if (bool1)
    {
      j = 1;
      paramf = String.format("%s", new Object[] { Integer.valueOf(j) });
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(22136, paramf);
      Log.i("MicroMsg.SettingPrivacy", "switch ext change : open = " + bool1 + " item value = 1 functionId = 62");
      if (!bool1) {
        break label1363;
      }
    }
    label1363:
    for (this.Ddy &= 0xFFFFFFFE;; this.Ddy |= 1L)
    {
      if (bool1) {
        i = 1;
      }
      this.kbt.put(Integer.valueOf(62), Integer.valueOf(i));
      AppMethodBeat.o(74353);
      return true;
      j = 2;
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74350);
    super.onResume();
    this.status = z.aUc();
    this.qAb = z.aUd();
    this.Ddy = ((aj)g.ah(aj.class)).getFinderSwitchApi().dCq();
    dmp();
    if (!this.guq)
    {
      String str = getIntent().getStringExtra("need_matte_high_light_item");
      if (!Util.isNullOrNil(str))
      {
        final int i = this.screen.bmj(str);
        setSelection(i - 3);
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74343);
            View localView = ((com.tencent.mm.ui.base.preference.a)SettingsPrivacyUI.a(SettingsPrivacyUI.this)).a(i, SettingsPrivacyUI.this.getListView());
            if (localView != null) {
              com.tencent.mm.ui.i.a.c(SettingsPrivacyUI.this.getContext(), localView);
            }
            AppMethodBeat.o(74343);
          }
        }, 10L);
      }
      this.guq = true;
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