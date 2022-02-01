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
import com.tencent.mm.model.ac;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.plugin.sns.c.o;
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.protocal.protobuf.cze;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.e.i;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsPrivacyUI
  extends MMPreference
{
  private String fki;
  boolean fqt;
  private HashMap<Integer, Integer> ihg;
  private com.tencent.mm.ui.base.preference.f screen;
  private int status;
  private boolean wfX;
  private boolean wiB;
  private cze wiC;
  private int wiD;
  private boolean wiv;
  private boolean wiw;
  private boolean wix;
  private boolean wiy;
  private boolean wiz;
  
  public SettingsPrivacyUI()
  {
    AppMethodBeat.i(74347);
    this.ihg = new HashMap();
    this.fki = "";
    this.wiv = true;
    this.wfX = false;
    this.wiw = false;
    this.wix = false;
    this.wiy = false;
    this.wiz = false;
    this.wiB = true;
    this.wiC = null;
    this.fqt = false;
    this.wiD = e.i.FIe;
    AppMethodBeat.o(74347);
  }
  
  private boolean Js(int paramInt)
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
  
  private void dcW()
  {
    AppMethodBeat.i(74358);
    Object localObject = new cwh();
    cze localcze = ((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUserInfo();
    if (o.wzH != null) {
      localObject = o.wzH.anu(this.fki);
    }
    for (;;)
    {
      if (localObject == null)
      {
        ad.e("MicroMsg.SettingPrivacy", "userinfo is null");
        AppMethodBeat.o(74358);
        return;
      }
      int i = ((cwh)localObject).Eoc;
      int j = ((cwh)localObject).Eod;
      localObject = (CheckBoxPreference)this.screen.aKk("timeline_stranger_show");
      boolean bool;
      if (localObject != null)
      {
        ((Preference)localObject).GfV = false;
        if ((i & 0x1) > 0)
        {
          bool = true;
          this.wfX = bool;
          if (this.wfX) {
            break label529;
          }
          ((CheckBoxPreference)localObject).lG = true;
        }
      }
      else
      {
        label132:
        localObject = (IconPreference)this.screen.aKk("timeline_recent_show_select");
        if (localObject != null)
        {
          ((Preference)localObject).GfV = false;
          if ((j != 4320) || ((i & 0x1000) <= 0)) {
            break label538;
          }
          bool = true;
          label176:
          this.wiw = bool;
          if ((j != 72) || ((i & 0x1000) <= 0)) {
            break label543;
          }
          bool = true;
          label197:
          this.wix = bool;
          if ((j != 720) || ((i & 0x1000) <= 0)) {
            break label548;
          }
          bool = true;
          label219:
          this.wiz = bool;
          if ((i & 0x800) <= 0) {
            break label553;
          }
          bool = true;
          label234:
          this.wiy = bool;
          if (!this.wiw) {
            break label558;
          }
          ((IconPreference)localObject).setSummary(2131757671);
          label253:
          i = ((Integer)g.afB().afk().get(ae.a.Fok, Integer.valueOf(0))).intValue();
          j = ((Integer)g.afB().afk().get(ae.a.Fol, Integer.valueOf(0))).intValue();
          ad.i("MicroMsg.SettingPrivacy", "willShowRecentRedCodeId  %d, currentRecentRedCodeId %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (i <= j) {
            break label605;
          }
          ((IconPreference)localObject).XS(0);
        }
        label335:
        if ((!com.tencent.mm.bs.d.axB("sns")) || ((u.aqS() & 0x8000) != 0)) {
          break label615;
        }
        bool = true;
        label355:
        this.wiv = bool;
        localObject = new StringBuilder("isSnsOpenEntrance ").append(this.wiv).append(", install ").append(com.tencent.mm.bs.d.axB("sns")).append(", flag ");
        if ((u.aqS() & 0x8000) != 0) {
          break label620;
        }
        bool = true;
        label411:
        ad.i("MicroMsg.SettingPrivacy", bool);
        if (!this.wiv) {
          break label625;
        }
        this.screen.cE("settings_story_notify", false);
        label446:
        if (this.wiv)
        {
          localObject = (CheckBoxPreference)this.screen.aKk("settings_story_notify");
          if (localObject != null)
          {
            ((Preference)localObject).GfV = false;
            if (localcze.Ere != 0) {
              break label642;
            }
            bool = true;
            label491:
            this.wiB = bool;
            if (!this.wiB) {
              break label647;
            }
          }
        }
      }
      label642:
      label647:
      for (((CheckBoxPreference)localObject).lG = true;; ((CheckBoxPreference)localObject).lG = false)
      {
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(74358);
        return;
        bool = false;
        break;
        label529:
        ((CheckBoxPreference)localObject).lG = false;
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
        if (this.wix)
        {
          ((IconPreference)localObject).setSummary(2131757673);
          break label253;
        }
        if (this.wiz)
        {
          ((IconPreference)localObject).setSummary(2131757672);
          break label253;
        }
        ((IconPreference)localObject).setSummary(2131757670);
        break label253;
        label605:
        ((IconPreference)localObject).XS(8);
        break label335;
        label615:
        bool = false;
        break label355;
        label620:
        bool = false;
        break label411;
        label625:
        this.screen.cE("settings_story_notify", true);
        break label446;
        bool = false;
        break label491;
      }
    }
  }
  
  private void doj()
  {
    AppMethodBeat.i(74354);
    Object localObject1 = new cwh();
    if (o.wzH != null) {
      localObject1 = o.wzH.anu(this.fki);
    }
    if (localObject1 == null)
    {
      ad.e("MicroMsg.SettingPrivacy", "userinfo is null");
      AppMethodBeat.o(74354);
      return;
    }
    int i = ((Integer)g.afB().afk().get(ae.a.Fok, Integer.valueOf(0))).intValue();
    if (i > ((Integer)g.afB().afk().get(ae.a.Fol, Integer.valueOf(0))).intValue())
    {
      g.afB().afk().set(ae.a.Fol, Integer.valueOf(i));
      dcW();
    }
    Object localObject2 = new d.a(getContext());
    ((d.a)localObject2).aaC(2131755691);
    ((d.a)localObject2).aau(2131757669);
    View localView = View.inflate(getContext(), 2131494769, null);
    localObject1 = (LinearLayout)localView.findViewById(2131305591);
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74345);
        int i = 0;
        while (i < this.wfN.getChildCount())
        {
          localObject = (TextView)this.wfN.getChildAt(i);
          if (2131305896 != ((TextView)localObject).getId()) {
            ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2131691077, 0, 0, 0);
          }
          i += 1;
        }
        ((TextView)paramAnonymousView).setCompoundDrawablesWithIntrinsicBounds(2131691078, 0, 0, 0);
        Object localObject = new cwh();
        if (o.wzH != null) {
          localObject = o.wzH.anu(SettingsPrivacyUI.b(SettingsPrivacyUI.this));
        }
        if (localObject == null)
        {
          ad.e("MicroMsg.SettingPrivacy", "userinfo is null");
          AppMethodBeat.o(74345);
          return;
        }
        i = ((Integer)paramAnonymousView.getTag()).intValue();
        ad.i("MicroMsg.SettingPrivacy", "settings_silence_update_mode choice: %d", new Object[] { Integer.valueOf(i) });
        if (i == 0)
        {
          if (SettingsPrivacyUI.c(SettingsPrivacyUI.this) == e.i.FIf) {
            com.tencent.mm.plugin.report.service.h.vKh.f(14090, new Object[] { Integer.valueOf(4) });
          }
          SettingsPrivacyUI.a(SettingsPrivacyUI.this, false);
          SettingsPrivacyUI.b(SettingsPrivacyUI.this, true);
          SettingsPrivacyUI.c(SettingsPrivacyUI.this, false);
          SettingsPrivacyUI.d(SettingsPrivacyUI.this);
        }
        for (;;)
        {
          if (o.wzH != null) {
            o.wzH.a(SettingsPrivacyUI.b(SettingsPrivacyUI.this), SettingsPrivacyUI.e(SettingsPrivacyUI.this), SettingsPrivacyUI.f(SettingsPrivacyUI.this), SettingsPrivacyUI.g(SettingsPrivacyUI.this), SettingsPrivacyUI.h(SettingsPrivacyUI.this));
          }
          if (o.wzH == null) {
            break label575;
          }
          localObject = o.wzH.b(SettingsPrivacyUI.b(SettingsPrivacyUI.this), SettingsPrivacyUI.e(SettingsPrivacyUI.this), SettingsPrivacyUI.f(SettingsPrivacyUI.this), SettingsPrivacyUI.g(SettingsPrivacyUI.this), SettingsPrivacyUI.h(SettingsPrivacyUI.this));
          if (localObject != null) {
            break;
          }
          ad.e("MicroMsg.SettingPrivacy", "userinfo in null !");
          AppMethodBeat.o(74345);
          return;
          if (i == 1)
          {
            if (SettingsPrivacyUI.c(SettingsPrivacyUI.this) == e.i.FIf) {
              com.tencent.mm.plugin.report.service.h.vKh.f(14090, new Object[] { Integer.valueOf(5) });
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
            if (SettingsPrivacyUI.c(SettingsPrivacyUI.this) == e.i.FIf) {
              com.tencent.mm.plugin.report.service.h.vKh.f(14090, new Object[] { Integer.valueOf(6) });
            }
            SettingsPrivacyUI.a(SettingsPrivacyUI.this, false);
            SettingsPrivacyUI.b(SettingsPrivacyUI.this, false);
            SettingsPrivacyUI.c(SettingsPrivacyUI.this, false);
            SettingsPrivacyUI.d(SettingsPrivacyUI.this);
          }
        }
        ad.d("MicroMsg.SettingPrivacy", "dancy userinfo " + localObject.toString());
        ((k)g.ab(k.class)).apL().c(new j.a(51, (com.tencent.mm.bx.a)localObject));
        label575:
        paramAnonymousView.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74344);
            ((Dialog)SettingsPrivacyUI.2.this.wfN.getTag()).dismiss();
            SettingsPrivacyUI.i(SettingsPrivacyUI.this);
            AppMethodBeat.o(74344);
          }
        });
        AppMethodBeat.o(74345);
      }
    };
    a((LinearLayout)localObject1, 2131757671, 1, this.wiw, local2);
    a((LinearLayout)localObject1, 2131757672, 3, this.wiz, local2);
    a((LinearLayout)localObject1, 2131757673, 0, this.wix, local2);
    if ((!this.wiw) && (!this.wix) && (!this.wiz)) {}
    for (boolean bool = true;; bool = false)
    {
      a((LinearLayout)localObject1, 2131757670, 2, bool, local2);
      ((d.a)localObject2).gs(localView);
      localObject2 = ((d.a)localObject2).fft();
      ((LinearLayout)localObject1).setTag(localObject2);
      ((com.tencent.mm.ui.widget.a.d)localObject2).show();
      addDialog((Dialog)localObject2);
      AppMethodBeat.o(74354);
      return;
    }
  }
  
  private boolean i(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74357);
    ad.d("MicroMsg.SettingPrivacy", "switch change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
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
      this.ihg.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
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
    ad.v("MicroMsg.SettingPrivacy", "init function status: " + Integer.toBinaryString(this.status));
    Object localObject1 = (CheckBoxPreference)this.screen.aKk("settings_need_verify");
    ((Preference)localObject1).GfV = false;
    ((CheckBoxPreference)localObject1).lG = Js(32);
    localObject1 = (String)g.afB().afk().get(6, null);
    Object localObject2 = (CheckBoxPreference)this.screen.aKk("settings_recommend_mobilefriends_to_me");
    ((Preference)localObject2).GfV = false;
    boolean bool1;
    if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
      if (!Js(256))
      {
        bool1 = true;
        ((CheckBoxPreference)localObject2).lG = bool1;
      }
    }
    for (;;)
    {
      localObject1 = (CheckBoxPreference)this.screen.aKk("settings_find_google_contact");
      ((Preference)localObject1).GfV = false;
      bool1 = bool2;
      if (!Js(1048576)) {
        bool1 = true;
      }
      ((CheckBoxPreference)localObject1).lG = bool1;
      localObject2 = (String)g.afB().afk().get(208903, null);
      if ((!bt.iP(this)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        this.screen.d((Preference)localObject1);
      }
      if ((!((Boolean)g.afB().afk().get(335873, Boolean.TRUE)).booleanValue()) || (!o.wzJ.drR())) {
        this.screen.cE("edit_timeline_group", true);
      }
      this.screen.cE("settings_unfamiliar_contact", true);
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
    this.status = u.aqK();
    this.fki = u.aqG();
    this.wiC = ((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUserInfo();
    if (this.wiC.Ere == 0)
    {
      bool1 = true;
      this.wiB = bool1;
      this.wiD = getIntent().getIntExtra("enter_scene", e.i.FIe);
      ad.d("MicroMsg.SettingPrivacy", "story Notify:%s", new Object[] { Boolean.valueOf(this.wiB) });
      initView();
      com.tencent.mm.plugin.report.service.h.vKh.f(14098, new Object[] { Integer.valueOf(9) });
      if ((this.wiD == e.i.FIf) || (this.wiD == e.i.FIg))
      {
        paramBundle = new cwh();
        if (o.wzH != null) {
          paramBundle = o.wzH.anu(this.fki);
        }
        if (paramBundle != null)
        {
          int i = paramBundle.Eoc;
          int j = paramBundle.Eod;
          if ((j != 4320) || ((i & 0x1000) <= 0)) {
            break label303;
          }
          bool1 = true;
          label215:
          this.wiw = bool1;
          if ((j != 72) || ((i & 0x1000) <= 0)) {
            break label309;
          }
          bool1 = true;
          label238:
          this.wix = bool1;
          if ((j != 720) || ((i & 0x1000) <= 0)) {
            break label315;
          }
          bool1 = true;
          label262:
          this.wiz = bool1;
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
      this.wiy = bool1;
      doj();
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
    g.afB().afk().set(7, Integer.valueOf(this.status));
    Iterator localIterator = this.ihg.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new amy();
      ((amy)localObject).DnY = i;
      ((amy)localObject).uMR = j;
      ((k)g.ab(k.class)).apL().c(new j.a(23, (com.tencent.mm.bx.a)localObject));
      ad.d("MicroMsg.SettingPrivacy", "switch  " + i + " " + j);
    }
    this.ihg.clear();
    AppMethodBeat.o(74351);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(74353);
    paramPreference = paramPreference.mKey;
    ad.i("MicroMsg.SettingPrivacy", paramPreference + " item has been clicked!");
    getDefaultSharedPreferences();
    if (paramPreference.equals("settings_need_verify"))
    {
      bool1 = i(((CheckBoxPreference)paramf.aKk("settings_need_verify")).isChecked(), 32, 4);
      AppMethodBeat.o(74353);
      return bool1;
    }
    if (paramPreference.equals("settings_recommend_mobilefriends_to_me"))
    {
      if (!((CheckBoxPreference)paramf.aKk("settings_recommend_mobilefriends_to_me")).isChecked()) {}
      for (bool1 = true;; bool1 = false)
      {
        bool1 = i(bool1, 256, 7);
        AppMethodBeat.o(74353);
        return bool1;
      }
    }
    if (paramPreference.equals("settings_about_blacklist"))
    {
      paramf = ac.tF(getString(2131760084));
      paramPreference = new Intent();
      paramPreference.putExtra("filter_type", paramf.getType());
      paramPreference.putExtra("titile", getString(2131763373));
      paramPreference.putExtra("list_attr", 32768);
      b.hYt.h(this, paramPreference);
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
          com.tencent.mm.bs.d.O(this, "sns", ".ui.SnsTagPartlyUI");
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
          if (!this.wfX) {}
          for (;;)
          {
            this.wfX = bool1;
            if (o.wzH != null) {
              o.wzH.bv(this.fki, this.wfX);
            }
            if (o.wzH == null) {
              break;
            }
            paramf = o.wzH.bw(this.fki, this.wfX);
            o.wzH.a(this.fki, paramf);
            if (paramf != null) {
              break label471;
            }
            ad.e("MicroMsg.SettingPrivacy", "userinfo in null !");
            AppMethodBeat.o(74353);
            return false;
            bool1 = false;
          }
          ad.d("MicroMsg.SettingPrivacy", "dancy userinfo " + paramf.toString());
          ((k)g.ab(k.class)).apL().c(new j.a(51, paramf));
        }
        else
        {
          if (paramPreference.equals("settings_find_google_contact"))
          {
            bool1 = bool2;
            if (!((CheckBoxPreference)paramf.aKk("settings_find_google_contact")).isChecked()) {
              bool1 = true;
            }
            i(bool1, 1048576, 29);
            AppMethodBeat.o(74353);
            return true;
          }
          if (paramPreference.equals("settings_add_me_way"))
          {
            paramf = new Intent(this, SettingsAddMeUI.class);
            paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramf.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(74353);
            return true;
          }
          if (paramPreference.equals("timeline_recent_show_select"))
          {
            doj();
          }
          else if (paramPreference.equals("settings_unfamiliar_contact"))
          {
            paramf = new Intent(this, UnfamiliarContactUI.class);
            paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "gotoUnfamiliarContactUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramf.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "gotoUnfamiliarContactUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            if (!paramPreference.equals("settings_auth_manage")) {
              break;
            }
            paramf = new Intent(this, SettingsManageAuthUI.class);
            paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramf.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
      }
    } while (!paramPreference.equals("settings_story_notify"));
    if (!this.wiB)
    {
      bool1 = true;
      this.wiB = bool1;
      if (!this.wiB) {
        break label1001;
      }
    }
    label1001:
    for (this.wiC.Ere = 0;; this.wiC.Ere = 1)
    {
      ((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).updateStoryUserInfo(this.fki, this.wiC);
      ((k)g.ab(k.class)).apL().c(new j.a(71, this.wiC));
      dcW();
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
    this.status = u.aqK();
    dcW();
    if (!this.fqt)
    {
      String str = getIntent().getStringExtra("need_matte_high_light_item");
      if (!bt.isNullOrNil(str))
      {
        final int i = this.screen.aKm(str);
        setSelection(i - 3);
        new ap().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74343);
            View localView = ((com.tencent.mm.ui.base.preference.a)SettingsPrivacyUI.a(SettingsPrivacyUI.this)).a(i, SettingsPrivacyUI.this.getListView());
            if (localView != null) {
              com.tencent.mm.ui.h.a.b(SettingsPrivacyUI.this.getContext(), localView);
            }
            AppMethodBeat.o(74343);
          }
        }, 10L);
      }
      this.fqt = true;
    }
    AppMethodBeat.o(74350);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI
 * JD-Core Version:    0.7.0.1
 */