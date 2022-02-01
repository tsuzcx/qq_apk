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
import com.tencent.mm.model.ab;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.aqc;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.deq;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  private String fnC;
  boolean ftX;
  private HashMap<Integer, Integer> iHo;
  private com.tencent.mm.ui.base.preference.f screen;
  private int status;
  private boolean xrn;
  private boolean xtN;
  private boolean xtO;
  private boolean xtP;
  private boolean xtQ;
  private boolean xtR;
  private deq xtS;
  private int xtT;
  private boolean xtz;
  
  public SettingsPrivacyUI()
  {
    AppMethodBeat.i(74347);
    this.iHo = new HashMap();
    this.fnC = "";
    this.xtz = true;
    this.xrn = false;
    this.xtN = false;
    this.xtO = false;
    this.xtP = false;
    this.xtQ = false;
    this.xtR = true;
    this.xtS = null;
    this.ftX = false;
    this.xtT = e.i.Hhm;
    AppMethodBeat.o(74347);
  }
  
  private boolean Lr(int paramInt)
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
  
  private void dCt()
  {
    AppMethodBeat.i(74354);
    Object localObject1 = new dbt();
    if (o.xMb != null) {
      localObject1 = o.xMb.asG(this.fnC);
    }
    if (localObject1 == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SettingPrivacy", "userinfo is null");
      AppMethodBeat.o(74354);
      return;
    }
    int i = ((Integer)g.agR().agA().get(ah.a.GLZ, Integer.valueOf(0))).intValue();
    if (i > ((Integer)g.agR().agA().get(ah.a.GMa, Integer.valueOf(0))).intValue())
    {
      g.agR().agA().set(ah.a.GMa, Integer.valueOf(i));
      dqE();
    }
    Object localObject2 = new d.a(getContext());
    ((d.a)localObject2).acN(2131755691);
    ((d.a)localObject2).acF(2131757669);
    View localView = View.inflate(getContext(), 2131494769, null);
    localObject1 = (LinearLayout)localView.findViewById(2131305591);
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74345);
        int i = 0;
        while (i < this.xrd.getChildCount())
        {
          localObject = (TextView)this.xrd.getChildAt(i);
          if (2131305896 != ((TextView)localObject).getId()) {
            ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2131691077, 0, 0, 0);
          }
          i += 1;
        }
        ((TextView)paramAnonymousView).setCompoundDrawablesWithIntrinsicBounds(2131691078, 0, 0, 0);
        Object localObject = new dbt();
        if (o.xMb != null) {
          localObject = o.xMb.asG(SettingsPrivacyUI.b(SettingsPrivacyUI.this));
        }
        if (localObject == null)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SettingPrivacy", "userinfo is null");
          AppMethodBeat.o(74345);
          return;
        }
        i = ((Integer)paramAnonymousView.getTag()).intValue();
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SettingPrivacy", "settings_silence_update_mode choice: %d", new Object[] { Integer.valueOf(i) });
        if (i == 0)
        {
          if (SettingsPrivacyUI.c(SettingsPrivacyUI.this) == e.i.Hhn) {
            com.tencent.mm.plugin.report.service.h.wUl.f(14090, new Object[] { Integer.valueOf(4) });
          }
          SettingsPrivacyUI.a(SettingsPrivacyUI.this, false);
          SettingsPrivacyUI.b(SettingsPrivacyUI.this, true);
          SettingsPrivacyUI.c(SettingsPrivacyUI.this, false);
          SettingsPrivacyUI.d(SettingsPrivacyUI.this);
        }
        for (;;)
        {
          if (o.xMb != null) {
            o.xMb.a(SettingsPrivacyUI.b(SettingsPrivacyUI.this), SettingsPrivacyUI.e(SettingsPrivacyUI.this), SettingsPrivacyUI.f(SettingsPrivacyUI.this), SettingsPrivacyUI.g(SettingsPrivacyUI.this), SettingsPrivacyUI.h(SettingsPrivacyUI.this));
          }
          if (o.xMb == null) {
            break label575;
          }
          localObject = o.xMb.b(SettingsPrivacyUI.b(SettingsPrivacyUI.this), SettingsPrivacyUI.e(SettingsPrivacyUI.this), SettingsPrivacyUI.f(SettingsPrivacyUI.this), SettingsPrivacyUI.g(SettingsPrivacyUI.this), SettingsPrivacyUI.h(SettingsPrivacyUI.this));
          if (localObject != null) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SettingPrivacy", "userinfo in null !");
          AppMethodBeat.o(74345);
          return;
          if (i == 1)
          {
            if (SettingsPrivacyUI.c(SettingsPrivacyUI.this) == e.i.Hhn) {
              com.tencent.mm.plugin.report.service.h.wUl.f(14090, new Object[] { Integer.valueOf(5) });
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
            if (SettingsPrivacyUI.c(SettingsPrivacyUI.this) == e.i.Hhn) {
              com.tencent.mm.plugin.report.service.h.wUl.f(14090, new Object[] { Integer.valueOf(6) });
            }
            SettingsPrivacyUI.a(SettingsPrivacyUI.this, false);
            SettingsPrivacyUI.b(SettingsPrivacyUI.this, false);
            SettingsPrivacyUI.c(SettingsPrivacyUI.this, false);
            SettingsPrivacyUI.d(SettingsPrivacyUI.this);
          }
        }
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SettingPrivacy", "dancy userinfo " + localObject.toString());
        ((k)g.ab(k.class)).awA().c(new j.a(51, (com.tencent.mm.bw.a)localObject));
        label575:
        paramAnonymousView.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74344);
            ((Dialog)SettingsPrivacyUI.2.this.xrd.getTag()).dismiss();
            SettingsPrivacyUI.i(SettingsPrivacyUI.this);
            AppMethodBeat.o(74344);
          }
        });
        AppMethodBeat.o(74345);
      }
    };
    a((LinearLayout)localObject1, 2131757671, 1, this.xtN, local2);
    a((LinearLayout)localObject1, 2131757672, 3, this.xtQ, local2);
    a((LinearLayout)localObject1, 2131757673, 0, this.xtO, local2);
    if ((!this.xtN) && (!this.xtO) && (!this.xtQ)) {}
    for (boolean bool = true;; bool = false)
    {
      a((LinearLayout)localObject1, 2131757670, 2, bool, local2);
      ((d.a)localObject2).gH(localView);
      localObject2 = ((d.a)localObject2).fvp();
      ((LinearLayout)localObject1).setTag(localObject2);
      ((com.tencent.mm.ui.widget.a.d)localObject2).show();
      addDialog((Dialog)localObject2);
      AppMethodBeat.o(74354);
      return;
    }
  }
  
  private void dqE()
  {
    AppMethodBeat.i(74358);
    Object localObject = new dbt();
    deq localdeq = ((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUserInfo();
    if (o.xMb != null) {
      localObject = o.xMb.asG(this.fnC);
    }
    for (;;)
    {
      if (localObject == null)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SettingPrivacy", "userinfo is null");
        AppMethodBeat.o(74358);
        return;
      }
      int i = ((dbt)localObject).FLb;
      int j = ((dbt)localObject).FLc;
      localObject = (CheckBoxPreference)this.screen.aPN("timeline_stranger_show");
      boolean bool;
      if (localObject != null)
      {
        ((Preference)localObject).HFK = false;
        if ((i & 0x1) > 0)
        {
          bool = true;
          this.xrn = bool;
          if (this.xrn) {
            break label534;
          }
          ((CheckBoxPreference)localObject).mF = true;
        }
      }
      else
      {
        label133:
        localObject = (IconPreference)this.screen.aPN("timeline_recent_show_select");
        if (localObject != null)
        {
          ((Preference)localObject).HFK = false;
          if ((j != 4320) || ((i & 0x1000) <= 0)) {
            break label543;
          }
          bool = true;
          label178:
          this.xtN = bool;
          if ((j != 72) || ((i & 0x1000) <= 0)) {
            break label548;
          }
          bool = true;
          label199:
          this.xtO = bool;
          if ((j != 720) || ((i & 0x1000) <= 0)) {
            break label553;
          }
          bool = true;
          label221:
          this.xtQ = bool;
          if ((i & 0x800) <= 0) {
            break label558;
          }
          bool = true;
          label236:
          this.xtP = bool;
          if (!this.xtN) {
            break label563;
          }
          ((IconPreference)localObject).setSummary(2131757671);
          label255:
          i = ((Integer)g.agR().agA().get(ah.a.GLZ, Integer.valueOf(0))).intValue();
          j = ((Integer)g.agR().agA().get(ah.a.GMa, Integer.valueOf(0))).intValue();
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SettingPrivacy", "willShowRecentRedCodeId  %d, currentRecentRedCodeId %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (i <= j) {
            break label607;
          }
          ((IconPreference)localObject).aad(0);
        }
        label338:
        if ((!com.tencent.mm.br.d.aCT("sns")) || ((u.axI() & 0x8000) != 0)) {
          break label617;
        }
        bool = true;
        label359:
        this.xtz = bool;
        localObject = new StringBuilder("isSnsOpenEntrance ").append(this.xtz).append(", install ").append(com.tencent.mm.br.d.aCT("sns")).append(", flag ");
        if ((u.axI() & 0x8000) != 0) {
          break label622;
        }
        bool = true;
        label416:
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SettingPrivacy", bool);
        if (!this.xtz) {
          break label627;
        }
        this.screen.cK("settings_story_notify", false);
        label451:
        if (this.xtz)
        {
          localObject = (CheckBoxPreference)this.screen.aPN("settings_story_notify");
          if (localObject != null)
          {
            ((Preference)localObject).HFK = false;
            if (localdeq.FOg != 0) {
              break label644;
            }
            bool = true;
            label496:
            this.xtR = bool;
            if (!this.xtR) {
              break label649;
            }
          }
        }
      }
      label644:
      label649:
      for (((CheckBoxPreference)localObject).mF = true;; ((CheckBoxPreference)localObject).mF = false)
      {
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(74358);
        return;
        bool = false;
        break;
        label534:
        ((CheckBoxPreference)localObject).mF = false;
        break label133;
        label543:
        bool = false;
        break label178;
        label548:
        bool = false;
        break label199;
        label553:
        bool = false;
        break label221;
        label558:
        bool = false;
        break label236;
        label563:
        if (this.xtO)
        {
          ((IconPreference)localObject).setSummary(2131757673);
          break label255;
        }
        if (this.xtQ)
        {
          ((IconPreference)localObject).setSummary(2131757672);
          break label255;
        }
        ((IconPreference)localObject).setSummary(2131757670);
        break label255;
        label607:
        ((IconPreference)localObject).aad(8);
        break label338;
        label617:
        bool = false;
        break label359;
        label622:
        bool = false;
        break label416;
        label627:
        this.screen.cK("settings_story_notify", true);
        break label451;
        bool = false;
        break label496;
      }
    }
  }
  
  private boolean i(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74357);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SettingPrivacy", "switch change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
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
      this.iHo.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
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
    com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.SettingPrivacy", "init function status: " + Integer.toBinaryString(this.status));
    Object localObject1 = (CheckBoxPreference)this.screen.aPN("settings_need_verify");
    ((Preference)localObject1).HFK = false;
    ((CheckBoxPreference)localObject1).mF = Lr(32);
    localObject1 = (String)g.agR().agA().get(6, null);
    Object localObject2 = (CheckBoxPreference)this.screen.aPN("settings_recommend_mobilefriends_to_me");
    ((Preference)localObject2).HFK = false;
    boolean bool1;
    if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
      if (!Lr(256))
      {
        bool1 = true;
        ((CheckBoxPreference)localObject2).mF = bool1;
      }
    }
    for (;;)
    {
      localObject1 = (CheckBoxPreference)this.screen.aPN("settings_find_google_contact");
      ((Preference)localObject1).HFK = false;
      bool1 = bool2;
      if (!Lr(1048576)) {
        bool1 = true;
      }
      ((CheckBoxPreference)localObject1).mF = bool1;
      localObject2 = (String)g.agR().agA().get(208903, null);
      if ((!bs.ja(this)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        this.screen.d((Preference)localObject1);
      }
      if ((!((Boolean)g.agR().agA().get(335873, Boolean.TRUE)).booleanValue()) || (!o.xMd.dGq())) {
        this.screen.cK("edit_timeline_group", true);
      }
      this.screen.cK("settings_unfamiliar_contact", true);
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
    this.status = u.axA();
    this.fnC = u.axw();
    this.xtS = ((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUserInfo();
    if (this.xtS.FOg == 0)
    {
      bool1 = true;
      this.xtR = bool1;
      this.xtT = getIntent().getIntExtra("enter_scene", e.i.Hhm);
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SettingPrivacy", "story Notify:%s", new Object[] { Boolean.valueOf(this.xtR) });
      initView();
      com.tencent.mm.plugin.report.service.h.wUl.f(14098, new Object[] { Integer.valueOf(9) });
      if ((this.xtT == e.i.Hhn) || (this.xtT == e.i.Hho))
      {
        paramBundle = new dbt();
        if (o.xMb != null) {
          paramBundle = o.xMb.asG(this.fnC);
        }
        if (paramBundle != null)
        {
          int i = paramBundle.FLb;
          int j = paramBundle.FLc;
          if ((j != 4320) || ((i & 0x1000) <= 0)) {
            break label303;
          }
          bool1 = true;
          label215:
          this.xtN = bool1;
          if ((j != 72) || ((i & 0x1000) <= 0)) {
            break label309;
          }
          bool1 = true;
          label238:
          this.xtO = bool1;
          if ((j != 720) || ((i & 0x1000) <= 0)) {
            break label315;
          }
          bool1 = true;
          label262:
          this.xtQ = bool1;
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
      this.xtP = bool1;
      dCt();
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
    g.agR().agA().set(7, Integer.valueOf(this.status));
    Iterator localIterator = this.iHo.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new aqc();
      ((aqc)localObject).EIY = i;
      ((aqc)localObject).vVH = j;
      ((k)g.ab(k.class)).awA().c(new j.a(23, (com.tencent.mm.bw.a)localObject));
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SettingPrivacy", "switch  " + i + " " + j);
    }
    this.iHo.clear();
    AppMethodBeat.o(74351);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(74353);
    paramPreference = paramPreference.mKey;
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SettingPrivacy", paramPreference + " item has been clicked!");
    getDefaultSharedPreferences();
    if (paramPreference.equals("settings_need_verify"))
    {
      bool1 = i(((CheckBoxPreference)paramf.aPN("settings_need_verify")).isChecked(), 32, 4);
      AppMethodBeat.o(74353);
      return bool1;
    }
    if (paramPreference.equals("settings_recommend_mobilefriends_to_me"))
    {
      if (!((CheckBoxPreference)paramf.aPN("settings_recommend_mobilefriends_to_me")).isChecked()) {}
      for (bool1 = true;; bool1 = false)
      {
        bool1 = i(bool1, 256, 7);
        AppMethodBeat.o(74353);
        return bool1;
      }
    }
    if (paramPreference.equals("settings_about_blacklist"))
    {
      paramf = com.tencent.mm.model.ac.xL(getString(2131760084));
      paramPreference = new Intent();
      paramPreference.putExtra("filter_type", paramf.getType());
      paramPreference.putExtra("titile", getString(2131763373));
      paramPreference.putExtra("list_attr", 32768);
      b.iyx.h(this, paramPreference);
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
    label475:
    do
    {
      for (;;)
      {
        AppMethodBeat.o(74353);
        return false;
        if (paramPreference.equals("edit_timeline_group"))
        {
          com.tencent.mm.br.d.N(this, "sns", ".ui.SnsTagPartlyUI");
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
          if (!this.xrn) {}
          for (;;)
          {
            this.xrn = bool1;
            if (o.xMb != null) {
              o.xMb.bC(this.fnC, this.xrn);
            }
            if (o.xMb == null) {
              break;
            }
            paramf = o.xMb.bD(this.fnC, this.xrn);
            o.xMb.a(this.fnC, paramf);
            if (paramf != null) {
              break label475;
            }
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SettingPrivacy", "userinfo in null !");
            AppMethodBeat.o(74353);
            return false;
            bool1 = false;
          }
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SettingPrivacy", "dancy userinfo " + paramf.toString());
          ((k)g.ab(k.class)).awA().c(new j.a(51, paramf));
        }
        else
        {
          if (paramPreference.equals("settings_find_google_contact"))
          {
            bool1 = bool2;
            if (!((CheckBoxPreference)paramf.aPN("settings_find_google_contact")).isChecked()) {
              bool1 = true;
            }
            i(bool1, 1048576, 29);
            AppMethodBeat.o(74353);
            return true;
          }
          if (paramPreference.equals("settings_add_me_way"))
          {
            paramf = new Intent(this, SettingsAddMeUI.class);
            paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramf.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(74353);
            return true;
          }
          if (paramPreference.equals("timeline_recent_show_select"))
          {
            dCt();
          }
          else if (paramPreference.equals("settings_unfamiliar_contact"))
          {
            paramf = new Intent(this, UnfamiliarContactUI.class);
            paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "gotoUnfamiliarContactUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramf.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "gotoUnfamiliarContactUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            if (!paramPreference.equals("settings_auth_manage")) {
              break;
            }
            paramf = new Intent(this, SettingsManageAuthUI.class);
            paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramf.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
      }
    } while (!paramPreference.equals("settings_story_notify"));
    if (!this.xtR)
    {
      bool1 = true;
      this.xtR = bool1;
      if (!this.xtR) {
        break label1006;
      }
    }
    label1006:
    for (this.xtS.FOg = 0;; this.xtS.FOg = 1)
    {
      ((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).updateStoryUserInfo(this.fnC, this.xtS);
      ((k)g.ab(k.class)).awA().c(new j.a(71, this.xtS));
      dqE();
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
    this.status = u.axA();
    dqE();
    if (!this.ftX)
    {
      String str = getIntent().getStringExtra("need_matte_high_light_item");
      if (!bs.isNullOrNil(str))
      {
        final int i = this.screen.aPP(str);
        setSelection(i - 3);
        new ao().postDelayed(new Runnable()
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
      this.ftX = true;
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