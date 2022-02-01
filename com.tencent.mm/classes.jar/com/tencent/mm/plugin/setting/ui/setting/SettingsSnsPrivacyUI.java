package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.a.bv;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.h;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.f.n;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsSnsPrivacyUI
  extends MMPreference
{
  private boolean Prm;
  private boolean PvA;
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
  
  public SettingsSnsPrivacyUI()
  {
    AppMethodBeat.i(298897);
    this.pPy = new HashMap();
    this.ltf = "";
    this.Prm = false;
    this.Pvx = false;
    this.Pvy = false;
    this.Pvz = false;
    this.PvA = false;
    this.lAt = false;
    this.PvD = f.n.adwG;
    AppMethodBeat.o(298897);
  }
  
  private void a(LinearLayout paramLinearLayout, int paramInt1, int paramInt2, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(298901);
    TextView localTextView = (TextView)View.inflate(getContext(), b.g.radio_btn_item, null);
    localTextView.setText(paramInt1);
    localTextView.setTag(Integer.valueOf(paramInt2));
    paramLinearLayout.addView(localTextView);
    localTextView.setOnClickListener(paramOnClickListener);
    if (paramBoolean) {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(b.h.radio_on, 0, 0, 0);
    }
    AppMethodBeat.o(298901);
  }
  
  private void evt()
  {
    AppMethodBeat.i(298908);
    Object localObject = new ffs();
    if (q.Qki != null) {
      localObject = q.Qki.aWV(this.ltf);
    }
    if (localObject == null)
    {
      Log.e("MicroMsg.SettingsSnsPrivacyUI", "userinfo is null");
      AppMethodBeat.o(298908);
      return;
    }
    int i = ((ffs)localObject).abFF;
    int j = ((ffs)localObject).abFG;
    localObject = (CheckBoxPreference)this.screen.bAi("timeline_stranger_show");
    boolean bool;
    if (localObject != null)
    {
      ((Preference)localObject).adZV = false;
      if ((i & 0x1) > 0)
      {
        bool = true;
        this.Prm = bool;
        if (this.Prm) {
          break label341;
        }
        ((CheckBoxPreference)localObject).setChecked(true);
      }
    }
    else
    {
      label117:
      localObject = (IconPreference)this.screen.bAi("timeline_recent_show_select");
      if (localObject != null)
      {
        ((Preference)localObject).adZV = false;
        if ((j != 4320) || ((i & 0x1000) <= 0)) {
          break label350;
        }
        bool = true;
        label161:
        this.Pvx = bool;
        if ((j != 72) || ((i & 0x1000) <= 0)) {
          break label355;
        }
        bool = true;
        label182:
        this.Pvy = bool;
        if ((j != 720) || ((i & 0x1000) <= 0)) {
          break label360;
        }
        bool = true;
        label204:
        this.PvA = bool;
        if ((i & 0x800) <= 0) {
          break label365;
        }
        bool = true;
        label219:
        this.Pvz = bool;
        if (!this.Pvx) {
          break label370;
        }
        ((IconPreference)localObject).aBk(b.i.contact_info_feedsapp_recent_select_half_year);
        label239:
        i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acQp, Integer.valueOf(0))).intValue();
        j = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acQq, Integer.valueOf(0))).intValue();
        Log.i("MicroMsg.SettingsSnsPrivacyUI", "willShowRecentRedCodeId  %d, currentRecentRedCodeId %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (i <= j) {
          break label417;
        }
        ((IconPreference)localObject).aeD(0);
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(298908);
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
      if (this.Pvy)
      {
        ((IconPreference)localObject).aBk(b.i.contact_info_feedsapp_recent_select_three_day);
        break label239;
      }
      if (this.PvA)
      {
        ((IconPreference)localObject).aBk(b.i.contact_info_feedsapp_recent_select_one_month);
        break label239;
      }
      ((IconPreference)localObject).aBk(b.i.contact_info_feedsapp_recent_select_all);
      break label239;
      label417:
      ((IconPreference)localObject).aeD(8);
    }
  }
  
  public com.tencent.mm.ui.base.preference.h createAdapter(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(298961);
    paramSharedPreferences = new com.tencent.mm.ui.base.preference.a(this, getListView(), paramSharedPreferences);
    AppMethodBeat.o(298961);
    return paramSharedPreferences;
  }
  
  public int getResourceId()
  {
    return b.k.settings_about_sns_privacy;
  }
  
  public void initView()
  {
    AppMethodBeat.i(298990);
    setMMTitle(b.i.settings_about_sns_privacy);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(298629);
        SettingsSnsPrivacyUI.this.hideVKB();
        SettingsSnsPrivacyUI.this.finish();
        AppMethodBeat.o(298629);
        return true;
      }
    });
    Log.i("MicroMsg.SettingsSnsPrivacyUI", "init function status: " + Integer.toBinaryString(this.status) + "extStatus: " + Long.toBinaryString(this.xct) + " FinderSetting: " + Long.toBinaryString(this.Pvw));
    if ((!((Boolean)com.tencent.mm.kernel.h.baE().ban().d(335873, Boolean.TRUE)).booleanValue()) || (!q.Qkl.hei())) {
      this.screen.eh("edit_timeline_group", true);
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(298990);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(298970);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    this.status = z.bAQ();
    this.xct = z.bAR();
    this.Pvw = ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderSwitchApi().ffD();
    this.ltf = z.bAM();
    this.PvD = getIntent().getIntExtra("enter_scene", f.n.adwG);
    initView();
    AppMethodBeat.o(298970);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(298979);
    super.onDestroy();
    AppMethodBeat.o(298979);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(298977);
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
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzz().d(new k.a(23, (com.tencent.mm.bx.a)localObject));
      Log.d("MicroMsg.SettingsSnsPrivacyUI", "switch  " + i + " " + j);
    }
    this.pPy.clear();
    AppMethodBeat.o(298977);
  }
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(298984);
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
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSnsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSnsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(298984);
      return false;
      if (paramf.equals("edit_timeline_group"))
      {
        c.ai(this, "sns", ".ui.SnsTagPartlyUI");
      }
      else if (paramf.equals("timeline_black_permiss"))
      {
        paramf = new Intent();
        paramf.putExtra("k_sns_tag_id", 5L);
        paramf.putExtra("k_sns_from_settings_about_sns", 2);
        paramf.putExtra("k_tag_detail_sns_block_scene", 8);
        paramf.addFlags(268435456);
        paramf.setClassName(this, "com.tencent.mm.ui.contact.privacy.SnsTagDetailUI");
        paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSnsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSnsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (paramf.equals("timeline_stranger_show"))
      {
        if (!this.Prm) {}
        for (bool = true;; bool = false)
        {
          this.Prm = bool;
          if (q.Qki != null) {
            q.Qki.cR(this.ltf, this.Prm);
          }
          if (q.Qki == null) {
            break;
          }
          paramf = q.Qki.cS(this.ltf, this.Prm);
          q.Qki.a(this.ltf, paramf);
          if (paramf != null) {
            break label450;
          }
          Log.e("MicroMsg.SettingsSnsPrivacyUI", "userinfo in null !");
          AppMethodBeat.o(298984);
          return false;
        }
        label450:
        Log.d("MicroMsg.SettingsSnsPrivacyUI", "dancy userinfo " + paramf.toString());
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzz().d(new k.a(51, paramf));
      }
      else if (paramf.equals("timeline_recent_show_select"))
      {
        paramf = new ffs();
        if (q.Qki != null) {
          paramf = q.Qki.aWV(this.ltf);
        }
        if (paramf != null) {
          break;
        }
        Log.e("MicroMsg.SettingsSnsPrivacyUI", "userinfo is null");
      }
    }
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acQp, Integer.valueOf(0))).intValue();
    if (i > ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acQq, Integer.valueOf(0))).intValue())
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acQq, Integer.valueOf(i));
      evt();
    }
    paramPreference = new e.a(getContext());
    paramPreference.aES(b.i.app_cancel);
    paramPreference.aEK(b.i.contact_info_feedsapp_recent_select);
    View localView = View.inflate(getContext(), b.g.mm_alert_switch, null);
    paramf = (LinearLayout)localView.findViewById(b.f.switcher_container);
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(298635);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsSnsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
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
        localObject = new ffs();
        if (q.Qki != null) {
          localObject = q.Qki.aWV(SettingsSnsPrivacyUI.b(SettingsSnsPrivacyUI.this));
        }
        if (localObject == null)
        {
          Log.e("MicroMsg.SettingsSnsPrivacyUI", "userinfo is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSnsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(298635);
          return;
        }
        i = ((Integer)paramAnonymousView.getTag()).intValue();
        Log.i("MicroMsg.SettingsSnsPrivacyUI", "settings_silence_update_mode choice: %d", new Object[] { Integer.valueOf(i) });
        if (i == 0)
        {
          if (SettingsSnsPrivacyUI.c(SettingsSnsPrivacyUI.this) == f.n.adwH) {
            com.tencent.mm.plugin.report.service.h.OAn.b(14090, new Object[] { Integer.valueOf(4) });
          }
          SettingsSnsPrivacyUI.a(SettingsSnsPrivacyUI.this, false);
          SettingsSnsPrivacyUI.b(SettingsSnsPrivacyUI.this, true);
          SettingsSnsPrivacyUI.c(SettingsSnsPrivacyUI.this, false);
          SettingsSnsPrivacyUI.d(SettingsSnsPrivacyUI.this);
        }
        for (;;)
        {
          if (q.Qki != null) {
            q.Qki.a(SettingsSnsPrivacyUI.b(SettingsSnsPrivacyUI.this), SettingsSnsPrivacyUI.e(SettingsSnsPrivacyUI.this), SettingsSnsPrivacyUI.f(SettingsSnsPrivacyUI.this), SettingsSnsPrivacyUI.g(SettingsSnsPrivacyUI.this), SettingsSnsPrivacyUI.h(SettingsSnsPrivacyUI.this));
          }
          if (q.Qki == null) {
            break label631;
          }
          localObject = q.Qki.b(SettingsSnsPrivacyUI.b(SettingsSnsPrivacyUI.this), SettingsSnsPrivacyUI.e(SettingsSnsPrivacyUI.this), SettingsSnsPrivacyUI.f(SettingsSnsPrivacyUI.this), SettingsSnsPrivacyUI.g(SettingsSnsPrivacyUI.this), SettingsSnsPrivacyUI.h(SettingsSnsPrivacyUI.this));
          if (localObject != null) {
            break;
          }
          Log.e("MicroMsg.SettingsSnsPrivacyUI", "userinfo in null !");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSnsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(298635);
          return;
          if (i == 1)
          {
            if (SettingsSnsPrivacyUI.c(SettingsSnsPrivacyUI.this) == f.n.adwH) {
              com.tencent.mm.plugin.report.service.h.OAn.b(14090, new Object[] { Integer.valueOf(5) });
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
            if (SettingsSnsPrivacyUI.c(SettingsSnsPrivacyUI.this) == f.n.adwH) {
              com.tencent.mm.plugin.report.service.h.OAn.b(14090, new Object[] { Integer.valueOf(6) });
            }
            SettingsSnsPrivacyUI.a(SettingsSnsPrivacyUI.this, false);
            SettingsSnsPrivacyUI.b(SettingsSnsPrivacyUI.this, false);
            SettingsSnsPrivacyUI.c(SettingsSnsPrivacyUI.this, false);
            SettingsSnsPrivacyUI.d(SettingsSnsPrivacyUI.this);
          }
        }
        Log.d("MicroMsg.SettingsSnsPrivacyUI", "dancy userinfo " + localObject.toString());
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzz().d(new k.a(51, (com.tencent.mm.bx.a)localObject));
        label631:
        paramAnonymousView.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(299337);
            ((Dialog)SettingsSnsPrivacyUI.2.this.Prc.getTag()).dismiss();
            SettingsSnsPrivacyUI.i(SettingsSnsPrivacyUI.this);
            AppMethodBeat.o(299337);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSnsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(298635);
      }
    };
    a(paramf, b.i.contact_info_feedsapp_recent_select_half_year, 1, this.Pvx, local2);
    a(paramf, b.i.contact_info_feedsapp_recent_select_one_month, 3, this.PvA, local2);
    a(paramf, b.i.contact_info_feedsapp_recent_select_three_day, 0, this.Pvy, local2);
    i = b.i.contact_info_feedsapp_recent_select_all;
    if ((!this.Pvx) && (!this.Pvy) && (!this.PvA)) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramf, i, 2, bool, local2);
      paramPreference.md(localView);
      paramPreference = paramPreference.jHH();
      paramf.setTag(paramPreference);
      paramPreference.show();
      addDialog(paramPreference);
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(298973);
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
            AppMethodBeat.i(298632);
            View localView = ((com.tencent.mm.ui.base.preference.a)SettingsSnsPrivacyUI.a(SettingsSnsPrivacyUI.this)).a(i, SettingsSnsPrivacyUI.this.getListView());
            if (localView != null) {
              com.tencent.mm.ui.j.a.d(SettingsSnsPrivacyUI.this.getContext(), localView);
            }
            AppMethodBeat.o(298632);
          }
        }, 10L);
      }
      this.lAt = true;
    }
    AppMethodBeat.o(298973);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSnsPrivacyUI
 * JD-Core Version:    0.7.0.1
 */