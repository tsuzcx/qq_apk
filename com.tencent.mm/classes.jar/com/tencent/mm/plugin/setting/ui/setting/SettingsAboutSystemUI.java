package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.newtips.a.e;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.setting.b.b;
import com.tencent.mm.plugin.setting.b.e;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.h;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.List;

public class SettingsAboutSystemUI
  extends MMPreference
{
  private ProgressDialog JfW = null;
  private boolean Jgf = false;
  private int Jgg = -1;
  private int Jgh = -1;
  private boolean Jgi = false;
  private boolean isDeleteCancel = false;
  private com.tencent.mm.ui.base.preference.f screen;
  
  private void a(LinearLayout paramLinearLayout, int paramInt1, int paramInt2, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(74064);
    TextView localTextView = (TextView)View.inflate(getContext(), b.g.radio_btn_item, null);
    localTextView.setText(paramInt1);
    localTextView.setTag(Integer.valueOf(paramInt2));
    paramLinearLayout.addView(localTextView);
    localTextView.setOnClickListener(paramOnClickListener);
    if (paramBoolean) {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(b.h.radio_on, 0, 0, 0);
    }
    AppMethodBeat.o(74064);
  }
  
  private void fFY()
  {
    AppMethodBeat.i(74059);
    NormalIconNewTipPreference localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.screen.byG("settings_plugins");
    com.tencent.mm.plugin.newtips.a.fiO().h(localNormalIconNewTipPreference);
    localNormalIconNewTipPreference.a(this.screen);
    g.a(localNormalIconNewTipPreference);
    boolean bool2 = Util.nullAs((Boolean)com.tencent.mm.kernel.h.aHG().aHp().b(-2046825377, null), false);
    boolean bool3 = com.tencent.mm.aa.c.aFn().dk(262158, 266266);
    com.tencent.mm.plugin.newtips.a.fiR();
    boolean bool4 = e.aal(com.tencent.mm.plugin.newtips.a.d.Gwf);
    if ((bool2) || (bool3) || (bool4)) {}
    for (boolean bool1 = true; g.a(bool1, localNormalIconNewTipPreference); bool1 = false)
    {
      AppMethodBeat.o(74059);
      return;
    }
    if (bool2)
    {
      localNormalIconNewTipPreference.abe(0);
      localNormalIconNewTipPreference.fC(getString(b.i.app_new), b.e.new_tips_bg);
      g.a(localNormalIconNewTipPreference, k.GwL, true);
      AppMethodBeat.o(74059);
      return;
    }
    localNormalIconNewTipPreference.abe(8);
    localNormalIconNewTipPreference.fC("", -1);
    if ((bool3) || (bool4))
    {
      localNormalIconNewTipPreference.aak(0);
      g.a(localNormalIconNewTipPreference, k.GwK, true);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74059);
      return;
      localNormalIconNewTipPreference.aak(8);
    }
  }
  
  private boolean fFZ()
  {
    AppMethodBeat.i(74060);
    Object localObject = new Intent(this, SettingsFontUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetTextSize", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetTextSize", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(74060);
    return true;
  }
  
  private void fGa()
  {
    int j = 1;
    AppMethodBeat.i(74063);
    if (Util.safeParseInt(com.tencent.mm.n.h.axc().getValue("SilentDownloadApkAtWiFi")) != 0) {}
    for (int i = 1;; i = 0)
    {
      if ((ChannelUtil.updateMode & 0x1) != 0)
      {
        Log.d("MicroMsg.SettingsAboutSystemUI", "channel pack, not silence download.");
        i = 1;
      }
      if (i == 0) {
        break;
      }
      this.screen.dz("settings_silence_update_mode", true);
      AppMethodBeat.o(74063);
      return;
    }
    this.screen.dz("settings_silence_update_mode", false);
    Preference localPreference;
    if ((((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      i = j;
      localPreference = this.screen.byG("settings_silence_update_mode");
      if (i == 0) {
        break label169;
      }
    }
    label169:
    for (i = b.i.settings_silence_update_mode_wifi;; i = b.i.settings_silence_update_mode_none)
    {
      localPreference.aF(getString(i));
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74063);
      return;
      i = 0;
      break;
    }
  }
  
  private void fGb()
  {
    AppMethodBeat.i(74065);
    int i = Util.getInt(com.tencent.mm.n.h.axc().getValue("SIGHTAutoLoadNetwork"), 1);
    int j = Util.nullAs((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(327686, null), i);
    Log.i("MicroMsg.SettingsAboutSystemUI", "auto getSightViewSummary %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (this.Jgg == -1) {
      this.Jgg = j;
    }
    this.Jgh = j;
    if (3 == j) {
      i = b.i.settings_sns_sight_auto_download_never;
    }
    for (;;)
    {
      Preference localPreference = this.screen.byG("settings_sns_sight_auto_download");
      if ((localPreference != null) && (i != 0)) {
        localPreference.aF(getString(i));
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74065);
      return;
      if (2 == j) {
        i = b.i.settings_sns_sight_auto_download_wifi;
      } else {
        i = b.i.settings_sns_sight_auto_download_always;
      }
    }
  }
  
  public static boolean fGc()
  {
    AppMethodBeat.i(264431);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vXn, false);
    AppMethodBeat.o(264431);
    return bool;
  }
  
  private void vH(boolean paramBoolean)
  {
    AppMethodBeat.i(74061);
    if (paramBoolean)
    {
      getPackageManager().setComponentEnabledSetting(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.ViP, Integer.valueOf(1));
      AppMethodBeat.o(74061);
      return;
    }
    getPackageManager().setComponentEnabledSetting(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.ViP, Integer.valueOf(2));
    AppMethodBeat.o(74061);
  }
  
  private void xP(boolean paramBoolean)
  {
    AppMethodBeat.i(74062);
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.byG("settings_nfc_switch");
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("settings_nfc_switch", paramBoolean).commit();
    localCheckBoxPreference.setChecked(paramBoolean);
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(74062);
  }
  
  public int getResourceId()
  {
    return b.k.settings_pref_system;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74055);
    setMMTitle(b.i.settings_about_system);
    this.screen = getPreferenceScreen();
    setBackBtn(new SettingsAboutSystemUI.1(this));
    com.tencent.mm.ui.base.preference.f localf = this.screen;
    boolean bool;
    if (!com.tencent.mm.compatible.util.d.qV(19))
    {
      bool = true;
      localf.dz("settings_swipeback_mode", bool);
      if (!com.tencent.mm.by.c.blP("backup")) {
        this.screen.dz("settings_bak_chat", true);
      }
      fFY();
      this.screen.dz("settings_traffic_statistic", com.tencent.mm.by.c.hok());
      if (!fGc()) {
        break label225;
      }
      if (this.screen.byG("settings_take_photo") != null) {
        this.screen.byG("settings_take_photo").setTitle(b.i.settings_photo_video_new);
      }
    }
    for (;;)
    {
      if (ac.mGL) {
        this.screen.dz("settings_take_photo", true);
      }
      if ((com.tencent.mm.cj.c.hrB()) || ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!ar.aEg())))
      {
        this.screen.dz("settings_dark", true);
        this.screen.dz("small_divider", true);
      }
      AppMethodBeat.o(74055);
      return;
      bool = false;
      break;
      label225:
      if (this.screen.byG("settings_take_photo") != null) {
        this.screen.byG("settings_take_photo").setTitle(b.i.settings_photo_video);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74054);
    super.onCreate(paramBundle);
    this.Jgf = false;
    initView();
    AppMethodBeat.o(74054);
  }
  
  public void onDestroy()
  {
    boolean bool2 = true;
    AppMethodBeat.i(74057);
    super.onDestroy();
    int i;
    com.tencent.mm.plugin.report.service.h localh;
    if (this.Jgi)
    {
      i = this.Jgh;
      if (this.Jgg != this.Jgh) {
        break label127;
      }
      bool1 = true;
      Log.i("MicroMsg.SettingsAboutSystemUI", "kvstat, autodownload sight change: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
      localh = com.tencent.mm.plugin.report.service.h.IzE;
      i = this.Jgh;
      if (this.Jgg != this.Jgh) {
        break label132;
      }
    }
    label132:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localh.a(11437, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Boolean.valueOf(bool1) });
      AppMethodBeat.o(74057);
      return;
      label127:
      bool1 = false;
      break;
    }
  }
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    boolean bool2 = false;
    AppMethodBeat.i(74058);
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_landscape_mode"))
    {
      Log.i("MicroMsg.SettingsAboutSystemUI", "set ScreenOrientation，now is ： %s", new Object[] { Boolean.valueOf(getDefaultSharedPreferences().getBoolean("settings_landscape_mode", false)) });
      if (getDefaultSharedPreferences().getBoolean("settings_landscape_mode", false)) {
        setRequestedOrientation(-1);
      }
      for (;;)
      {
        AppMethodBeat.o(74058);
        return true;
        setRequestedOrientation(1);
      }
    }
    boolean bool1;
    if (paramf.equals("settings_voicerecorder_mode"))
    {
      if (af.juI.jnS == 1) {}
      for (bool1 = false;; bool1 = true)
      {
        if (!getDefaultSharedPreferences().getBoolean("settings_voicerecorder_mode", bool1)) {
          com.tencent.mm.ui.base.h.a(getContext(), b.i.settings_voicerecorder_mode_change_to_amr, b.i.app_tip, new SettingsAboutSystemUI.8(this), new SettingsAboutSystemUI.9(this));
        }
        AppMethodBeat.o(74058);
        return true;
      }
    }
    final int i;
    int j;
    if (paramf.equals("settings_nfc_switch"))
    {
      paramf = NfcAdapter.getDefaultAdapter(this);
      if (paramf == null) {
        Log.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch phone not suppot nfc");
      }
      for (;;)
      {
        AppMethodBeat.o(74058);
        return true;
        i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.ViP, Integer.valueOf(0))).intValue();
        j = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.ViQ, Integer.valueOf(0))).intValue();
        if (((i == 2) || ((i == 0) && (j != 1))) && (!paramf.isEnabled()) && (getDefaultSharedPreferences().getBoolean("settings_nfc_switch", false)))
        {
          xP(false);
          com.tencent.mm.ui.base.h.c(getContext(), getString(b.i.nfc_off_tips), "", getString(b.i.nfc_open_title), getString(b.i.app_cancel), new SettingsAboutSystemUI.6(this), new SettingsAboutSystemUI.7(this));
        }
        else
        {
          vH(getDefaultSharedPreferences().getBoolean("settings_nfc_switch", false));
        }
      }
    }
    if (paramf.equals("settings_voice_play_mode"))
    {
      boolean bool3 = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().b(26, Boolean.FALSE)).booleanValue();
      if (!bool3) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.d("MicroMsg.SettingsAboutSystemUI", "set voice mode from %B to %B", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        paramf = com.tencent.mm.kernel.h.aHG().aHp();
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
        paramf.i(26, Boolean.valueOf(bool1));
        AppMethodBeat.o(74058);
        return true;
      }
    }
    if (paramf.equals("settings_enter_button_send"))
    {
      paramf = (CheckBoxPreference)this.screen.byG("settings_enter_button_send");
      if (paramf != null)
      {
        bool1 = paramf.isChecked();
        Log.d("MicroMsg.SettingsAboutSystemUI", "set enter button send : %s", new Object[] { Boolean.valueOf(bool1) });
        com.tencent.mm.kernel.h.aHG().aHp().i(66832, Boolean.valueOf(bool1));
      }
      AppMethodBeat.o(74058);
      return true;
    }
    View localView;
    Object localObject;
    if (paramf.equals("settings_sns_sight_auto_download"))
    {
      paramPreference = new d.a(getContext());
      paramPreference.ayk(b.i.app_cancel);
      paramPreference.ayc(b.i.settings_sns_sight_auto_download_tips);
      localView = View.inflate(getContext(), b.g.mm_alert_switch, null);
      paramf = (LinearLayout)localView.findViewById(b.f.switcher_container);
      i = Util.getInt(com.tencent.mm.n.h.axc().getValue("SIGHTAutoLoadNetwork"), 1);
      i = Util.nullAs((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(327686, null), i);
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74041);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          final int i = 0;
          while (i < paramf.getChildCount())
          {
            localObject = (TextView)paramf.getChildAt(i);
            if (b.f.tips_tv != ((TextView)localObject).getId()) {
              ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(b.h.radio_off, 0, 0, 0);
            }
            i += 1;
          }
          ((TextView)paramAnonymousView).setCompoundDrawablesWithIntrinsicBounds(b.h.radio_on, 0, 0, 0);
          i = ((Integer)paramAnonymousView.getTag()).intValue();
          Log.i("MicroMsg.SettingsAboutSystemUI", "choice: %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
          if (i == i)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74041);
            return;
          }
          paramAnonymousView.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(74040);
              ((Dialog)SettingsAboutSystemUI.2.this.Jgk.getTag()).dismiss();
              com.tencent.mm.kernel.h.aHG().aHp().i(327686, Integer.valueOf(i));
              com.tencent.mm.kernel.h.aHG().aHp().hxT();
              SettingsAboutSystemUI.f(SettingsAboutSystemUI.this);
              AppMethodBeat.o(74040);
            }
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74041);
        }
      };
      j = b.i.settings_sns_sight_auto_download_always;
      if (1 == i)
      {
        bool1 = true;
        a(paramf, j, 1, bool1, (View.OnClickListener)localObject);
        j = b.i.settings_sns_sight_auto_download_wifi;
        if (2 != i) {
          break label798;
        }
        bool1 = true;
        label716:
        a(paramf, j, 2, bool1, (View.OnClickListener)localObject);
        j = b.i.settings_sns_sight_auto_download_never;
        if (3 != i) {
          break label804;
        }
      }
      label798:
      label804:
      for (bool1 = true;; bool1 = false)
      {
        a(paramf, j, 3, bool1, (View.OnClickListener)localObject);
        paramPreference.iI(localView);
        paramPreference = paramPreference.icu();
        paramf.setTag(paramPreference);
        paramPreference.show();
        addDialog(paramPreference);
        this.Jgi = true;
        AppMethodBeat.o(74058);
        return true;
        bool1 = false;
        break;
        bool1 = false;
        break label716;
      }
    }
    if (paramf.equals("settings_silence_update_mode"))
    {
      paramPreference = new d.a(getContext());
      paramPreference.ayk(b.i.app_cancel);
      paramPreference.ayc(b.i.settings_silence_update_mode);
      localView = View.inflate(getContext(), b.g.mm_alert_switch, null);
      paramf = (LinearLayout)localView.findViewById(b.f.switcher_container);
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          int k = 0;
          AppMethodBeat.i(74053);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
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
          int m = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(7, Integer.valueOf(0))).intValue();
          int n = ((Integer)paramAnonymousView.getTag()).intValue();
          Log.d("MicroMsg.SettingsAboutSystemUI", "settings_silence_update_mode choice: %d", new Object[] { Integer.valueOf(n) });
          if (n == 0)
          {
            i = 1;
            if ((m & 0x1000000) != 0) {
              break label207;
            }
          }
          label207:
          for (int j = 1;; j = 0)
          {
            if (i != j) {
              break label212;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74053);
            return;
            i = 0;
            break;
          }
          label212:
          i = k;
          if (n == 0) {
            i = 1;
          }
          if (i != 0)
          {
            j = 0xFEFFFFFF & m;
            if (i != 0) {
              break label352;
            }
          }
          label352:
          for (i = 1;; i = 2)
          {
            com.tencent.mm.kernel.h.aHG().aHp().i(7, Integer.valueOf(j));
            localObject = new bmy();
            ((bmy)localObject).SXP = 35;
            ((bmy)localObject).HmX = i;
            ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(23, (com.tencent.mm.cd.a)localObject));
            com.tencent.mm.plugin.setting.c.mIH.abC();
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(74052);
                ((Dialog)SettingsAboutSystemUI.10.this.Jgk.getTag()).dismiss();
                SettingsAboutSystemUI.e(SettingsAboutSystemUI.this);
                AppMethodBeat.o(74052);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74053);
            return;
            j = m | 0x1000000;
            break;
          }
        }
      };
      if ((((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
      {
        bool1 = true;
        a(paramf, b.i.settings_silence_update_mode_wifi, 0, bool1, (View.OnClickListener)localObject);
        i = b.i.settings_silence_update_mode_none;
        if (bool1) {
          break label991;
        }
      }
      label991:
      for (bool1 = true;; bool1 = false)
      {
        a(paramf, i, 1, bool1, (View.OnClickListener)localObject);
        paramPreference.iI(localView);
        paramPreference = paramPreference.icu();
        paramf.setTag(paramPreference);
        paramPreference.show();
        addDialog(paramPreference);
        AppMethodBeat.o(74058);
        return true;
        bool1 = false;
        break;
      }
    }
    if (paramf.equals("settings_language"))
    {
      paramf = new Intent(getContext(), SettingsLanguageUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetLanguage", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetLanguage", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_text_size"))
    {
      bool1 = fFZ();
      AppMethodBeat.o(74058);
      return bool1;
    }
    if (paramf.equals("settings_chatting_bg"))
    {
      paramPreference = new Intent();
      paramPreference.setClass(this, SettingsChattingBackgroundUI.class);
      paramf = getContext();
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bm(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.b(paramf, paramPreference.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetChattingBackground", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetChattingBackground", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_manage_findmoreui"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsManageFindMoreUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goToManageFindMoreUI", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goToManageFindMoreUI", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_plugins"))
    {
      com.tencent.mm.plugin.newtips.a.fiO().aap(32);
      com.tencent.mm.kernel.h.aHG().aHp().i(-2046825377, Boolean.FALSE);
      paramf = new Intent();
      paramf.setClass(this, SettingsPluginsUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetPlugins", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetPlugins", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.aa.c.aFn().dl(262158, 266266);
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_reset"))
    {
      com.tencent.mm.ui.base.h.c(getContext(), getResources().getString(b.i.settings_reset_warning), "", getString(b.i.app_clear), getString(b.i.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousInt = 0;
          AppMethodBeat.i(74048);
          SettingsAboutSystemUI.a(SettingsAboutSystemUI.this, false);
          paramAnonymousDialogInterface = SettingsAboutSystemUI.this;
          Object localObject = SettingsAboutSystemUI.this;
          SettingsAboutSystemUI.this.getString(b.i.app_tip);
          SettingsAboutSystemUI.a(paramAnonymousDialogInterface, com.tencent.mm.ui.base.h.a((Context)localObject, SettingsAboutSystemUI.this.getString(b.i.app_waiting), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(74045);
              SettingsAboutSystemUI.a(SettingsAboutSystemUI.this, true);
              AppMethodBeat.o(74045);
            }
          }));
          paramAnonymousDialogInterface = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().hyJ();
          if (paramAnonymousDialogInterface.size() > 0)
          {
            localObject = u.ak(paramAnonymousDialogInterface);
            if (localObject != null) {
              while (paramAnonymousInt < ((List)localObject).size())
              {
                if (((Boolean)((List)localObject).get(paramAnonymousInt)).booleanValue()) {
                  com.tencent.mm.plugin.setting.c.mIH.hb((String)paramAnonymousDialogInterface.get(paramAnonymousInt));
                }
                paramAnonymousInt += 1;
              }
            }
          }
          bq.a(new bq.a()
          {
            public final boolean asH()
            {
              AppMethodBeat.i(74046);
              boolean bool = SettingsAboutSystemUI.b(SettingsAboutSystemUI.this);
              AppMethodBeat.o(74046);
              return bool;
            }
            
            public final void asI()
            {
              AppMethodBeat.i(74047);
              if (SettingsAboutSystemUI.c(SettingsAboutSystemUI.this) != null)
              {
                SettingsAboutSystemUI.c(SettingsAboutSystemUI.this).dismiss();
                SettingsAboutSystemUI.a(SettingsAboutSystemUI.this, null);
              }
              AppMethodBeat.o(74047);
            }
          });
          AppMethodBeat.o(74048);
        }
      }, null);
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_emoji_manager"))
    {
      paramf = new Intent();
      paramf.putExtra("10931", 2);
      com.tencent.mm.by.c.b(getContext(), "emoji", ".ui.EmojiMineUI", paramf);
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settngs_clean"))
    {
      if (!com.tencent.mm.kernel.h.aHG().isSDCardAvailable())
      {
        w.g(getContext(), null);
        AppMethodBeat.o(74058);
        return true;
      }
      com.tencent.mm.by.c.b(getContext(), "clean", ".ui.CleanUI", new Intent());
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_traffic_statistic"))
    {
      paramf = new Intent(this, SettingsNetStatUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goToSetTrafficStatistic", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goToSetTrafficStatistic", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_text_size"))
    {
      bool1 = fFZ();
      AppMethodBeat.o(74058);
      return bool1;
    }
    if (paramf.equals("settings_swipeback_mode"))
    {
      paramf = (CheckBoxPreference)paramPreference;
      bool1 = com.tencent.mm.compatible.h.b.avx();
      if (!bool1) {}
      for (i = b.i.settings_swipeback_mode_open_tips;; i = b.i.settings_swipeback_mode_close_tips)
      {
        com.tencent.mm.ui.base.h.a(getContext(), getString(i), null, new SettingsAboutSystemUI.3(this), new SettingsAboutSystemUI.4(this, paramf, bool1));
        AppMethodBeat.o(74058);
        return true;
      }
    }
    if (paramf.equals("settings_take_photo"))
    {
      paramf = new Intent(this, SettingsAboutCamera.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(74058);
      return false;
      if (paramf.equalsIgnoreCase("settngs_matrix_trace"))
      {
        if (!com.tencent.matrix.b.Vt())
        {
          Toast.makeText(this, "Matrix is never installed", 0).show();
          AppMethodBeat.o(74058);
          return false;
        }
        paramf = new Intent();
        paramf.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.matrix.MatrixSettingUI");
        paramf.addFlags(67108864);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (paramf.equals("settings_dark"))
      {
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_red_dot", false);
        paramf = new Intent(this, SettingDarkMode.class);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetDarkMode", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetDarkMode", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74056);
    super.onResume();
    Object localObject1 = (CheckBoxPreference)this.screen.byG("settings_voice_play_mode");
    if (localObject1 != null)
    {
      ((CheckBoxPreference)localObject1).setChecked(((Boolean)com.tencent.mm.kernel.h.aHG().aHp().b(26, Boolean.FALSE)).booleanValue());
      ((Preference)localObject1).WsF = false;
    }
    localObject1 = (CheckBoxPreference)this.screen.byG("settings_enter_button_send");
    if (localObject1 != null)
    {
      ((CheckBoxPreference)localObject1).setChecked(((Boolean)com.tencent.mm.kernel.h.aHG().aHp().b(66832, Boolean.FALSE)).booleanValue());
      ((Preference)localObject1).WsF = false;
    }
    localObject1 = (CheckBoxPreference)this.screen.byG("settings_swipeback_mode");
    if (localObject1 != null)
    {
      ((CheckBoxPreference)localObject1).setChecked(com.tencent.mm.compatible.h.b.avx());
      ((Preference)localObject1).WsF = false;
    }
    localObject1 = this.screen.byG("settings_language");
    if (localObject1 != null) {
      ((Preference)localObject1).aF(LocaleUtil.getLanguageName(getContext(), b.b.language_setting, b.i.app_lang_sys));
    }
    fFY();
    fGb();
    fGb();
    fGa();
    localObject1 = NfcAdapter.getDefaultAdapter(this);
    Object localObject2 = (CheckBoxPreference)this.screen.byG("settings_nfc_switch");
    if (localObject1 == null)
    {
      this.screen.dz("settings_nfc_switch", true);
      localObject2 = (IconPreference)this.screen.byG("settings_dark");
      if (ar.aEf())
      {
        if (!ar.aEk()) {
          break label474;
        }
        localObject1 = getString(b.i.app_lang_sys);
      }
    }
    for (;;)
    {
      ((IconPreference)localObject2).aF((CharSequence)localObject1);
      com.tencent.mm.cj.c.hrC();
      ((IconPreference)localObject2).aak(8);
      this.screen.dz("settngs_matrix_trace", true);
      AppMethodBeat.o(74056);
      return;
      this.screen.dz("settings_nfc_switch", false);
      ((CheckBoxPreference)localObject2).aF(Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.ViT, null)));
      if (this.Jgf)
      {
        Log.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-updateNfcOpenSwitch go setSystemNfc and back");
        if (((NfcAdapter)localObject1).isEnabled())
        {
          vH(true);
          xP(true);
          break;
        }
      }
      int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.ViP, Integer.valueOf(0))).intValue();
      if (i == 0) {
        if (((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.ViQ, Integer.valueOf(0))).intValue() == 1) {
          xP(true);
        }
      }
      for (;;)
      {
        this.screen.notifyDataSetChanged();
        break;
        xP(false);
        continue;
        if (i == 1) {
          xP(true);
        } else {
          xP(false);
        }
      }
      label474:
      if (ar.isDarkMode()) {
        localObject1 = getString(b.i.setting_open);
      } else {
        localObject1 = getString(b.i.setting_close);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI
 * JD-Core Version:    0.7.0.1
 */