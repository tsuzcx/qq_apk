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
import com.tencent.mm.model.ac;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.protocal.protobuf.dkd;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  private String fFK;
  boolean fMY;
  private HashMap<Integer, Integer> jax;
  private com.tencent.mm.ui.base.preference.f screen;
  private int status;
  private boolean yFW;
  private boolean yIA;
  private boolean yIB;
  private boolean yIC;
  private dkd yID;
  private int yIE;
  private boolean yIl;
  private boolean yIy;
  private boolean yIz;
  
  public SettingsPrivacyUI()
  {
    AppMethodBeat.i(74347);
    this.jax = new HashMap();
    this.fFK = "";
    this.yIl = true;
    this.yFW = false;
    this.yIy = false;
    this.yIz = false;
    this.yIA = false;
    this.yIB = false;
    this.yIC = true;
    this.yID = null;
    this.fMY = false;
    this.yIE = e.i.IUC;
    AppMethodBeat.o(74347);
  }
  
  private boolean MT(int paramInt)
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
  
  private void dBh()
  {
    AppMethodBeat.i(74358);
    Object localObject = new dhg();
    dkd localdkd = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUserInfo();
    if (o.zbT != null) {
      localObject = o.zbT.axI(this.fFK);
    }
    for (;;)
    {
      if (localObject == null)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SettingPrivacy", "userinfo is null");
        AppMethodBeat.o(74358);
        return;
      }
      int i = ((dhg)localObject).HvJ;
      int j = ((dhg)localObject).HvK;
      localObject = (CheckBoxPreference)this.screen.aVD("timeline_stranger_show");
      boolean bool;
      if (localObject != null)
      {
        ((Preference)localObject).JtB = false;
        if ((i & 0x1) > 0)
        {
          bool = true;
          this.yFW = bool;
          if (this.yFW) {
            break label529;
          }
          ((CheckBoxPreference)localObject).oB = true;
        }
      }
      else
      {
        label132:
        localObject = (IconPreference)this.screen.aVD("timeline_recent_show_select");
        if (localObject != null)
        {
          ((Preference)localObject).JtB = false;
          if ((j != 4320) || ((i & 0x1000) <= 0)) {
            break label538;
          }
          bool = true;
          label176:
          this.yIy = bool;
          if ((j != 72) || ((i & 0x1000) <= 0)) {
            break label543;
          }
          bool = true;
          label197:
          this.yIz = bool;
          if ((j != 720) || ((i & 0x1000) <= 0)) {
            break label548;
          }
          bool = true;
          label219:
          this.yIB = bool;
          if ((i & 0x800) <= 0) {
            break label553;
          }
          bool = true;
          label234:
          this.yIA = bool;
          if (!this.yIy) {
            break label558;
          }
          ((IconPreference)localObject).setSummary(2131757671);
          label253:
          i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iyr, Integer.valueOf(0))).intValue();
          j = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iys, Integer.valueOf(0))).intValue();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingPrivacy", "willShowRecentRedCodeId  %d, currentRecentRedCodeId %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (i <= j) {
            break label605;
          }
          ((IconPreference)localObject).acn(0);
        }
        label335:
        if ((!com.tencent.mm.bs.d.aIu("sns")) || ((u.aAy() & 0x8000) != 0)) {
          break label615;
        }
        bool = true;
        label355:
        this.yIl = bool;
        localObject = new StringBuilder("isSnsOpenEntrance ").append(this.yIl).append(", install ").append(com.tencent.mm.bs.d.aIu("sns")).append(", flag ");
        if ((u.aAy() & 0x8000) != 0) {
          break label620;
        }
        bool = true;
        label411:
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingPrivacy", bool);
        if (!this.yIl) {
          break label625;
        }
        this.screen.cP("settings_story_notify", false);
        label446:
        if (this.yIl)
        {
          localObject = (CheckBoxPreference)this.screen.aVD("settings_story_notify");
          if (localObject != null)
          {
            ((Preference)localObject).JtB = false;
            if (localdkd.HyR != 0) {
              break label642;
            }
            bool = true;
            label491:
            this.yIC = bool;
            if (!this.yIC) {
              break label647;
            }
          }
        }
      }
      label642:
      label647:
      for (((CheckBoxPreference)localObject).oB = true;; ((CheckBoxPreference)localObject).oB = false)
      {
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(74358);
        return;
        bool = false;
        break;
        label529:
        ((CheckBoxPreference)localObject).oB = false;
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
        if (this.yIz)
        {
          ((IconPreference)localObject).setSummary(2131757673);
          break label253;
        }
        if (this.yIB)
        {
          ((IconPreference)localObject).setSummary(2131757672);
          break label253;
        }
        ((IconPreference)localObject).setSummary(2131757670);
        break label253;
        label605:
        ((IconPreference)localObject).acn(8);
        break label335;
        label615:
        bool = false;
        break label355;
        label620:
        bool = false;
        break label411;
        label625:
        this.screen.cP("settings_story_notify", true);
        break label446;
        bool = false;
        break label491;
      }
    }
  }
  
  private void dNW()
  {
    AppMethodBeat.i(74354);
    Object localObject1 = new dhg();
    if (o.zbT != null) {
      localObject1 = o.zbT.axI(this.fFK);
    }
    if (localObject1 == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SettingPrivacy", "userinfo is null");
      AppMethodBeat.o(74354);
      return;
    }
    int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iyr, Integer.valueOf(0))).intValue();
    if (i > ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iys, Integer.valueOf(0))).intValue())
    {
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iys, Integer.valueOf(i));
      dBh();
    }
    Object localObject2 = new d.a(getContext());
    ((d.a)localObject2).afm(2131755691);
    ((d.a)localObject2).afe(2131757669);
    View localView = View.inflate(getContext(), 2131494769, null);
    localObject1 = (LinearLayout)localView.findViewById(2131305591);
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74345);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        int i = 0;
        while (i < this.yFM.getChildCount())
        {
          localObject = (TextView)this.yFM.getChildAt(i);
          if (2131305896 != ((TextView)localObject).getId()) {
            ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2131691077, 0, 0, 0);
          }
          i += 1;
        }
        ((TextView)paramAnonymousView).setCompoundDrawablesWithIntrinsicBounds(2131691078, 0, 0, 0);
        localObject = new dhg();
        if (o.zbT != null) {
          localObject = o.zbT.axI(SettingsPrivacyUI.b(SettingsPrivacyUI.this));
        }
        if (localObject == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SettingPrivacy", "userinfo is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74345);
          return;
        }
        i = ((Integer)paramAnonymousView.getTag()).intValue();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingPrivacy", "settings_silence_update_mode choice: %d", new Object[] { Integer.valueOf(i) });
        if (i == 0)
        {
          if (SettingsPrivacyUI.c(SettingsPrivacyUI.this) == e.i.IUD) {
            com.tencent.mm.plugin.report.service.g.yhR.f(14090, new Object[] { Integer.valueOf(4) });
          }
          SettingsPrivacyUI.a(SettingsPrivacyUI.this, false);
          SettingsPrivacyUI.b(SettingsPrivacyUI.this, true);
          SettingsPrivacyUI.c(SettingsPrivacyUI.this, false);
          SettingsPrivacyUI.d(SettingsPrivacyUI.this);
        }
        for (;;)
        {
          if (o.zbT != null) {
            o.zbT.a(SettingsPrivacyUI.b(SettingsPrivacyUI.this), SettingsPrivacyUI.e(SettingsPrivacyUI.this), SettingsPrivacyUI.f(SettingsPrivacyUI.this), SettingsPrivacyUI.g(SettingsPrivacyUI.this), SettingsPrivacyUI.h(SettingsPrivacyUI.this));
          }
          if (o.zbT == null) {
            break label628;
          }
          localObject = o.zbT.b(SettingsPrivacyUI.b(SettingsPrivacyUI.this), SettingsPrivacyUI.e(SettingsPrivacyUI.this), SettingsPrivacyUI.f(SettingsPrivacyUI.this), SettingsPrivacyUI.g(SettingsPrivacyUI.this), SettingsPrivacyUI.h(SettingsPrivacyUI.this));
          if (localObject != null) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SettingPrivacy", "userinfo in null !");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74345);
          return;
          if (i == 1)
          {
            if (SettingsPrivacyUI.c(SettingsPrivacyUI.this) == e.i.IUD) {
              com.tencent.mm.plugin.report.service.g.yhR.f(14090, new Object[] { Integer.valueOf(5) });
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
            if (SettingsPrivacyUI.c(SettingsPrivacyUI.this) == e.i.IUD) {
              com.tencent.mm.plugin.report.service.g.yhR.f(14090, new Object[] { Integer.valueOf(6) });
            }
            SettingsPrivacyUI.a(SettingsPrivacyUI.this, false);
            SettingsPrivacyUI.b(SettingsPrivacyUI.this, false);
            SettingsPrivacyUI.c(SettingsPrivacyUI.this, false);
            SettingsPrivacyUI.d(SettingsPrivacyUI.this);
          }
        }
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SettingPrivacy", "dancy userinfo " + localObject.toString());
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(new k.a(51, (com.tencent.mm.bx.a)localObject));
        label628:
        paramAnonymousView.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74344);
            ((Dialog)SettingsPrivacyUI.2.this.yFM.getTag()).dismiss();
            SettingsPrivacyUI.i(SettingsPrivacyUI.this);
            AppMethodBeat.o(74344);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74345);
      }
    };
    a((LinearLayout)localObject1, 2131757671, 1, this.yIy, local2);
    a((LinearLayout)localObject1, 2131757672, 3, this.yIB, local2);
    a((LinearLayout)localObject1, 2131757673, 0, this.yIz, local2);
    if ((!this.yIy) && (!this.yIz) && (!this.yIB)) {}
    for (boolean bool = true;; bool = false)
    {
      a((LinearLayout)localObject1, 2131757670, 2, bool, local2);
      ((d.a)localObject2).gY(localView);
      localObject2 = ((d.a)localObject2).fMb();
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
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SettingPrivacy", "switch change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
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
      this.jax.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
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
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.SettingPrivacy", "init function status: " + Integer.toBinaryString(this.status));
    Object localObject1 = (CheckBoxPreference)this.screen.aVD("settings_need_verify");
    ((Preference)localObject1).JtB = false;
    ((CheckBoxPreference)localObject1).oB = MT(32);
    localObject1 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(6, null);
    Object localObject2 = (CheckBoxPreference)this.screen.aVD("settings_recommend_mobilefriends_to_me");
    ((Preference)localObject2).JtB = false;
    boolean bool1;
    if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
      if (!MT(256))
      {
        bool1 = true;
        ((CheckBoxPreference)localObject2).oB = bool1;
      }
    }
    for (;;)
    {
      localObject1 = (CheckBoxPreference)this.screen.aVD("settings_find_google_contact");
      ((Preference)localObject1).JtB = false;
      bool1 = bool2;
      if (!MT(1048576)) {
        bool1 = true;
      }
      ((CheckBoxPreference)localObject1).oB = bool1;
      localObject2 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(208903, null);
      if ((!bt.jk(this)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        this.screen.d((Preference)localObject1);
      }
      if ((!((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(335873, Boolean.TRUE)).booleanValue()) || (!o.zbV.dSD())) {
        this.screen.cP("edit_timeline_group", true);
      }
      this.screen.cP("settings_unfamiliar_contact", true);
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
    this.status = u.aAq();
    this.fFK = u.aAm();
    this.yID = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUserInfo();
    if (this.yID.HyR == 0)
    {
      bool1 = true;
      this.yIC = bool1;
      this.yIE = getIntent().getIntExtra("enter_scene", e.i.IUC);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SettingPrivacy", "story Notify:%s", new Object[] { Boolean.valueOf(this.yIC) });
      initView();
      com.tencent.mm.plugin.report.service.g.yhR.f(14098, new Object[] { Integer.valueOf(9) });
      if ((this.yIE == e.i.IUD) || (this.yIE == e.i.IUE))
      {
        paramBundle = new dhg();
        if (o.zbT != null) {
          paramBundle = o.zbT.axI(this.fFK);
        }
        if (paramBundle != null)
        {
          int i = paramBundle.HvJ;
          int j = paramBundle.HvK;
          if ((j != 4320) || ((i & 0x1000) <= 0)) {
            break label303;
          }
          bool1 = true;
          label215:
          this.yIy = bool1;
          if ((j != 72) || ((i & 0x1000) <= 0)) {
            break label309;
          }
          bool1 = true;
          label238:
          this.yIz = bool1;
          if ((j != 720) || ((i & 0x1000) <= 0)) {
            break label315;
          }
          bool1 = true;
          label262:
          this.yIB = bool1;
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
      this.yIA = bool1;
      dNW();
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
    com.tencent.mm.kernel.g.ajC().ajl().set(7, Integer.valueOf(this.status));
    Iterator localIterator = this.jax.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new aty();
      ((aty)localObject).GrZ = i;
      ((aty)localObject).xcI = j;
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(new k.a(23, (com.tencent.mm.bx.a)localObject));
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SettingPrivacy", "switch  " + i + " " + j);
    }
    this.jax.clear();
    AppMethodBeat.o(74351);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(74353);
    paramPreference = paramPreference.mKey;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingPrivacy", paramPreference + " item has been clicked!");
    getDefaultSharedPreferences();
    if (paramPreference.equals("settings_need_verify"))
    {
      bool1 = k(((CheckBoxPreference)paramf.aVD("settings_need_verify")).isChecked(), 32, 4);
      AppMethodBeat.o(74353);
      return bool1;
    }
    if (paramPreference.equals("settings_recommend_mobilefriends_to_me"))
    {
      if (!((CheckBoxPreference)paramf.aVD("settings_recommend_mobilefriends_to_me")).isChecked()) {}
      for (bool1 = true;; bool1 = false)
      {
        bool1 = k(bool1, 256, 7);
        AppMethodBeat.o(74353);
        return bool1;
      }
    }
    if (paramPreference.equals("settings_about_blacklist"))
    {
      paramf = com.tencent.mm.model.ad.AL(getString(2131760084));
      paramPreference = new Intent();
      paramPreference.putExtra("filter_type", paramf.getType());
      paramPreference.putExtra("titile", getString(2131763373));
      paramPreference.putExtra("list_attr", 32768);
      com.tencent.mm.plugin.setting.b.iRG.h(this, paramPreference);
      AppMethodBeat.o(74353);
      return true;
    }
    if (paramPreference.equals("timline_outside_permiss"))
    {
      paramf = new Intent();
      paramf.putExtra("k_sns_tag_id", 4L);
      paramf.putExtra("k_sns_from_settings_about_sns", 1);
      com.tencent.mm.bs.d.b(this, "sns", ".ui.SnsBlackDetailUI", paramf);
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
          com.tencent.mm.bs.d.Q(this, "sns", ".ui.SnsTagPartlyUI");
        }
        else if (paramPreference.equals("timeline_black_permiss"))
        {
          paramf = new Intent();
          paramf.putExtra("k_sns_tag_id", 5L);
          paramf.putExtra("k_sns_from_settings_about_sns", 2);
          paramf.putExtra("k_tag_detail_sns_block_scene", 8);
          com.tencent.mm.bs.d.b(this, "sns", ".ui.SnsTagDetailUI", paramf);
        }
        else if (paramPreference.equals("timeline_stranger_show"))
        {
          if (!this.yFW) {}
          for (;;)
          {
            this.yFW = bool1;
            if (o.zbT != null) {
              o.zbT.bJ(this.fFK, this.yFW);
            }
            if (o.zbT == null) {
              break;
            }
            paramf = o.zbT.bK(this.fFK, this.yFW);
            o.zbT.a(this.fFK, paramf);
            if (paramf != null) {
              break label471;
            }
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SettingPrivacy", "userinfo in null !");
            AppMethodBeat.o(74353);
            return false;
            bool1 = false;
          }
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SettingPrivacy", "dancy userinfo " + paramf.toString());
          ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(new k.a(51, paramf));
        }
        else
        {
          if (paramPreference.equals("settings_find_google_contact"))
          {
            bool1 = bool2;
            if (!((CheckBoxPreference)paramf.aVD("settings_find_google_contact")).isChecked()) {
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
            com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramf.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(74353);
            return true;
          }
          if (paramPreference.equals("timeline_recent_show_select"))
          {
            dNW();
          }
          else if (paramPreference.equals("settings_unfamiliar_contact"))
          {
            paramf = new Intent(this, UnfamiliarContactUI.class);
            paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "gotoUnfamiliarContactUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramf.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "gotoUnfamiliarContactUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            if (!paramPreference.equals("settings_auth_manage")) {
              break;
            }
            paramf = new Intent(this, SettingsManageAuthUI.class);
            paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramf.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
      }
    } while (!paramPreference.equals("settings_story_notify"));
    if (!this.yIC)
    {
      bool1 = true;
      this.yIC = bool1;
      if (!this.yIC) {
        break label1001;
      }
    }
    label1001:
    for (this.yID.HyR = 0;; this.yID.HyR = 1)
    {
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).updateStoryUserInfo(this.fFK, this.yID);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(new k.a(71, this.yID));
      dBh();
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
    this.status = u.aAq();
    dBh();
    if (!this.fMY)
    {
      String str = getIntent().getStringExtra("need_matte_high_light_item");
      if (!bt.isNullOrNil(str))
      {
        final int i = this.screen.aVF(str);
        setSelection(i - 3);
        new ap().postDelayed(new Runnable()
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
      this.fMY = true;
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