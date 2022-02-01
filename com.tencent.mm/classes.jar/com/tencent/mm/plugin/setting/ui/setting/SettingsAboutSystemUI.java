package com.tencent.mm.plugin.setting.ui.setting;

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
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.a;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.setting.b.b;
import com.tencent.mm.plugin.setting.b.e;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.h;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.bh;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.List;

public class SettingsAboutSystemUI
  extends MMPreference
{
  private ProgressDialog PqL = null;
  private boolean PqX = false;
  private int PqY = -1;
  private int PqZ = -1;
  private boolean Pra = false;
  private boolean isDeleteCancel = false;
  private com.tencent.mm.ui.base.preference.f screen;
  
  private void Ad(boolean paramBoolean)
  {
    AppMethodBeat.i(74061);
    if (paramBoolean)
    {
      getPackageManager().setComponentEnabledSetting(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acKj, Integer.valueOf(1));
      AppMethodBeat.o(74061);
      return;
    }
    getPackageManager().setComponentEnabledSetting(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acKj, Integer.valueOf(2));
    AppMethodBeat.o(74061);
  }
  
  private void CH(boolean paramBoolean)
  {
    AppMethodBeat.i(74062);
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.bAi("settings_nfc_switch");
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("settings_nfc_switch", paramBoolean).commit();
    localCheckBoxPreference.setChecked(paramBoolean);
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(74062);
  }
  
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
  
  private void eAL()
  {
    AppMethodBeat.i(299284);
    if (ignoreSecondCalled())
    {
      AppMethodBeat.o(299284);
      return;
    }
    Object localObject = (CheckBoxPreference)this.screen.bAi("settings_voice_play_mode");
    if (localObject != null)
    {
      ((CheckBoxPreference)localObject).setChecked(((Boolean)com.tencent.mm.kernel.h.baE().ban().d(26, Boolean.FALSE)).booleanValue());
      ((Preference)localObject).adZV = false;
    }
    localObject = (CheckBoxPreference)this.screen.bAi("settings_enter_button_send");
    if (localObject != null)
    {
      ((CheckBoxPreference)localObject).setChecked(((Boolean)com.tencent.mm.kernel.h.baE().ban().d(66832, Boolean.FALSE)).booleanValue());
      ((Preference)localObject).adZV = false;
    }
    localObject = (CheckBoxPreference)this.screen.bAi("settings_swipeback_mode");
    if (localObject != null)
    {
      ((CheckBoxPreference)localObject).setChecked(com.tencent.mm.compatible.h.a.aPR());
      ((Preference)localObject).adZV = false;
    }
    localObject = this.screen.bAi("settings_language");
    if (localObject != null) {
      ((Preference)localObject).aS(LocaleUtil.getLanguageName(getContext(), b.b.language_setting, b.i.app_lang_sys));
    }
    gVs();
    gVv();
    gVv();
    gVu();
    gVq();
    gVp();
    this.screen.eh("settngs_matrix_trace", true);
    AppMethodBeat.o(299284);
  }
  
  private void gVp()
  {
    AppMethodBeat.i(299291);
    IconPreference localIconPreference = (IconPreference)this.screen.bAi("settings_dark");
    String str;
    if (aw.aXj())
    {
      if (aw.aXo())
      {
        str = getString(b.i.app_lang_sys);
        localIconPreference.aS(str);
      }
    }
    else {
      if (!com.tencent.mm.ce.e.iRQ()) {
        break label95;
      }
    }
    label95:
    for (int i = 0;; i = 8)
    {
      localIconPreference.aeD(i);
      AppMethodBeat.o(299291);
      return;
      if (aw.isDarkMode())
      {
        str = getString(b.i.setting_open);
        break;
      }
      str = getString(b.i.setting_close);
      break;
    }
  }
  
  private void gVq()
  {
    AppMethodBeat.i(299300);
    NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(this);
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.bAi("settings_nfc_switch");
    if (localNfcAdapter == null)
    {
      this.screen.eh("settings_nfc_switch", true);
      AppMethodBeat.o(299300);
      return;
    }
    this.screen.eh("settings_nfc_switch", false);
    localCheckBoxPreference.aS(Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acKn, null)));
    if (this.PqX)
    {
      Log.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-updateNfcOpenSwitch go setSystemNfc and back");
      if (localNfcAdapter.isEnabled())
      {
        Ad(true);
        CH(true);
        AppMethodBeat.o(299300);
        return;
      }
    }
    gVr();
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(299300);
  }
  
  private void gVr()
  {
    AppMethodBeat.i(299306);
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acKj, Integer.valueOf(0))).intValue();
    if (i == 0)
    {
      if (((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acKk, Integer.valueOf(0))).intValue() == 1)
      {
        CH(true);
        AppMethodBeat.o(299306);
        return;
      }
      CH(false);
      AppMethodBeat.o(299306);
      return;
    }
    if (i == 1)
    {
      CH(true);
      AppMethodBeat.o(299306);
      return;
    }
    CH(false);
    AppMethodBeat.o(299306);
  }
  
  private void gVs()
  {
    AppMethodBeat.i(74059);
    NormalIconNewTipPreference localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.screen.bAi("settings_plugins");
    com.tencent.mm.plugin.newtips.a.gtf().h(localNormalIconNewTipPreference);
    localNormalIconNewTipPreference.a(this.screen);
    g.a(localNormalIconNewTipPreference);
    boolean bool2 = Util.nullAs((Boolean)com.tencent.mm.kernel.h.baE().ban().d(-2046825377, null), false);
    boolean bool3 = com.tencent.mm.aa.c.aYo().dW(262158, 266266);
    com.tencent.mm.plugin.newtips.a.gti();
    boolean bool4 = com.tencent.mm.plugin.newtips.a.e.aeE(com.tencent.mm.plugin.newtips.a.d.Mse);
    if ((bool2) || (bool3) || (bool4)) {}
    for (boolean bool1 = true; g.a(bool1, localNormalIconNewTipPreference); bool1 = false)
    {
      AppMethodBeat.o(74059);
      return;
    }
    if (bool2)
    {
      localNormalIconNewTipPreference.afx(0);
      localNormalIconNewTipPreference.gv(getString(b.i.app_new), b.e.new_tips_bg);
      g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MsL, true);
      AppMethodBeat.o(74059);
      return;
    }
    localNormalIconNewTipPreference.afx(8);
    localNormalIconNewTipPreference.gv("", -1);
    if ((bool3) || (bool4))
    {
      localNormalIconNewTipPreference.aeD(0);
      g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MsK, true);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74059);
      return;
      localNormalIconNewTipPreference.aeD(8);
    }
  }
  
  private boolean gVt()
  {
    AppMethodBeat.i(74060);
    Object localObject = new Intent(this, SettingsFontUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetTextSize", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetTextSize", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(74060);
    return true;
  }
  
  private void gVu()
  {
    int j = 1;
    AppMethodBeat.i(74063);
    if (Util.safeParseInt(com.tencent.mm.k.i.aRC().getValue("SilentDownloadApkAtWiFi")) != 0) {}
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
      this.screen.eh("settings_silence_update_mode", true);
      AppMethodBeat.o(74063);
      return;
    }
    this.screen.eh("settings_silence_update_mode", false);
    Preference localPreference;
    if ((((Integer)com.tencent.mm.kernel.h.baE().ban().d(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      i = j;
      localPreference = this.screen.bAi("settings_silence_update_mode");
      if (i == 0) {
        break label169;
      }
    }
    label169:
    for (i = b.i.settings_silence_update_mode_wifi;; i = b.i.settings_silence_update_mode_none)
    {
      localPreference.aS(getString(i));
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74063);
      return;
      i = 0;
      break;
    }
  }
  
  private void gVv()
  {
    AppMethodBeat.i(74065);
    int i = Util.getInt(com.tencent.mm.k.i.aRC().getValue("SIGHTAutoLoadNetwork"), 1);
    int j = Util.nullAs((Integer)com.tencent.mm.kernel.h.baE().ban().d(327686, null), i);
    Log.i("MicroMsg.SettingsAboutSystemUI", "auto getSightViewSummary %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (this.PqY == -1) {
      this.PqY = j;
    }
    this.PqZ = j;
    if (3 == j) {
      i = b.i.settings_sns_sight_auto_download_never;
    }
    for (;;)
    {
      Preference localPreference = this.screen.bAi("settings_sns_sight_auto_download");
      if ((localPreference != null) && (i != 0)) {
        localPreference.aS(getString(i));
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
  
  public static boolean gVw()
  {
    AppMethodBeat.i(299334);
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpT, false);
    AppMethodBeat.o(299334);
    return bool;
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
    if (!com.tencent.mm.compatible.util.d.rb(19))
    {
      bool = true;
      localf.eh("settings_swipeback_mode", bool);
      if (!com.tencent.mm.br.c.blq("backup")) {
        this.screen.eh("settings_bak_chat", true);
      }
      gVs();
      this.screen.eh("settings_traffic_statistic", com.tencent.mm.br.c.iPe());
      if (!gVw()) {
        break label224;
      }
      if (this.screen.bAi("settings_take_photo") != null) {
        this.screen.bAi("settings_take_photo").setTitle(b.i.settings_photo_video_new);
      }
    }
    for (;;)
    {
      if (z.pDl) {
        this.screen.eh("settings_take_photo", true);
      }
      if ((com.tencent.mm.ce.e.iRP()) || ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!aw.aXk())))
      {
        this.screen.eh("settings_dark", true);
        this.screen.eh("small_divider", true);
      }
      AppMethodBeat.o(74055);
      return;
      bool = false;
      break;
      label224:
      if (this.screen.bAi("settings_take_photo") != null) {
        this.screen.bAi("settings_take_photo").setTitle(b.i.settings_photo_video);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74054);
    super.onCreate(paramBundle);
    this.PqX = false;
    initView();
    eAL();
    AppMethodBeat.o(74054);
  }
  
  public void onDestroy()
  {
    boolean bool2 = true;
    AppMethodBeat.i(74057);
    super.onDestroy();
    int i;
    com.tencent.mm.plugin.report.service.h localh;
    if (this.Pra)
    {
      i = this.PqZ;
      if (this.PqY != this.PqZ) {
        break label127;
      }
      bool1 = true;
      Log.i("MicroMsg.SettingsAboutSystemUI", "kvstat, autodownload sight change: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
      localh = com.tencent.mm.plugin.report.service.h.OAn;
      i = this.PqZ;
      if (this.PqY != this.PqZ) {
        break label132;
      }
    }
    label132:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localh.b(11437, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Boolean.valueOf(bool1) });
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
      if (getDefaultSharedPreferences().getBoolean("settings_landscape_mode", false))
      {
        if (aw.jkT())
        {
          bh.mN(getContext());
          bh.aDU(1);
        }
        setRequestedOrientation(-1);
      }
      for (;;)
      {
        AppMethodBeat.o(74058);
        return true;
        if (aw.jkT())
        {
          bh.mN(getContext());
          bh.aDU(0);
        }
        setRequestedOrientation(1);
      }
    }
    final boolean bool1;
    if (paramf.equals("settings_voicerecorder_mode"))
    {
      if (af.lXZ.lRa == 1) {}
      for (bool1 = false;; bool1 = true)
      {
        if (!getDefaultSharedPreferences().getBoolean("settings_voicerecorder_mode", bool1)) {
          com.tencent.mm.ui.base.k.a(getContext(), b.i.settings_voicerecorder_mode_change_to_amr, b.i.app_tip, new SettingsAboutSystemUI.8(this), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(74051);
              SettingsAboutSystemUI.this.getDefaultSharedPreferences().edit().putBoolean("settings_voicerecorder_mode", true).commit();
              ((CheckBoxPreference)SettingsAboutSystemUI.a(SettingsAboutSystemUI.this).bAi("settings_voicerecorder_mode")).setChecked(true);
              SettingsAboutSystemUI.a(SettingsAboutSystemUI.this).notifyDataSetChanged();
              AppMethodBeat.o(74051);
            }
          });
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
        i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acKj, Integer.valueOf(0))).intValue();
        j = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acKk, Integer.valueOf(0))).intValue();
        if (((i == 2) || ((i == 0) && (j != 1))) && (!paramf.isEnabled()) && (getDefaultSharedPreferences().getBoolean("settings_nfc_switch", false)))
        {
          CH(false);
          com.tencent.mm.ui.base.k.b(getContext(), getString(b.i.nfc_off_tips), "", getString(b.i.nfc_open_title), getString(b.i.app_cancel), new SettingsAboutSystemUI.6(this), new SettingsAboutSystemUI.7(this));
        }
        else
        {
          Ad(getDefaultSharedPreferences().getBoolean("settings_nfc_switch", false));
        }
      }
    }
    if (paramf.equals("settings_voice_play_mode"))
    {
      boolean bool3 = ((Boolean)com.tencent.mm.kernel.h.baE().ban().d(26, Boolean.FALSE)).booleanValue();
      if (!bool3) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.d("MicroMsg.SettingsAboutSystemUI", "set voice mode from %B to %B", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        paramf = com.tencent.mm.kernel.h.baE().ban();
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
        paramf.B(26, Boolean.valueOf(bool1));
        AppMethodBeat.o(74058);
        return true;
      }
    }
    if (paramf.equals("settings_enter_button_send"))
    {
      paramf = (CheckBoxPreference)this.screen.bAi("settings_enter_button_send");
      if (paramf != null)
      {
        bool1 = paramf.isChecked();
        Log.d("MicroMsg.SettingsAboutSystemUI", "set enter button send : %s", new Object[] { Boolean.valueOf(bool1) });
        com.tencent.mm.kernel.h.baE().ban().B(66832, Boolean.valueOf(bool1));
      }
      AppMethodBeat.o(74058);
      return true;
    }
    View localView;
    Object localObject;
    if (paramf.equals("settings_sns_sight_auto_download"))
    {
      paramPreference = new e.a(getContext());
      paramPreference.aES(b.i.app_cancel);
      paramPreference.aEK(b.i.settings_sns_sight_auto_download_tips);
      localView = View.inflate(getContext(), b.g.mm_alert_switch, null);
      paramf = (LinearLayout)localView.findViewById(b.f.switcher_container);
      i = Util.getInt(com.tencent.mm.k.i.aRC().getValue("SIGHTAutoLoadNetwork"), 1);
      i = Util.nullAs((Integer)com.tencent.mm.kernel.h.baE().ban().d(327686, null), i);
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74041);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
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
              ((Dialog)SettingsAboutSystemUI.2.this.Prc.getTag()).dismiss();
              com.tencent.mm.kernel.h.baE().ban().B(327686, Integer.valueOf(i));
              com.tencent.mm.kernel.h.baE().ban().iZy();
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
          break label826;
        }
        bool1 = true;
        label744:
        a(paramf, j, 2, bool1, (View.OnClickListener)localObject);
        j = b.i.settings_sns_sight_auto_download_never;
        if (3 != i) {
          break label832;
        }
      }
      label826:
      label832:
      for (bool1 = true;; bool1 = false)
      {
        a(paramf, j, 3, bool1, (View.OnClickListener)localObject);
        paramPreference.md(localView);
        paramPreference = paramPreference.jHH();
        paramf.setTag(paramPreference);
        paramPreference.show();
        addDialog(paramPreference);
        this.Pra = true;
        AppMethodBeat.o(74058);
        return true;
        bool1 = false;
        break;
        bool1 = false;
        break label744;
      }
    }
    if (paramf.equals("settings_silence_update_mode"))
    {
      paramPreference = new e.a(getContext());
      paramPreference.aES(b.i.app_cancel);
      paramPreference.aEK(b.i.settings_silence_update_mode);
      localView = View.inflate(getContext(), b.g.mm_alert_switch, null);
      paramf = (LinearLayout)localView.findViewById(b.f.switcher_container);
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          int k = 0;
          AppMethodBeat.i(74053);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
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
          int m = ((Integer)com.tencent.mm.kernel.h.baE().ban().d(7, Integer.valueOf(0))).intValue();
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
            com.tencent.mm.kernel.h.baE().ban().B(7, Integer.valueOf(j));
            localObject = new cas();
            ((cas)localObject).aajJ = 35;
            ((cas)localObject).NkL = i;
            ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(23, (com.tencent.mm.bx.a)localObject));
            com.tencent.mm.plugin.setting.c.pFo.aDx();
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(74052);
                ((Dialog)SettingsAboutSystemUI.10.this.Prc.getTag()).dismiss();
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
      if ((((Integer)com.tencent.mm.kernel.h.baE().ban().d(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
      {
        bool1 = true;
        a(paramf, b.i.settings_silence_update_mode_wifi, 0, bool1, (View.OnClickListener)localObject);
        i = b.i.settings_silence_update_mode_none;
        if (bool1) {
          break label1019;
        }
      }
      label1019:
      for (bool1 = true;; bool1 = false)
      {
        a(paramf, i, 1, bool1, (View.OnClickListener)localObject);
        paramPreference.md(localView);
        paramPreference = paramPreference.jHH();
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
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetLanguage", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetLanguage", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_text_size"))
    {
      bool1 = gVt();
      AppMethodBeat.o(74058);
      return bool1;
    }
    if (paramf.equals("settings_chatting_bg"))
    {
      paramPreference = new Intent();
      paramPreference.setClass(this, SettingsChattingBackgroundUI.class);
      paramf = getContext();
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().cG(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.b(paramf, paramPreference.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetChattingBackground", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetChattingBackground", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_manage_findmoreui"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsManageFindMoreUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goToManageFindMoreUI", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goToManageFindMoreUI", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_plugins"))
    {
      com.tencent.mm.plugin.newtips.a.gtf().aeI(32);
      com.tencent.mm.kernel.h.baE().ban().B(-2046825377, Boolean.FALSE);
      paramf = new Intent();
      paramf.setClass(this, SettingsPluginsUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetPlugins", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetPlugins", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.aa.c.aYo().dX(262158, 266266);
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_reset"))
    {
      com.tencent.mm.ui.base.k.b(getContext(), getResources().getString(b.i.settings_reset_warning), "", getString(b.i.app_clear), getString(b.i.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousInt = 0;
          AppMethodBeat.i(74048);
          SettingsAboutSystemUI.a(SettingsAboutSystemUI.this, false);
          paramAnonymousDialogInterface = SettingsAboutSystemUI.this;
          Object localObject = SettingsAboutSystemUI.this;
          SettingsAboutSystemUI.this.getString(b.i.app_tip);
          SettingsAboutSystemUI.a(paramAnonymousDialogInterface, com.tencent.mm.ui.base.k.a((Context)localObject, SettingsAboutSystemUI.this.getString(b.i.app_waiting), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(74045);
              SettingsAboutSystemUI.a(SettingsAboutSystemUI.this, true);
              AppMethodBeat.o(74045);
            }
          }));
          paramAnonymousDialogInterface = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().nd(null);
          if ((paramAnonymousDialogInterface != null) && (paramAnonymousDialogInterface.size() > 0))
          {
            localObject = u.bR(paramAnonymousDialogInterface);
            if (localObject != null) {
              while (paramAnonymousInt < ((List)localObject).size())
              {
                if (((Boolean)((List)localObject).get(paramAnonymousInt)).booleanValue()) {
                  com.tencent.mm.plugin.setting.c.pFo.iC((String)paramAnonymousDialogInterface.get(paramAnonymousInt));
                }
                paramAnonymousInt += 1;
              }
            }
          }
          br.a(new br.a()
          {
            public final boolean aMJ()
            {
              AppMethodBeat.i(74046);
              boolean bool = SettingsAboutSystemUI.b(SettingsAboutSystemUI.this);
              AppMethodBeat.o(74046);
              return bool;
            }
            
            public final void aMK()
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
          ac.bN("clearAllMsg", System.currentTimeMillis() / 1000L);
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
      com.tencent.mm.br.c.b(getContext(), "emoji", ".ui.EmojiMineUI", paramf);
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settngs_clean"))
    {
      if (!com.tencent.mm.kernel.h.baE().isSDCardAvailable())
      {
        aa.j(getContext(), null);
        AppMethodBeat.o(74058);
        return true;
      }
      com.tencent.mm.br.c.b(getContext(), "clean", ".ui.CleanUI", new Intent());
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_traffic_statistic"))
    {
      paramf = new Intent(this, SettingsNetStatUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goToSetTrafficStatistic", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goToSetTrafficStatistic", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_text_size"))
    {
      bool1 = gVt();
      AppMethodBeat.o(74058);
      return bool1;
    }
    if (paramf.equals("settings_swipeback_mode"))
    {
      paramf = (CheckBoxPreference)paramPreference;
      bool1 = com.tencent.mm.compatible.h.a.aPR();
      if (!bool1) {}
      for (i = b.i.settings_swipeback_mode_open_tips;; i = b.i.settings_swipeback_mode_close_tips)
      {
        com.tencent.mm.ui.base.k.a(getContext(), getString(i), null, new SettingsAboutSystemUI.3(this), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(74044);
            paramf.setChecked(bool1);
            SettingsAboutSystemUI.a(SettingsAboutSystemUI.this).notifyDataSetChanged();
            AppMethodBeat.o(74044);
          }
        });
        AppMethodBeat.o(74058);
        return true;
      }
    }
    if (paramf.equals("settings_take_photo"))
    {
      paramf = new Intent(this, SettingsAboutCamera.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(74058);
      return false;
      if (paramf.equalsIgnoreCase("settngs_matrix_trace"))
      {
        if (!com.tencent.matrix.c.isInstalled())
        {
          Toast.makeText(this, "Matrix is never installed", 0).show();
          AppMethodBeat.o(74058);
          return false;
        }
        paramf = new Intent();
        paramf.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.matrix.MatrixSettingUI");
        paramf.addFlags(67108864);
        paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (paramf.equals("settings_dark"))
      {
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_red_dot", false);
        paramf = new Intent(this, SettingDarkMode.class);
        paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetDarkMode", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetDarkMode", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74056);
    super.onResume();
    eAL();
    AppMethodBeat.o(74056);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI
 * JD-Core Version:    0.7.0.1
 */