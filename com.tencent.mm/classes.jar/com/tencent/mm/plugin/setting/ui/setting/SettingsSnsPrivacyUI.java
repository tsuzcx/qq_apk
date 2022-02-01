package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
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
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.protocal.protobuf.elj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.f.m;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsSnsPrivacyUI
  extends MMPreference
{
  private boolean Jgu;
  private long Jje;
  private boolean Jjf;
  private boolean Jjg;
  private boolean Jjh;
  private boolean Jji;
  private int Jjl;
  private String iRj;
  boolean iYB;
  private HashMap<Integer, Integer> mSR;
  private com.tencent.mm.ui.base.preference.f screen;
  private int status;
  private long tZb;
  
  public SettingsSnsPrivacyUI()
  {
    AppMethodBeat.i(263853);
    this.mSR = new HashMap();
    this.iRj = "";
    this.Jgu = false;
    this.Jjf = false;
    this.Jjg = false;
    this.Jjh = false;
    this.Jji = false;
    this.iYB = false;
    this.Jjl = f.m.VSx;
    AppMethodBeat.o(263853);
  }
  
  private void a(LinearLayout paramLinearLayout, int paramInt1, int paramInt2, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(263860);
    TextView localTextView = (TextView)View.inflate(getContext(), b.g.radio_btn_item, null);
    localTextView.setText(paramInt1);
    localTextView.setTag(Integer.valueOf(paramInt2));
    paramLinearLayout.addView(localTextView);
    localTextView.setOnClickListener(paramOnClickListener);
    if (paramBoolean) {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(b.h.radio_on, 0, 0, 0);
    }
    AppMethodBeat.o(263860);
  }
  
  private void dFf()
  {
    AppMethodBeat.i(263862);
    Object localObject = new elj();
    if (p.JPd != null) {
      localObject = p.JPd.aYN(this.iRj);
    }
    if (localObject == null)
    {
      Log.e("MicroMsg.SettingsSnsPrivacyUI", "userinfo is null");
      AppMethodBeat.o(263862);
      return;
    }
    int i = ((elj)localObject).Unw;
    int j = ((elj)localObject).Unx;
    localObject = (CheckBoxPreference)this.screen.byG("timeline_stranger_show");
    boolean bool;
    if (localObject != null)
    {
      ((Preference)localObject).WsF = false;
      if ((i & 0x1) > 0)
      {
        bool = true;
        this.Jgu = bool;
        if (this.Jgu) {
          break label341;
        }
        ((CheckBoxPreference)localObject).setChecked(true);
      }
    }
    else
    {
      label117:
      localObject = (IconPreference)this.screen.byG("timeline_recent_show_select");
      if (localObject != null)
      {
        ((Preference)localObject).WsF = false;
        if ((j != 4320) || ((i & 0x1000) <= 0)) {
          break label350;
        }
        bool = true;
        label161:
        this.Jjf = bool;
        if ((j != 72) || ((i & 0x1000) <= 0)) {
          break label355;
        }
        bool = true;
        label182:
        this.Jjg = bool;
        if ((j != 720) || ((i & 0x1000) <= 0)) {
          break label360;
        }
        bool = true;
        label204:
        this.Jji = bool;
        if ((i & 0x800) <= 0) {
          break label365;
        }
        bool = true;
        label219:
        this.Jjh = bool;
        if (!this.Jjf) {
          break label370;
        }
        ((IconPreference)localObject).auI(b.i.contact_info_feedsapp_recent_select_half_year);
        label239:
        i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VoT, Integer.valueOf(0))).intValue();
        j = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VoU, Integer.valueOf(0))).intValue();
        Log.i("MicroMsg.SettingsSnsPrivacyUI", "willShowRecentRedCodeId  %d, currentRecentRedCodeId %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (i <= j) {
          break label417;
        }
        ((IconPreference)localObject).aak(0);
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(263862);
      return;
      bool = false;
      break;
      label341:
      ((CheckBoxPreference)localObject).setChecked(false);
      break label117;
      label350:
      bool = false;
      break label161;
      label355:
      bool = false;
      break label182;
      label360:
      bool = false;
      break label204;
      label365:
      bool = false;
      break label219;
      label370:
      if (this.Jjg)
      {
        ((IconPreference)localObject).auI(b.i.contact_info_feedsapp_recent_select_three_day);
        break label239;
      }
      if (this.Jji)
      {
        ((IconPreference)localObject).auI(b.i.contact_info_feedsapp_recent_select_one_month);
        break label239;
      }
      ((IconPreference)localObject).auI(b.i.contact_info_feedsapp_recent_select_all);
      break label239;
      label417:
      ((IconPreference)localObject).aak(8);
    }
  }
  
  public com.tencent.mm.ui.base.preference.h createAdapter(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(263854);
    paramSharedPreferences = new com.tencent.mm.ui.base.preference.a(this, getListView(), paramSharedPreferences);
    AppMethodBeat.o(263854);
    return paramSharedPreferences;
  }
  
  public int getResourceId()
  {
    return b.k.settings_about_sns_privacy;
  }
  
  public void initView()
  {
    AppMethodBeat.i(263861);
    setMMTitle(b.i.settings_about_sns_privacy);
    setBackBtn(new SettingsSnsPrivacyUI.3(this));
    Log.i("MicroMsg.SettingsSnsPrivacyUI", "init function status: " + Integer.toBinaryString(this.status) + "extStatus: " + Long.toBinaryString(this.tZb) + " FinderSetting: " + Long.toBinaryString(this.Jje));
    if ((!((Boolean)com.tencent.mm.kernel.h.aHG().aHp().b(335873, Boolean.TRUE)).booleanValue()) || (!p.JPf.fNc())) {
      this.screen.dz("edit_timeline_group", true);
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(263861);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(263855);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    this.status = z.bdd();
    this.tZb = z.bde();
    this.Jje = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderSwitchApi().edM();
    this.iRj = z.bcZ();
    this.Jjl = getIntent().getIntExtra("enter_scene", f.m.VSx);
    initView();
    AppMethodBeat.o(263855);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(263858);
    super.onDestroy();
    AppMethodBeat.o(263858);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(263857);
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
      Log.d("MicroMsg.SettingsSnsPrivacyUI", "switch  " + i + " " + j);
    }
    this.mSR.clear();
    AppMethodBeat.o(263857);
  }
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(263859);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.SettingsSnsPrivacyUI", paramf + " item has been clicked!");
    getDefaultSharedPreferences();
    if (paramf.equals("timline_outside_permiss"))
    {
      paramf = new Intent();
      paramf.putExtra("k_sns_tag_id", 4L);
      paramf.putExtra("k_sns_from_settings_about_sns", 1);
      paramf.addFlags(268435456);
      paramf.setClassName(this, "com.tencent.mm.ui.contact.privacy.SnsTagDetailUI");
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSnsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSnsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(263859);
      return false;
      if (paramf.equals("edit_timeline_group"))
      {
        c.ad(this, "sns", ".ui.SnsTagPartlyUI");
      }
      else if (paramf.equals("timeline_black_permiss"))
      {
        paramf = new Intent();
        paramf.putExtra("k_sns_tag_id", 5L);
        paramf.putExtra("k_sns_from_settings_about_sns", 2);
        paramf.putExtra("k_tag_detail_sns_block_scene", 8);
        paramf.addFlags(268435456);
        paramf.setClassName(this, "com.tencent.mm.ui.contact.privacy.SnsTagDetailUI");
        paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSnsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSnsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (paramf.equals("timeline_stranger_show"))
      {
        if (!this.Jgu) {}
        for (bool = true;; bool = false)
        {
          this.Jgu = bool;
          if (p.JPd != null) {
            p.JPd.cs(this.iRj, this.Jgu);
          }
          if (p.JPd == null) {
            break;
          }
          paramf = p.JPd.ct(this.iRj, this.Jgu);
          p.JPd.a(this.iRj, paramf);
          if (paramf != null) {
            break label450;
          }
          Log.e("MicroMsg.SettingsSnsPrivacyUI", "userinfo in null !");
          AppMethodBeat.o(263859);
          return false;
        }
        label450:
        Log.d("MicroMsg.SettingsSnsPrivacyUI", "dancy userinfo " + paramf.toString());
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(51, paramf));
      }
      else if (paramf.equals("timeline_recent_show_select"))
      {
        paramf = new elj();
        if (p.JPd != null) {
          paramf = p.JPd.aYN(this.iRj);
        }
        if (paramf != null) {
          break;
        }
        Log.e("MicroMsg.SettingsSnsPrivacyUI", "userinfo is null");
      }
    }
    int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VoT, Integer.valueOf(0))).intValue();
    if (i > ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VoU, Integer.valueOf(0))).intValue())
    {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VoU, Integer.valueOf(i));
      dFf();
    }
    paramPreference = new d.a(getContext());
    paramPreference.ayk(b.i.app_cancel);
    paramPreference.ayc(b.i.contact_info_feedsapp_recent_select);
    View localView = View.inflate(getContext(), b.g.mm_alert_switch, null);
    paramf = (LinearLayout)localView.findViewById(b.f.switcher_container);
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(263690);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsSnsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        int i = 0;
        while (i < paramf.getChildCount())
        {
          localObject = (TextView)paramf.getChildAt(i);
          if (b.f.tips_tv != ((TextView)localObject).getId()) {
            ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(b.h.radio_off, 0, 0, 0);
          }
          i += 1;
        }
        ((TextView)paramAnonymousView).setCompoundDrawablesWithIntrinsicBounds(b.h.radio_on, 0, 0, 0);
        localObject = new elj();
        if (p.JPd != null) {
          localObject = p.JPd.aYN(SettingsSnsPrivacyUI.b(SettingsSnsPrivacyUI.this));
        }
        if (localObject == null)
        {
          Log.e("MicroMsg.SettingsSnsPrivacyUI", "userinfo is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSnsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(263690);
          return;
        }
        i = ((Integer)paramAnonymousView.getTag()).intValue();
        Log.i("MicroMsg.SettingsSnsPrivacyUI", "settings_silence_update_mode choice: %d", new Object[] { Integer.valueOf(i) });
        if (i == 0)
        {
          if (SettingsSnsPrivacyUI.c(SettingsSnsPrivacyUI.this) == f.m.VSy) {
            com.tencent.mm.plugin.report.service.h.IzE.a(14090, new Object[] { Integer.valueOf(4) });
          }
          SettingsSnsPrivacyUI.a(SettingsSnsPrivacyUI.this, false);
          SettingsSnsPrivacyUI.b(SettingsSnsPrivacyUI.this, true);
          SettingsSnsPrivacyUI.c(SettingsSnsPrivacyUI.this, false);
          SettingsSnsPrivacyUI.d(SettingsSnsPrivacyUI.this);
        }
        for (;;)
        {
          if (p.JPd != null) {
            p.JPd.a(SettingsSnsPrivacyUI.b(SettingsSnsPrivacyUI.this), SettingsSnsPrivacyUI.e(SettingsSnsPrivacyUI.this), SettingsSnsPrivacyUI.f(SettingsSnsPrivacyUI.this), SettingsSnsPrivacyUI.g(SettingsSnsPrivacyUI.this), SettingsSnsPrivacyUI.h(SettingsSnsPrivacyUI.this));
          }
          if (p.JPd == null) {
            break label631;
          }
          localObject = p.JPd.b(SettingsSnsPrivacyUI.b(SettingsSnsPrivacyUI.this), SettingsSnsPrivacyUI.e(SettingsSnsPrivacyUI.this), SettingsSnsPrivacyUI.f(SettingsSnsPrivacyUI.this), SettingsSnsPrivacyUI.g(SettingsSnsPrivacyUI.this), SettingsSnsPrivacyUI.h(SettingsSnsPrivacyUI.this));
          if (localObject != null) {
            break;
          }
          Log.e("MicroMsg.SettingsSnsPrivacyUI", "userinfo in null !");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSnsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(263690);
          return;
          if (i == 1)
          {
            if (SettingsSnsPrivacyUI.c(SettingsSnsPrivacyUI.this) == f.m.VSy) {
              com.tencent.mm.plugin.report.service.h.IzE.a(14090, new Object[] { Integer.valueOf(5) });
            }
            SettingsSnsPrivacyUI.a(SettingsSnsPrivacyUI.this, true);
            SettingsSnsPrivacyUI.b(SettingsSnsPrivacyUI.this, false);
            SettingsSnsPrivacyUI.c(SettingsSnsPrivacyUI.this, false);
            SettingsSnsPrivacyUI.d(SettingsSnsPrivacyUI.this);
          }
          else if (i == 3)
          {
            SettingsSnsPrivacyUI.a(SettingsSnsPrivacyUI.this, false);
            SettingsSnsPrivacyUI.b(SettingsSnsPrivacyUI.this, false);
            SettingsSnsPrivacyUI.c(SettingsSnsPrivacyUI.this, true);
            SettingsSnsPrivacyUI.d(SettingsSnsPrivacyUI.this);
          }
          else
          {
            if (SettingsSnsPrivacyUI.c(SettingsSnsPrivacyUI.this) == f.m.VSy) {
              com.tencent.mm.plugin.report.service.h.IzE.a(14090, new Object[] { Integer.valueOf(6) });
            }
            SettingsSnsPrivacyUI.a(SettingsSnsPrivacyUI.this, false);
            SettingsSnsPrivacyUI.b(SettingsSnsPrivacyUI.this, false);
            SettingsSnsPrivacyUI.c(SettingsSnsPrivacyUI.this, false);
            SettingsSnsPrivacyUI.d(SettingsSnsPrivacyUI.this);
          }
        }
        Log.d("MicroMsg.SettingsSnsPrivacyUI", "dancy userinfo " + localObject.toString());
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(51, (com.tencent.mm.cd.a)localObject));
        label631:
        paramAnonymousView.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(264356);
            ((Dialog)SettingsSnsPrivacyUI.2.this.Jgk.getTag()).dismiss();
            SettingsSnsPrivacyUI.i(SettingsSnsPrivacyUI.this);
            AppMethodBeat.o(264356);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSnsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(263690);
      }
    };
    a(paramf, b.i.contact_info_feedsapp_recent_select_half_year, 1, this.Jjf, local2);
    a(paramf, b.i.contact_info_feedsapp_recent_select_one_month, 3, this.Jji, local2);
    a(paramf, b.i.contact_info_feedsapp_recent_select_three_day, 0, this.Jjg, local2);
    i = b.i.contact_info_feedsapp_recent_select_all;
    if ((!this.Jjf) && (!this.Jjg) && (!this.Jji)) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramf, i, 2, bool, local2);
      paramPreference.iI(localView);
      paramPreference = paramPreference.icu();
      paramf.setTag(paramPreference);
      paramPreference.show();
      addDialog(paramPreference);
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(263856);
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
            AppMethodBeat.i(264360);
            View localView = ((com.tencent.mm.ui.base.preference.a)SettingsSnsPrivacyUI.a(SettingsSnsPrivacyUI.this)).a(i, SettingsSnsPrivacyUI.this.getListView());
            if (localView != null) {
              com.tencent.mm.ui.j.a.c(SettingsSnsPrivacyUI.this.getContext(), localView);
            }
            AppMethodBeat.o(264360);
          }
        }, 10L);
      }
      this.iYB = true;
    }
    AppMethodBeat.o(263856);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSnsPrivacyUI
 * JD-Core Version:    0.7.0.1
 */